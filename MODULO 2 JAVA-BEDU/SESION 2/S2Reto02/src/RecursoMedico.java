import java.util.concurrent.locks.ReentrantLock;

//Clase que representa un recurso médico compartido, como una sala de cirugia
public class RecursoMedico {
    //Nombre del recurso (p.ejemplo, "Sala de cirugía")
    private final String nombre;
    //Constructor que inicializa el nombre del recurso
    private final ReentrantLock lock = new ReentrantLock();

    //Constructor que inicializa el nombre del recurso
    public RecursoMedico (String nombre){
        this.nombre = nombre;
    }

    //Metodo que simula el uso del recurso por parte de un profesional
    public void usar(String profesional){
        //Se adquiere el lock antes de usar el recurso
        lock.lock();

        try{
            //Simula que el profesional entra y utiliza la sala
            System.out.println("👨‍⚕️ " + profesional + " ha ingresado a " + nombre);
            Thread.sleep(1000);//Simula el tiempo que ocupa la sala
            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e){
            //Manejo de interrupciones
            System.out.println("❌ " + profesional + " fue interrumpido.");
        } finally {
            //Se libera el lock para que otros puedan acceder
            lock.unlock();
        }
    }
}
