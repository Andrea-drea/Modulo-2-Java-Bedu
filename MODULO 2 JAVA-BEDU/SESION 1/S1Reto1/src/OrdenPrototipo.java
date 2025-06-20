//Subclase que representa una orden de tipo (en fase de prueba o desarrollo
public class OrdenPrototipo extends OrdenProduccion{
    //Atributo especifico que indica la fase de desarrollo del prototipo
    String faseDesarrollo;

    //Constructor que inicializa atributos heredados y la fase de desarrollo
    public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo){
        super (codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    //Metodo sobrescrito para mostrar información especifica del prototipo.
    @Override
    public void mostrarResumen (){
        System.out.println("🧪 OrdenPrototipo - Código: " + codigo + " - Cantidad: " + cantidad + " - Fase: " + faseDesarrollo);
    }
}
