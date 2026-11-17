import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Juego de adivinar el número.
 * Usa nextInt(), que lanza InputMismatchException si el usuario escribe algo que no es entero.
 *
 * alumno: Villalobos Estrada Osvaldo.
 * cuenta: 322024443.
 */
public class Adivina_Numero_10_Input_Mismatch_Exception {

    static final Scanner sc = new Scanner(System.in);

    // ---------------------------------------------------------
    // Lee un entero con nextInt(); si falla, limpia el buffer y repite
    // ---------------------------------------------------------
    static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); // consume el salto de línea que deja nextInt()
                return valor;
            } catch (InputMismatchException e) {
                // El token inválido NO se consume solo: hay que descartarlo,
                // si no, el while entraría en un ciclo infinito.
                String basura = sc.nextLine();
                System.out.println("  [Error] \"" + basura.trim() + "\" no es un entero. Intenta de nuevo.");
            }
        }
    }

    static boolean preguntarSiOtraVez() {
        while (true) {
            System.out.print("¿Jugar otra vez? (s/n): ");
            String r = sc.nextLine().trim().toLowerCase();
            if (r.equals("s")) return true;
            if (r.equals("n")) return false;
            System.out.println("  [Error] Responde solo 's' o 'n'.");
        }
    }

    public static void main(String[] args) {
        Random azar = new Random();
        int partidas = 0;
        int mejorRecord = Integer.MAX_VALUE;

        System.out.println("=== ADIVINA EL NÚMERO ===");

        do {
            int secreto = azar.nextInt(100) + 1; // 1 a 100
            int intentos = 0;
            partidas++;

            System.out.println("\nPartida " + partidas + ": pensé un número entre 1 y 100.");

            while (true) {
                int intento = leerEntero("Tu número: ");

                if (intento < 1 || intento > 100) {
                    System.out.println("  [Aviso] Fuera de rango (1-100). No cuenta como intento.");
                    continue;
                }

                intentos++;

                if (intento < secreto) {
                    System.out.println("  Más alto ↑");
                } else if (intento > secreto) {
                    System.out.println("  Más bajo ↓");
                } else {
                    System.out.println("  ¡Correcto! Lo lograste en " + intentos + " intentos.");
                    mejorRecord = Math.min(mejorRecord, intentos);
                    break;
                }
            }

            System.out.println("Mejor récord: " + mejorRecord + " intentos.");

        } while (preguntarSiOtraVez());

        System.out.println("Jugaste " + partidas + " partida(s). ¡Hasta luego!");
        sc.close();
    }
}
