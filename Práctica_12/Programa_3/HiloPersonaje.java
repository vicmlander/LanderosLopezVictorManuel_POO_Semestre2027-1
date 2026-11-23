package Práctica_12.Programa_3;


public class HiloPersonaje extends Personaje implements Runnable {

    private Thread hilo;

    public HiloPersonaje(String nombre, int vida) {
        super(nombre, vida);
        hilo = new Thread(this);
    }

    public void iniciar() {
        hilo.start();
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                getNombre() +
                " está entrenando. Nivel de entrenamiento: " + i
            );

            try {
                Thread.sleep(1000); // pausa de 1 segundo
            } catch (InterruptedException e) {
                System.out.println("Error en el hilo.");
            }
        }

        System.out.println(getNombre() + " ha terminado su entrenamiento.");
    }
}
