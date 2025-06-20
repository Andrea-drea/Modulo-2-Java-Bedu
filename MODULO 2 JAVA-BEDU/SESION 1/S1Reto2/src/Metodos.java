
import java.util.List;
import java.util.function.Predicate;
public class Metodos {

    /**
     * Muestra los detalles de cualquier tipo de material que herede de MaterialCurso.
     * Se usa <? extends MaterialCurso> para permitir listas de subclases como Video, Articulo o Ejercicio.
     */
    public static void mostrarMateriales(List<? extends MaterialCurso> lista){
        System.out.println("\n📚 Materiales del curso:");
        for (MaterialCurso material : lista){
            material.mostrarDetalle();
        }
    }

    /**
     * Calcula la duración total de todos los videos en la lista.
     * Se usa <? extends Video> para permitir listas del tipo Video o subtipos (si existieran).
     */
    public static void contarDuracionVideos (List<? extends Video> lista){
        int total = 0;
        for (Video video: lista){
            total += video.getDuracion(); //Acumula duración de cada video
        }
        System.out.println("\n🎥 Duración total de videos: " + total + " minutos");
    }

    /**
     * Marca todos los ejercicios de la lista como revisados.
     * Se usa <? super Ejercicio> para aceptar listas de Ejercicio o de superclases (por ejemplo, List<MaterialCurso>).
     * Se utiliza instanceof para asegurar que el objeto es un Ejercicio antes de hacer el casting.
     */
    public static void marcarEjerciciosRevisados (List<? super Ejercicio> lista){
        for (Object obj : lista){
            if (obj instanceof Ejercicio){
                ((Ejercicio) obj).marcarRevisado();//Cambia el estado a revisado
            }
        }
    }

    /**
     * Filtra materiales de cualquier subtipo de MaterialCurso usando una expresión Predicate.
     * Es útil para buscar por autor, título, etc.
     * Uso de genérico <T extends MaterialCurso> para mantener el tipo y aprovechar el Predicate<T>.
     */
    public static <T extends MaterialCurso> void filtrarPorAutor(List<T> lista, Predicate<T> filtro){
        System.out.println("\n🔍 Filtrando materiales por autor:");
        for (T material: lista){
            if (filtro.test(material)){
                material.mostrarDetalle(); //Solo muestra los materiales que cumplen con la condición
            }
        }
    }
}
