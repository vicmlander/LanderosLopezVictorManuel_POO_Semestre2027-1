/* =====================================================
Práctica 12
Coronado Ramirez Luis Angel
426059057
clase que implementa la interfaz: aqui tendra su vida util el hilo que se
implemente con runnable
===================================================== */

package Práctica_12.Programa_2;
import java.lang.*;


public class Soldado extends Personaje implements Runnable{//hereda de personaje e implementa runnable

    private int numeroMedallas;// atributo privado

    public Soldado() {
    }

    public Soldado(int numeroMedallas, String nombre, int nivelVida) {//constructor con sobrecarga
        super(nombre, nivelVida);//super para utilizar el contructor del padre agregando los atributos deseados
        this.numeroMedallas = numeroMedallas;
        
         Thread t1 = new Thread(this);//objeto de tipo hilo
         t1.start();// inicializacion del hilo
    }

    @Override//sobrescritura para el metodo run de la interfaz
    public void run() {
       while (getNivelVida() > 0) {//ciclo while para mantener el hilo ejecutandose

        System.out.println("Se está jugando con: " + getNombre());//mensaje en pantalla
        try {//bloque try catch en caso de excepcion cuando mandemos al hilo a dormir
            Thread.sleep(500);//duerme al hilo .5 segundos
        } catch (Exception e) {//excepcion generica
            return;//simplemente regresa
        }

        setNivelVida(getNivelVida() - 1);//al finalizar cada ciclo le quita vida al soldado
    }
    if(getNivelVida()==0){//si esta llega a 0 se imprime en pantalla un mensaje notificandolo
        System.out.println("Ha muerto "+getNombre());
    }
}

public static void main(String[] args) {
    new Soldado(11, "Price", 5);//cada objeto soldado tiene su propio hilo 
    new Soldado(10, "Soap", 3);
}

}
