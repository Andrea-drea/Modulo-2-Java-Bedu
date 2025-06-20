
import  java.util.concurrent.Callable;
// Clase que representa el sistema de soporte vital en la misión espacial
// Implementa Callable para poder ejecutarse en un hilo y devolver un resultado tipo String
public class SistemaSoportevital implements Callable<String>{
   //Metodo que contiene la lógica a ejecutar por el hilo
    @Override
    public String call () throws Exception{
        // Simula el tiempo de análisis del sistema de soporte vital (1.2 segundos)
        Thread.sleep(1200);

        // Retorna un mensaje indicando que los parámetros están dentro del rango adecuado
        return "\uD83E\uDDEA Soporte Vital: presión y oxígeno dentro de parámetros normales";
    }
}
