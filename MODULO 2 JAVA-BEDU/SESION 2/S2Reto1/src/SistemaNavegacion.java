
import java.util.concurrent.Callable;
// Clase que representa el sistema de navegación de la misión espacial
// Implementa Callable para poder ser ejecutada por un ExecutorService y devolver un resultado
public class SistemaNavegacion implements Callable<String>{

    // Método que se ejecuta cuando el sistema es llamado por un hilo
    @Override
    public String call () throws Exception{
        // Simula el tiempo de procesamiento del sistema (1 segundo)
        Thread.sleep(1000);
        //Devuelve un mensaje indicando que la trayectoria fue corregida exitosamente
        return "\uD83D\uDEF0\uFE0F Navegación: Trayectoria corregida con éxito.";
    }
}
