//Subclase que representa una orden de producción en masa
public class OrdenMasa extends OrdenProduccion{

    //Constructor que llama al constructor de la clase base (OrdenProduccion)
    public OrdenMasa (String codigo, int cantidad){
        super (codigo, cantidad); //Se inicializan los atributos heredados
    }

    //Se sobrescribe el método mostrarResumen para personalizar la salida
    @Override
    public void mostrarResumen (){
        //Muestra un resumen con un ícono que indica que es una orden en masa
        System.out.println("🔧 OrdenMasa - Código: " + codigo + " - Cantidad: " + cantidad);
    }
}
