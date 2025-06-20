// Clase Articulo que extiende de la clase abstracta MaterialCurso
public class Articulo extends MaterialCurso{
    // Atributo específico del artículo: número de palabras
    private int palabras;

    //Constructor que inicializa un artículo con su título, autor y cantidad de palabras.
    public Articulo(String titulo, String autor, int palabras){
        super (titulo, autor);// Llama al constructor de la clase padre (MaterialCurso)
        this.palabras= palabras;
    }

    /**
     * Implementación del método abstracto mostrarDetalle().
     * Muestra los datos específicos del artículo, incluyendo su número de palabras.
     */
    @Override
    public void mostrarDetalle(){
        System.out.println("📄 Artículo: " + titulo + " - Autor: " + autor + " - Palabras: " + palabras);
    }
}
