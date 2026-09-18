/*============== practica 3 ================
programacion orientada a objetos 2027-1

nombre: villalobos estrada osvaldo  equipo 1
cuenta: 322024443
============================================*/

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionPasatiempos {

    // método que recibe una LinkedList de datos y los une con StringBuilder
    private static String generarResumen(List<String> pasatiempos, String nombre) {
        StringBuilder sb = new StringBuilder();
        sb.append("¡Hola, ").append(nombre).append("!\n");
        sb.append("Aquí está la lista de pasatiempos que ingresaste:\n");

        // uso del bucle for-each para recorrer la LinkedList
        int contador = 1;
        for (String pasatiempo : pasatiempos) {
            sb.append("  ").append(contador).append(". ").append(pasatiempo).append("\n");
            contador++;
        }

        return sb.toString();
    }


 public static void main(String[] args) {
        // uso de LinkedList para almacenar una secuencia dinámica de elementos
        List<String> listaPasatiempos = new LinkedList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Introduce tu nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("¿Cuántos pasatiempos quieres registrar?: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            // pedir pasatiempos en un bucle y agregarlos a la LinkedList
            for (int i = 0; i < cantidad; i++) {
                System.out.print("Pasatiempo " + (i + 1) + ": ");
                String entrada = scanner.nextLine();
                listaPasatiempos.add(entrada); 
            }

            // generar y mostrar el resultado utilizando StringBuilder
            String resumen = generarResumen(listaPasatiempos, nombre);
            System.out.println("\n--- Resumen Final ---");
            System.out.println(resumen);
        } catch (NumberFormatException e) {
            System.err.println("Error: Debes ingresar un número entero válido para la cantidad.");
        }
    }