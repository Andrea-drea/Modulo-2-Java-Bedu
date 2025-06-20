import java.util.*;
import java.util.stream.*;

public class Principal {
    public static void main(String[] args) {


        //Se crea una lista de sucursales, cada una con su lista de encuestas
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Ali", "El tiempo de espera fue largo", 2),
                        new Encuesta("Andy", null, 5))),
                new Sucursal("Norte", List.of(
                        new Encuesta("Carlos", "La atención fue buena, pero la limpieza puede mejorar", 3),
                        new Encuesta("Paola", null, 4)
                ))
        );

        //Procesamiento con Stream API para generar mensajes de seguimiento
        List<String> msg = sucursales.stream()
                .flatMap(sucursal -> //Aplanar todas las encuestas de todas las sucursales
                        sucursal.getEncuesta().stream()
                                .filter(e -> e.getCalificacion() <= 3) //Solo encuestas con mala calificación (3 o menos)
                                .map(e -> e.getComentario() // Se obtiene el comentario (Optional<String>)
                                        .map(c -> "Sucursal " + sucursal.getNombre() +
                                                ": Seguimiento a paciente con comentario: \"" + c + "\""))
                                .filter(Optional::isPresent) // Se filtran encuestas con comentario (descarta los null)
                                .map(Optional::get)  //Se extrae el texto del comentario (ya no es Optional)
                )
                .collect(Collectors.toList()); // Se recopilan todos los mensajes en una lista

        //Imprimir los mensajes de seguimiento
        msg.forEach(System.out::println);
    }

    // Clase auxiliar para unir datos de Encuesta con la sucursal (* aunque no se usa en este ejemplo)
    static class Seguimiento {
        private final Encuesta encuesta;
        private final String sucursal;

        public Seguimiento(Encuesta encuesta, String sucursal) {
            this.encuesta = encuesta;
            this.sucursal = sucursal;
        }

        public Encuesta getEncuesta() { return encuesta; }
        public String getSucursal() { return sucursal; }
    }
}
