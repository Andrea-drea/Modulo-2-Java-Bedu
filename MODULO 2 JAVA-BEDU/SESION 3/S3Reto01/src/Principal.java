import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class Principal {
    public static void main(String[] args) {

        //Lista de pedidos realizados por clientes
        List<Pedido> pedidos = Arrays.asList(
                new Pedido("Luis", "Domicilio", "555-1234"),
                new Pedido("Juan", "Domicilio", "555-5678"),
                new Pedido("Mary","Local","null")
        );

        System.out.println("Procesando confirmación...\n");

        //Procesamiento usando Stream API
        pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("Domicilio"))
                .map(Pedido::getTelefono)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(telefono -> "\uD83D\uDCDE Confirmación enviada al número: "+ telefono)
                //Mostramos el mensaje en consola
                .forEach(System.out::println);

    }
}
