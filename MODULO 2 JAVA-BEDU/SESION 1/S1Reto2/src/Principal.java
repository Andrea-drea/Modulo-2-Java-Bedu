
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main (String[]args){
        //Crear instancias de video con titulo, autor y duracion
        Video v1 = new Video("Introducción a Java","Mario", 15);
        Video v2 = new Video ("POO en Java", "Carlos", 20);
        //Instancias de articulo con titulo, autor y cantidad de palabras
        Articulo a1 = new Articulo("Historia de Java", "Ana", 1200);
        Articulo a2= new Articulo("Tipos de datos", "Luis", 800);
        //Instancias de ejercicio con titulo y autor
        Ejercicio e1= new Ejercicio("Variables y tipos", "Luis");
        Ejercicio e2= new Ejercicio("Condicionales", "Mario");

        //Lista general que contiene cualquier tipo de MaterialCurso
        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.add(v1);
        materiales.add(v2);
        materiales.add(a1);
        materiales.add(a2);
        materiales.add(e1);
        materiales.add(e2);

        //Mostrar todos los materiales usando un metodo genérico
        Metodos.mostrarMateriales(materiales);

        //Crear lista especifica solo de videos para calcular la duración total
        List<Video> listaVideos = new ArrayList<>();
        listaVideos.add(v1);
        listaVideos.add(v2);
        Metodos.contarDuracionVideos(listaVideos);

        //Crear lista especifica de ejercicios (aunque no se usa aquí directamente)
        List<Ejercicio> listaEjercicios = new ArrayList<>();
        listaEjercicios.add(e1);
        listaEjercicios.add(e2);

        Metodos.marcarEjerciciosRevisados(listaEjercicios);

        //Filtrar y mostrar materiales cuyo autor sea "Mario" (reto adiciona con Predicate)
        Metodos.filtrarPorAutor(materiales, m-> m.getAutor().equalsIgnoreCase("Mario"));
    }
}
