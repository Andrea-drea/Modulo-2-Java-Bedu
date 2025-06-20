import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Principal {
    public static void main(String[] args) {

        //Mensaje inicial de la simulación
        System.out.println("\uD83D\uDE80 Simulación de misión espacial iniciada...");
       //SE crea un pool de hilos con 4 hilos para ejecutar tareas concurrentemente
        ExecutorService executor= Executors.newFixedThreadPool(4);

        // Se envían tareas al executor y se almacenan los resultados en objetos Future
        Future<String> nav = executor.submit(new SistemaNavegacion());//Tarea del sistema de navegación
        Future<String> sopVital = executor.submit(new SistemaSoportevital());//Tarea del sistema de soporte vital
        Future<String> sisTermico = executor.submit(new SistemaControlTermico());//Tarea del sistema de control térmico
        Future<String> sisComunicacion = executor.submit(new SistemaComunicaciones());//Tarea del sistema de comunicaciones

        try{
            //Se obtiene y muestra el resultado de cada sistema (puede bloquear hasta que termine)
            System.out.println(nav.get());
            System.out.println(sopVital.get());
            System.out.println(sisTermico.get());
            System.out.println(sisComunicacion.get());
        } catch (InterruptedException | ExecutionException e){
            //En caso de error durante la ejecución, se muestra el mensaje
            System.out.println("Error durante la ejecución: " + e.getMessage());
        } finally {
            //Se cierra el executor para liberar los recursos
            executor.shutdown();
        }
        //Mensaje final indicando que todos los sistemas están operativos
        System.out.println("✅ Todos los sistemas reportan estado operativo.");
    }
}
