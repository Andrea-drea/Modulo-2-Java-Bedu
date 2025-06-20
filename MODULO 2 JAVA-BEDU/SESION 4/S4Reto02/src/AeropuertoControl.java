import java.util.Random;
import java.util.concurrent.*;

public class AeropuertoControl {

    //// Generador de números aleatorios para simular fallos en los servicios
    private static final Random random = new Random();

    //Verificar disponibilidad de la pista (con fallo aleatorio)
    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(2); //Simula espera de 2 segundos
            boolean disponible = random.nextInt(100) < 80; // 80% de probabilidad de éxito
            System.out.println("🛣️ Pista disponible: " + disponible);
            return disponible;
        });
    }

    //Verifica que el clima sea favorable (85% de probabilidad)
    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(3);//Simula espera de 3 segundos
            boolean favorable = random.nextInt(100) < 85; // 85% de probabilidad
            System.out.println("🌦️ Clima favorable: " + favorable);
            return favorable;
        });
    }

    //Verifica que el tráfico este despejado (90% de probabilidad)
    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(2); //Simula espera de 2 seg
            boolean despejado = random.nextInt(100) < 90; // 90% de probabilidad
            System.out.println("🚦 Tráfico aéreo despejado: " + despejado);
            return despejado;
        });
    }

    //Verifica que haya personal en tierra disponible
    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(3);
            boolean disponible = random.nextInt(100) < 95; // 95% de probabilidad
            System.out.println("👷‍♂️ Personal disponible: " + disponible);
            return disponible;
        });
    }

    // Simula latencia en los servicios
    public static void simularLatencia(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos); // Pausa el hilo durante X segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura el estado de interrupción
        }
    }

    public static void main(String[] args) {

        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        //Ejecuta todas las verificaciones de forma asincronica
        CompletableFuture<Boolean> pistaFuture = verificarPista();
        CompletableFuture<Boolean> climaFuture = verificarClima();
        CompletableFuture<Boolean> traficoFuture = verificarTraficoAereo();
        CompletableFuture<Boolean> personalFuture = verificarPersonalTierra();

        //Espera a que todas las tareas estén completadas
        CompletableFuture<Void> allChecks = CompletableFuture.allOf(pistaFuture, climaFuture, traficoFuture, personalFuture);

        //Cuando todas estén listas, evalúa los resultados
        allChecks.thenApplyAsync(v -> {
                    try {
                        //Si hay un error, se lanza una excepcion para que la capture exceptionally
                        boolean condicionesOk = pistaFuture.get() && climaFuture.get() && traficoFuture.get() && personalFuture.get();
                        return condicionesOk;
                    } catch (Exception e) {
                        throw new RuntimeException("Error al obtener resultados", e);
                    }
                })
                //        // Según el resultado combinado, se muestra si el aterrizaje es autorizado o no
                .thenAccept(condicionesOk -> {
                    if (condicionesOk) {
                        System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                    } else {
                        System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                    }
                })
                // Captura cualquier error que ocurra en la cadena de ejecución
                .exceptionally(ex -> {
                    System.out.println("\n❌ Error en la verificación: " + ex.getMessage());
                    return null;
                });

        //Espera 10 segundos para que las tareas asincrónicas terminen antes de cerrar el programa
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}