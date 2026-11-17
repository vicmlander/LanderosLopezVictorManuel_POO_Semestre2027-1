import java.util.Scanner;

/**
 * 
 * Maneja NumberFormatException, división entre cero y opciones de menú erróneas.
 *alumno: Villalobos Estrada Osvaldo
 cuenta: 322024443
 
 */
public class Calculadora_10_Numer_Format_Exception {

    static final Scanner sc = new Scanner(System.in);

    // ---------------------------------------------------------
    // Lee un número decimal; repite hasta que el usuario escriba uno válido
    // ---------------------------------------------------------
    static double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim().replace(',', '.'); // acepta "3,5"
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("  [Error] \"" + entrada + "\" no es un número válido. Intenta de nuevo.");
            }
        }
    }

    // ---------------------------------------------------------
    // Lee un entero dentro de un rango (para el menú)
    // ---------------------------------------------------------
    static int leerOpcion(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor < min || valor > max) {
                    System.out.println("  [Error] Elige un número entre " + min + " y " + max + ".");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("  [Error] \"" + entrada + "\" no es un entero válido.");
            }
        }
    }

    static void mostrarMenu() {
        System.out.println("\n========== CALCULADORA ==========");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");
        System.out.println("5) Salir");
        System.out.println("=================================");
    }

    public static void main(String[] args) {
        System.out.println("Bienvenido. Escribe cualquier cosa, el programa no se rompe :)");

        while (true) {
            mostrarMenu();
            int opcion = leerOpcion("Elige una opción (1-5): ", 1, 5);

            if (opcion == 5) {
                System.out.println("¡Hasta luego!");
                break;
            }

            double a = leerDecimal("Primer número: ");
            double b = leerDecimal("Segundo número: ");

            try {
                double resultado;
                switch (opcion) {
                    case 1 -> resultado = a + b;
                    case 2 -> resultado = a - b;
                    case 3 -> resultado = a * b;
                    case 4 -> {
                        if (b == 0) {
                            throw new ArithmeticException("No se puede dividir entre cero.");
                        }
                        resultado = a / b;
                    }
                    default -> throw new IllegalStateException("Opción inesperada: " + opcion);
                }
                System.out.println("  Resultado: " + resultado);
            } catch (ArithmeticException e) {
                System.out.println("  [Error] " + e.getMessage());
            }
        }

        sc.close();
    }
}
