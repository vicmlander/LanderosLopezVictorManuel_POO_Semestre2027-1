/*====================================

    Ejercicio de Herencia y Sobrecarga

    Landeros López Victor Manuel.
    No: 3-16229849

====================================*/

public class Animal {

    // == Método 1 ==
    public void hacerSonido() {
        System.out.println("El animal hace un sonido.");
    }

    // == Método 2: Sobrecarga ==
    public void hacerSonido(String sonido) {
        System.out.println("El animal hace este sonido: " + sonido);
    }

    // == Método 3: Método para sobrescribir ==
    public void comportamiento() {
        System.out.println("El animal se encuentra caminando.");
    }
}