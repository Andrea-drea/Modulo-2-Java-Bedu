import java.util.*;
//Clase que representa una encuesta respondida por un paciente
public class Encuesta {
    private String paciente;
    private String comentario;
    private int calificacion;

    //Constructor que inicializa los datos de la encuesta
    public Encuesta (String paciente, String comentario, int calificacion){
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    //Devuelve el nombre del paciente
    public String getPaciente(){
        return paciente; }

    //Devuelve la calificación otorgada por el paciente
    public int getCalificacion(){
        return calificacion;}

    //Devuelve el comentario como un Optional, que puede estar vacío si el comentario es null
    public Optional<String> getComentario(){
        return Optional.ofNullable(comentario);
    }

}
