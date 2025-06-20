//Clase ejercicio que hereda de MaterialCurso
public class Ejercicio extends MaterialCurso {
    //Atributo adicional que indica si el ejercicio ha sido revisado o no
    private boolean revisado;

    /**
     * Constructor que recibe el título y autor del ejercicio.
     * Inicializa el estado revisado como false por defecto.
     */
    public Ejercicio(String titulo, String autor){
        super(titulo, autor); // Llama al constructor de la clase padre (MaterialCurso)
        this.revisado= false;
    }

    /**
     * Método para marcar el ejercicio como revisado (revisado = true).
     * También imprime un mensaje confirmando la acción.
     */
    public void marcarRevisado (){
        this.revisado= true;
        System.out.println("✅ Ejercicio '" + titulo + "' marcado como revisado.");
    }

    /**
     * Implementación del método abstracto mostrarDetalle().
     * Muestra la información específica del ejercicio, incluyendo su estado de revisión.
     */
    @Override
    public void mostrarDetalle(){
        System.out.println("📝 Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado);

    }
    // Método opcional para acceder al título desde fuera (útil en casting desde Object)
    public String getTitulo() {
        return titulo;
    }

    // (Opcional) Agregar un getter para saber si está revisado
    public boolean isRevisado() {
        return revisado;
    }
}

