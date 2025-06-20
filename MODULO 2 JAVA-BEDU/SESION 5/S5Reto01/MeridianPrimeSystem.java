package org.bedu.reactivo;

import java.util.Random;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import java.time.Duration;

public class MeridianPrimeSystem {
    static Random random = new Random();
    public static void main(String[] args) throws InterruptedException{
        Flux<String> trafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101))
                .filter(nivel -> nivel > 70)
                .map(nivel -> " 🚗 Congestion del " + nivel + "% en Avenida solar")
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.parallel());

        Flux<String> accidentes = Flux.interval(Duration.ofMillis(800))
                .map(i -> {
                    String[] niveles = {"Baja", "Media", "Alta"};
                    return niveles[random.nextInt(niveles.length)];
                })
                .filter(prioridad -> prioridad.equals("Alta"))
                .map(p -> " 🚑 Emergencia vial " + p)
                .subscribeOn(Schedulers.parallel());

        Flux<String> contaminacion = Flux.interval(Duration.ofMillis(600))
                .map(i -> random.nextInt(101))
                .filter(pm -> pm > 50)
                .map(pm -> " 🌫️ Contaminacion alta " + pm + " ug/m3")
                .subscribeOn(Schedulers.parallel());

        Flux<String> trenes = Flux.interval(Duration.ofMillis(700))
                .map(i -> random.nextInt(11))
                .filter(min -> min > 5)
                .map(min -> " 🚝 Tren con retraso " + min + " minutos")
                .delayElements(Duration.ofMillis(300))
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.parallel());

        Flux<String> semaforos = Flux.interval(Duration.ofMillis(400))
                .map(i -> {
                    String[] estados = {"verde", "amarillo", "rojo"};
                    return estados[random.nextInt(estados.length)];
                })
                .buffer(5,1)
                .filter(lista -> lista.stream().filter(e -> e.equals("rojo")).count() >= 3)
                .map(lista -> " 🚦 Semaforo detecto rojo tres veces ")
                .subscribeOn(Schedulers.parallel());

        Flux.merge(trafico, contaminacion, accidentes, trenes, semaforos)
                .window(Duration.ofSeconds(1))
                .flatMap(window -> window.collectList()
                        .filter(lista -> lista.size() >= 3)
                        .doOnNext(lista -> {
                            lista.forEach(System.out::println);
                            System.out.println(" 🚨 Alerta multiples eventos detectados ");
                        })
                )
                .subscribe();
        Thread.sleep(5000);
    }
}

