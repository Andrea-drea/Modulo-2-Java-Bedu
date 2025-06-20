// Clase Video que hereda de la clase abstracta MaterialCurso
public class Video extends MaterialCurso{
    // Atributo específico del video: duración en minutos
    private int duracion;

    public Video (String titulo, String autor, int duracion){
        super (titulo, autor);
        this.duracion = duracion;
    }

    public int getDuracion(){
        return duracion;
    }
    /**
     * Implementación del método abstracto mostrarDetalle().
     * Muestra los datos específicos del video, incluyendo duración.
     */
    @Override
    public void mostrarDetalle (){
        System.out.println("🎥 Video: " + titulo + " - Autor: " + autor + " - Duración: " + duracion + " min");
    }
}
