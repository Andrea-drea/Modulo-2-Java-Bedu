import java.util.List;
//Clase utilitaria que agrupa metodos estaticos para trabajar con ordenes de produccion
public class Metodos {
    //Metodo generico para leer cualquier tipo de orden y mostrar sus datos
    //// Usa "? extends OrdenProduccion" para aceptar listas de subtipos de OrdenProduccion
    public static void mostrarOrdenes (List<? extends OrdenProduccion> lista){
        System.out.println("\n📋 Órdenes registradas:");
        for (OrdenProduccion orden : lista){
            orden.mostrarResumen();// Llama al método sobrescrito en cada subclase
        }
    }


    // Método para procesar órdenes personalizadas
    // Usa "? super OrdenPersonalizada" para aceptar listas de OrdenPersonalizada o su superclase
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n💰 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            // Se verifica que el objeto sea una instacnica de OrdenPersonalizada
            if (obj instanceof OrdenPersonalizada) {
                //Se aplica el costo adicional usando el metodo de la subclase
                ((OrdenPersonalizada) obj).ajustarCosto(costoAdicional);
            }
        }
    }

    //Metodo que cuenta cuántas ordenes hay de cada tipo usando instanceof
    public static void contarOrdenes (List<OrdenProduccion>total){
        int masa = 0, personalizadas = 0, prototipos = 0;
        //Se recorre la lista total y se cuentan por tipo de orden
        for (OrdenProduccion orden : total){
            if (orden instanceof OrdenMasa) masa++;
            else if (orden instanceof OrdenPersonalizada) personalizadas++;
            else if (orden instanceof OrdenPrototipo)prototipos++;
        }
        //Se imprime el resumen total
        System.out.println("\n📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + masa);
        System.out.println("🛠️ Personalizadas: " + personalizadas);
        System.out.println("🧪 Prototipos: " + prototipos);
    }
}
