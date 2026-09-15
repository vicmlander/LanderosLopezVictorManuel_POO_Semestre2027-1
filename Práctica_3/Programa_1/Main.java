/*====================================
    Práctica 3
    Programación Orientada a Objetos 2027-1

    Landeros López Victor Manuel.
    Equipo 1
    No: 3-16229849
====================================*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // == Librerías ==
        Scanner sc = new Scanner(System.in);

        // == Creación de objetos ==
        Integer edad;
        Double promedio;

        // == Asignación a tipos primitivos==
        System.out.println("===== DATOS DEL ALUMNO =====");

        System.out.println("Ingrese su edad:");
        int edadNumero = sc.nextInt();

        System.out.println("Ingrese su promedio:");
        double promedioNumero = sc.nextDouble();

        // == Autoboxing ==
        edad = edadNumero;
        promedio = promedioNumero;

        // == Impresión en pantalla ==
        System.out.println("\n===== RESULTADOS =====");

        System.out.println("Edad: " + edad);
        System.out.println("Promedio: " + promedio);

        System.out.println("\n===== WRAPPERS =====");

        System.out.println("El tipo de la edad es: " + edad.getClass().getSimpleName());
        System.out.println("El tipo del promedio es: " + promedio.getClass().getSimpleName());

    }
}