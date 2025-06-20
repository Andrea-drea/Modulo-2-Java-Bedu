import java.util.concurrent.Callable;
// Clase que representa el sistema de control térmico en la misión espacial
// Implementa Callable para poder ejecutarse en un hilo y devolver un mensaje como resultado

public class SistemaControlTermico implements Callable<String>{

    //Metodo que se ejecuta al ser llamado por el ExecutorService
    @Override
    public String call() throws Exception{
        //Simula el tiempo de procesamiento del sistema (0.7 seg)
        Thread.sleep(700);
        //mensaje indicando la temperatura
        return "\uD83D\uDD25 Control Térmico: temperatura estable (22°C).";
    }
}
