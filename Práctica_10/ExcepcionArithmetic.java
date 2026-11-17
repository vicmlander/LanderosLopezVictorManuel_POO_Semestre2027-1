/*====================================
    Práctica 10
    Programación Orientada a Objetos 2027-1

    Programa que solicita dos números al usuario y realiza
    una división, demostrando el manejo de la excepción
    ArithmeticException cuando se intenta dividir entre cero.

    Landeros López Victor Manuel.
    Equipo 1
    No: 3-16229849
====================================*/

import java.util.Scanner;

public class ExcepcionArithmetic {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // == Declaración y definición de variables ==
        int a;
        int b;
        int resultado;

        // == Interacción con el usuario ==
        System.out.print("Ingresa el primer número: ");
        a = entrada.nextInt();

        System.out.print("Ingresa el segundo número: ");
        b = entrada.nextInt();

        // == Operación y manejo de excepción ==
        try {

            resultado = a / b;

            System.out.println("El resultado de la división es: " + resultado);

        } catch (ArithmeticException e) {

            System.out.println("Error: No se puede dividir entre cero.");
            System.out.println("Se ha detectado una excepción ArithmeticException.");

        }

    }
}
