/*====================================
    Práctica 10
    Programación Orientada a Objetos 2027-1

    Landeros López Victor Manuel.
    Equipo 1
    No: 3-16229849
====================================*/

import java.util.Scanner;

public class ExcepcionNullPointer {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // == Declaración y definición de variables ==
        String nombre;

        // == Interacción con el usuario ==
        System.out.print("Ingresa tu nombre (deja vacío para provocar la excepción): ");
        nombre = entrada.nextLine();

        // == Operación y manejo de excepción ==
        try {

            if (nombre.isEmpty()) {
                nombre = null;
            }

            System.out.println("La longitud de tu nombre es: " + nombre.length());

        } catch (NullPointerException e) {

            System.out.println("Error: Se intentó utilizar una variable con valor null.");
            System.out.println("Se ha detectado una excepción NullPointerException.");

        }

    }
}
