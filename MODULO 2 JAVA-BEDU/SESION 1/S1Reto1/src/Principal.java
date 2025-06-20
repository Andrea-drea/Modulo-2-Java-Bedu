import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

      //Se crea una lista de ordenes de produccion en masa
      List <OrdenMasa> ordenesMasa = new ArrayList<>();
      ordenesMasa.add (new OrdenMasa("A123", 500));
      ordenesMasa.add (new OrdenMasa("A124", 750));

      //Lista de ordenes personalizadas, con información del cliente.
      List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
      ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
      ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

      //Lista de ordenes de prototipos, con fase de desarrollo
      List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
      ordenesPrototipo.add (new OrdenPrototipo("T789", 10,"Diseño"));
      ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));

      //Se muestra la información de cada lista usando un metodo generico.
      Metodos.mostrarOrdenes(ordenesMasa);
      Metodos.mostrarOrdenes(ordenesPersonalizadas);
      Metodos.mostrarOrdenes(ordenesPrototipo);

      //Se procesan las ordenes personalizadas aplicando un costo adicional de 200
      Metodos.procesarPersonalizadas(new ArrayList<>(ordenesPersonalizadas), 200);

      //Se crea una lista combinada con todas las ordenes para contar por tipo
      List<OrdenProduccion> total = new ArrayList<>();
      total.addAll(ordenesMasa);
      total.addAll(ordenesPersonalizadas);
      total.addAll(ordenesPrototipo);

      //Se llama al metodo que cuenta cuántas hay de cada tipo
      Metodos.contarOrdenes(total);
    }
}
