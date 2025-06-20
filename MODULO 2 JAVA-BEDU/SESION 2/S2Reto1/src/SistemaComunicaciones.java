import java.util.concurrent.Callable;
// Clase que representa el sistema de comunicaciones de la misión espacial
// Implementa Callable para que pueda ejecutarse de forma concurrente y retornar un mensaje
public class SistemaComunicaciones implements Callable<String> {


    //Metodo que será ejecutado por un hilo cuando se llame al sistema
    @Override
    public String call() throws  Exception{
        //Simula el tiempo necesario para establecer el enlace de comunicación (1.3 segundos)
        Thread.sleep(1300);
        //Mensaje devuelto
        return "\uD83D\uDCE1 Comunicaciones: Enlace con estación terrestre establecido";
    }
}
