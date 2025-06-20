
import java.util.Optional;
public class Pedido {

    private String cliente;
    private String tipoEntrega;
    private String telefono;

    //Constructor que inicializa los campos del pedido
    public Pedido(String cliente, String tipoEntrega, String telefono){
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    //Devuelve el tipo de entrega del pedido
    public String getTipoEntrega(){
        return  tipoEntrega;
    }

    //Devuelve el telefono del cliente como un Optional
    public Optional<String>getTelefono(){
        return Optional.ofNullable(telefono);
    }
}
