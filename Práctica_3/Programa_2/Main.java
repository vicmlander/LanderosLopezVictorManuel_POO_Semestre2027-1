/*====================================
    Práctica 3
    Programación Orientada a Objetos 2027-1

    Coronado Ramirez Luis Angel.
    Equipo 1
    No cuenta: 426059057
====================================*/
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // StringBuffer para guardar el historial
        StringBuffer historial = new StringBuffer();

        int opcion;
//==================Ciclo do while===============
        do {//bucle para el menu


//menu
            System.out.println("GENERADOR DE CONTRASEÑAS ");
            System.out.println("1. Generar contraseña");
            System.out.println("2. Ver historial");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();//Lee la opción introducida
//================================Switch================================
            switch (opcion) {//switch para cada opcion

                case 1:

                    System.out.print("¿Cuántos caracteres quieres? ");//Pide la longitud y la lee.
                    int longitud = scanner.nextInt();

                    if (longitud < 4) {
                        System.out.println("La contraseña debe tener al menos 4 caracteres.");//Valida que la longitud sea al menos 4
                    } else {

                        // Creamos un objeto de la clase GeneradorContrasena con la longitud indicada
                        GeneradorContrasenas generador =
                                new GeneradorContrasenas(longitud);

                        String contrasena = generador.generar();//Llama al método generar()

                        System.out.println("\nContraseña generada: " + contrasena);

                        // Guardamos la contraseña en el StringBuffer
                        historial.append(contrasena);
                        historial.append("\n");
                    }

                    break;

                case 2:

                    System.out.println("HISTORIAL");

                    if (historial.length() == 0) {//Si el historial está vacío, avisa. Si no, lo imprime
                        System.out.println("No hay contraseñas generadas.");
                    } else {
                        System.out.println(historial);
                    }

                    break;

                case 3:

                    System.out.println("Programa terminado");

                    break;

                default:

                    System.out.println("Opción no válida.");
            }

        } while (opcion != 3);

        scanner.close();
    }
}