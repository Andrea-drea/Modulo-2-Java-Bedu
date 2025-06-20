//Subclase que representa una orden personalizada (adaptada al cliente)
class OrdenPersonalizada extends OrdenProduccion{
    //Atributo adicional que identifica al cliente
    private String cliente;

    //Constructor que inicializa los atributos heredados y el cliente
    public OrdenPersonalizada (String codigo, int cantidad, String cliente){
        super (codigo, cantidad);
        this.cliente = cliente;
    }

    //Metodo especifico para esta clase que aplica un costo adicional
    public void ajustarCosto (int costoAdicional){
        //Muestr que la orden fue ajustada con un cargo extra
        System.out.println("✅ Orden " + codigo + " ajustada con costo adicional de $" + costoAdicional);
    }

    //Sobrescribe el metodo mostrarResumen para incluir el nombre del cliente
    @Override
    public void mostrarResumen (){
            System.out.println("🛠️ OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad + " - Cliente: " + cliente);
    }
}
