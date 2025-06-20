import java.util.List;
public class Sucursal {
    private String nombre;
    private List<Encuesta>encuestas;

    //Constructor que inicializa el nombre y la lista de encuestas
    public Sucursal(String nombre, List<Encuesta> encuestas){
        this.nombre = nombre;
        this.encuestas = encuestas;
    }

    //Devuelve la lista de encuestas de esta sucursal
    public List <Encuesta> getEncuesta(){
        return encuestas;}

    //Devuelve el nombre de la sucursal
    public String getNombre(){
        return nombre;}
}
