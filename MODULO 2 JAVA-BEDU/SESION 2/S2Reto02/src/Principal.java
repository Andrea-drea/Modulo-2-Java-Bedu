import java.util.concurrent.*;

//Clase principal que simula el acceso concurrente de médicos a una sala de cirugia
public class Principal {
    public static void main (String[]args){

        //Mensaje inicial de la simulación
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...");

        //Se crea un recurso compartido: La Sala de cirugía
        RecursoMedico salaCirugia= new RecursoMedico("Sala de cirugía");

        //Se definen tareas para los doctores, que intentarán usar la sala de cirugia
        Runnable dr1 = () -> salaCirugia.usar("Dra.Sánchez");
        Runnable dr2 = () -> salaCirugia.usar("Dr. Gómez");
        Runnable dr3 = () -> salaCirugia.usar("Dra.Zavaleta");
        Runnable dr4 = ()-> salaCirugia.usar("Dr.Torres");

        //Se crea un pool de 4 hilos para ejecutar las tareas de manera concurrente
        ExecutorService executor= Executors.newFixedThreadPool(4);
        //Se envían las tareas al executor para su ejecución
        executor.execute(dr1);
        executor.execute(dr2);
        executor.execute(dr3);
        executor.execute(dr4);
        //Se cierra el executor una vez enviadas todas las tareas
        executor.shutdown();
    }
}
