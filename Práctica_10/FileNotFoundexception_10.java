import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Mini gestor de notas.
 * FileNotFoundException aparece en dos casos:
 *   - Al LEER con new Scanner(File) un archivo que no existe.
 *   - Al ESCRIBIR con new PrintWriter(ruta) en una carpeta inexistente o sin permisos.
 * alumno: Villalobos Estrada Osvaldo Yafte.
 * cuenta: 322024443.
 * 
 */
public class FileNotFoundexception_10 {

    static final Scanner teclado = new Scanner(System.in);

    // ---------------------------------------------------------
    // LEER: muestra el contenido de un archivo
    // ---------------------------------------------------------
    static void leerArchivo() {
        System.out.print("Nombre del archivo a leer (ej. notas.txt): ");
        String ruta = teclado.nextLine().trim();

        if (ruta.isEmpty()) {
            System.out.println("  [Error] No escribiste ningún nombre.");
            return;
        }

        // try-with-resources: cierra el Scanner solo, aunque haya error
        try (Scanner lector = new Scanner(new File(ruta))) {
            System.out.println("\n--- Contenido de " + ruta + " ---");
            int linea = 1;
            while (lector.hasNextLine()) {
                System.out.println(linea++ + ": " + lector.nextLine());
            }
            if (linea == 1) {
                System.out.println("(el archivo está vacío)");
            }
            System.out.println("--- Fin ---");
        } catch (FileNotFoundException e) {
            System.out.println("  [Error] No se encontró \"" + ruta + "\".");
            System.out.println("          Revisa el nombre o usa la opción 2 para crearlo.");
            System.out.println("          Carpeta actual: " + new File(".").getAbsoluteFile().getParent());
        }
    }

    // ---------------------------------------------------------
    // ESCRIBIR: guarda texto en un archivo (lo crea si no existe)
    // ---------------------------------------------------------
    static void escribirArchivo() {
        System.out.print("Nombre del archivo donde guardar: ");
        String ruta = teclado.nextLine().trim();

        if (ruta.isEmpty()) {
            System.out.println("  [Error] No escribiste ningún nombre.");
            return;
        }

        System.out.println("Escribe tu nota (una línea vacía para terminar):");

        try (PrintWriter escritor = new PrintWriter(ruta)) {
            while (true) {
                String texto = teclado.nextLine();
                if (texto.isEmpty()) break;
                escritor.println(texto);
            }
            System.out.println("  Nota guardada en \"" + ruta + "\".");
        } catch (FileNotFoundException e) {
            // Pasa si la carpeta no existe (ej. "carpeta/falsa/nota.txt") o no hay permisos
            System.out.println("  [Error] No se pudo crear \"" + ruta + "\".");
            System.out.println("          ¿Existe la carpeta? ¿Tienes permisos de escritura?");
        }
    }

    static void mostrarMenu() {
        System.out.println("\n========== GESTOR DE NOTAS ==========");
        System.out.println("1) Leer un archivo");
        System.out.println("2) Escribir/crear un archivo");
        System.out.println("3) Salir");
        System.out.println("=====================================");
        System.out.print("Opción: ");
    }

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            String opcion = teclado.nextLine().trim();

            switch (opcion) {
                case "1" -> leerArchivo();
                case "2" -> escribirArchivo();
                case "3" -> {
                    System.out.println("¡Hasta luego!");
                    salir = true;
                }
                default -> System.out.println("  [Error] Opción no válida, elige 1, 2 o 3.");
            }
        }

        teclado.close();
    }
}
