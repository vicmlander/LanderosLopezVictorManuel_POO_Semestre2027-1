/*====================================

    Ejercicio de Herencia y Sobrecarga

    Landeros López Victor Manuel.
    No: 3-16229849

====================================*/

import java.util.Scanner;

public class Gato extends Animal {

    // == Método 1: Herencia y super ==
    public void hacerSonido() {
        super.hacerSonido();
        System.out.println("El gato hace miau.");
    }

    // == Método 2: Sobrecarga ==
    public void hacerSonido(String sonido) {
        super.hacerSonido(sonido);
        System.out.println("El gato también puede ronronear.");
    }

    // == Método 3: Override ==
    @Override
    public void comportamiento() {
        System.out.println("El gato se encuentra durmiendo.");
    }

    // == Creación de objetos ==
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Gato gato = new Gato();
        int opcion;
        String sonido;

        // == Interacción con el usuario ==
        System.out.println("=== PROGRAMA DE HERENCIA Y SOBRECARGA ===");
        System.out.println("1. Hacer sonido con super");
        System.out.println("2. Hacer sonido con sobrecarga");
        System.out.println("3. Mostrar comportamiento del gato");
        System.out.print("Selecciona una opción: ");
        opcion = sc.nextInt();
        sc.nextLine();

        // == Operaciones ==
        if (opcion == 1) {
            gato.hacerSonido();
        } else if (opcion == 2) {
            System.out.print("Ingresa un sonido: ");
            sonido = sc.nextLine();
            gato.hacerSonido(sonido);
        } else if (opcion == 3) {
            gato.comportamiento();
        } else {
            System.out.println("Opción no válida.");
        }

    }
}
