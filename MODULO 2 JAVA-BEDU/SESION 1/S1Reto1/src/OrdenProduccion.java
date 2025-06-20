//Clase abstracta que representa una orden general de produccion
public abstract class OrdenProduccion {
    //Atributos comunes a todas las ordenes
    protected  String codigo;
    protected int cantidad;

    //Constructor que inicializa el código y la cantidad de la orden
    public OrdenProduccion (String codigo, int cantidad){
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    //Metodo que muestra un resumne basico de la orden
    public void mostrarResumen (){
        System.out.println("Codigo : " + codigo + "-cantidad: " + cantidad);
    }
}
