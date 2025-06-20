//Clase abstracta que representa un material generico dentro de un curso
public abstract class MaterialCurso {
    //Atributos
    protected String titulo;
    protected String autor;

    public MaterialCurso (String titulo, String autor){
        this.titulo= titulo;
        this.autor = autor;
    }

    public String getAutor(){
        return autor;
    }
    public abstract void mostrarDetalle();
}
