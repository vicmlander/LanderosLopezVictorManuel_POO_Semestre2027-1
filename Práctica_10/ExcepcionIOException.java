/*====================================
    Práctica 10
    Programación Orientada a Objetos 2027-1

    Programa que solicita el nombre de un archivo e intenta
    leer su contenido, demostrando el manejo de la excepción
    IOException cuando ocurre un error durante la lectura.

    Landeros López Victor Manuel.
    Equipo 1
    No: 3-16229849
====================================*/

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ExcepcionIOException {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // == Declaración y definición de variables ==
        String nombreArchivo;
        String linea;

        // == Interacción con el usuario ==
        System.out.print("Ingresa el nombre del archivo que deseas leer: ");
        nombreArchivo = entrada.nextLine();

        // == Operación y manejo de excepción ==
        try {

            File archivo = new File(nombreArchivo);

            FileReader lector = new FileReader(archivo);
            BufferedReader lectura = new BufferedReader(lector);

            linea = lectura.readLine();

            System.out.println("Contenido del archivo: " + linea);

            lectura.close();

        } catch (IOException e) {

            System.out.println("Error: No se pudo leer el archivo.");
            System.out.println("Se ha detectado una excepción IOException.");

        }

    }
}
