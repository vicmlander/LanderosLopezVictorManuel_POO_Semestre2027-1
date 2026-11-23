package Práctica_12.Programa_1;
/* =====================================================
Práctica 12
Villalobos Estrada Osvaldo
322024443
Programa principal: menú interactivo que lanza en hilos paralelos las operaciones elegidas y muestra sus resultados.
===================================================== */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_herencia1_pr12 {

    // Pide un entero y repite la pregunta hasta que sea válido y esté dentro del rango [min, max]
    static int leerEntero(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(linea);
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("El valor debe estar entre " + min + " y " + max);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida, escribe un número entero");
            }
        }
    }

    static void mostrarMenu() {
        System.out.println();
        System.out.println("1) Factorial");
        System.out.println("2) Fibonacci");
        System.out.println("3) Cantidad de primos");
        System.out.println("4) Las tres en paralelo");
        System.out.println("0) Salir");
    }

    // Crea las operaciones según la opción; la lista es de tipo Operacion, así que acepta cualquier hija (polimorfismo)
    static List<Operacion> crearOperaciones(int opcion, int n) {
        List<Operacion> lista = new ArrayList<>();
        if (opcion == 1 || opcion == 4) {
            lista.add(new Factorial(n));
        }
        if (opcion == 2 || opcion == 4) {
            lista.add(new Fibonacci(n));
        }
        if (opcion == 3 || opcion == 4) {
            lista.add(new Primos(n));
        }
        return lista;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        // El menú se repite hasta que el usuario elige 0
        while (true) {
            mostrarMenu();
            int opcion = leerEntero(sc, "Opción: ", 0, 4);
            if (opcion == 0) {
                break;
            }
            int n = leerEntero(sc, "Valor de n (1 a 20000): ", 1, 20000);

            List<Operacion> operaciones = crearOperaciones(opcion, n);

            // start() lanza cada hilo; desde aquí las operaciones corren en paralelo
            for (Operacion op : operaciones) {
                op.start();
            }

            // join() bloquea a main hasta que cada hilo termine, así los resultados ya están listos
            for (Operacion op : operaciones) {
                op.join();
            }

            // Se muestra el resultado y el tiempo de cada operación
            System.out.println();
            for (Operacion op : operaciones) {
                System.out.println(op.getResultado() + "  [" + op.getTiempoMs() + " ms]");
            }
        }

        System.out.println("Programa terminado");
        sc.close();
    }
}
