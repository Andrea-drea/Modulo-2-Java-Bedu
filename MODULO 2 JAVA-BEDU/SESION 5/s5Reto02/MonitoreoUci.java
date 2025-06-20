package org.bedu.reactivo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;

/**
 * Este programa simula el monitoreo de signos vitales de
 * 3 pacientes en una Unidad de Cuidados Intensivos (UCI).
 * Si algún valor está fuera de lo normal,
 * se muestra una alerta en la consola
 */
public class MonitoreoUci {

    //Usamos un generador aleatorio para simular valores de los signos vitales
    static final Random random= new Random();

    public static void main(String[] args) throws InterruptedException{
       //Se crean 3 flujos de pacientes, cada uno con su propio ID
        Flux<String> paciente1 = generarPaciente (1);
        Flux<String> paciente2 = generarPaciente(2);
        Flux<String> paciente3 = generarPaciente(3);

        Flux<String> flujoFusionado = Flux.merge(paciente1,paciente2,paciente3)
                .delayElements(Duration.ofSeconds(1)) //Se añade un pequeño retraso entre alertas
                .subscribeOn(Schedulers.parallel()); //Se ejecuta de forma paralela (en segundo plano)

        //Mostramos cada alerta que se reciba en la consola
        flujoFusionado
                .doOnNext(System.out::println)
                .subscribe();

        //Dejamos que el programa se ejecute por 20 segundos antes de terminar
        Thread.sleep(20000);
    }

    /**
     * Esta funcion simula el monitoreo de un paciente.
     * Cada cierto tiempo genera datos (como frecuencia cardiaca o presión)
     * y devuelve una alerta si algo está mal
     */
    static Flux<String> generarPaciente(int id){
        return Flux.interval(Duration.ofMillis(300)) //Cada 300 milisegundos se genera un nuevo dato
                .onBackpressureBuffer() // Si se acumulan muchos datos, se almacenan en un búfer (para no perderlos)
                .map(tick ->{
                    //Simula los signos vitales del paciente
                    int fc = random.nextInt(71)+ 40; //Frecuencia cardíaca (bpm)
                    int sistolica = random.nextInt(81)+ 80; // Presión sistólica (mmHg)
                    int diastolica = random.nextInt(51)+ 50; // Presión diastólica (mmHg)
                    int spo2 = random.nextInt(21)+80; // Nivel de oxígeno (SpO2 %)

                    // Verificamos si alguno de los valores está en un rango peligroso
                    if (fc< 50 || fc > 120){
                        return "⚠️ Paciente " + id + " - FC crítica: " + fc + " bpm";
                    } else if (spo2< 90) {
                        return  "⚠️ Paciente " + id + " - SpO2 baja: " + spo2 + "%";
                    } else if (sistolica< 90 || sistolica> 140 || diastolica< 60 || diastolica> 90 ){
                        return "⚠️ Paciente " + id + " - PA critica: " + sistolica + "/" + diastolica + " mmHg";
                    } else{
                        return ""; //Todo está bien, no se genera alerta.
                    }
                })
                .filter(msg -> !msg.isEmpty()) // Solo mostramos las alertas (no los valores normales)
                .subscribeOn(Schedulers.parallel()); // Este flujo se ejecuta también en segundo plano.
    }
}
