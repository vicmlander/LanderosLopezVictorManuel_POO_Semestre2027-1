/*====================================
    Práctica 11
    Programación Orientada a Objetos 2027-1

    Landeros López Victor Manuel.
    Equipo 1
    No: 3-16229849
====================================*/

import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // == Declaración y definición de variables ==
        String fechaTexto;
        String hora;
        String nombre;

        LocalDate fecha;
        String diaSemana;
        int diaAnio;

        boolean ocupado = false;

        // == Creación de objetos ==
        try {

            AgendaSalon agenda = new AgendaSalon();

            // == Interacción con el usuario ==
            System.out.println("=== AGENDA DE RESERVACIONES ===");

            System.out.print("Ingresa la fecha (AAAA-MM-DD): ");
            fechaTexto = entrada.nextLine();

            System.out.print("Ingresa la hora (HH:MM): ");
            hora = entrada.nextLine();

            System.out.print("Ingresa el nombre de la persona o empresa: ");
            nombre = entrada.nextLine();

            // == Obtención de datos de la fecha ==
            fecha = LocalDate.parse(fechaTexto);

            diaSemana = fecha.getDayOfWeek().toString();
            diaAnio = fecha.getDayOfYear();

            // == Consulta de disponibilidad ==
            ocupado = agenda.estaOcupado(fechaTexto, hora);

            // == Operación de reservación ==
            System.out.println("\n=== DATOS DE LA RESERVACIÓN ===");
            System.out.println("Fecha: " + fechaTexto);
            System.out.println("Hora: " + hora);
            System.out.println("Día de la semana: " + diaSemana);
            System.out.println("Día del año: " + diaAnio);

            if (ocupado == true) {

                System.out.println("Disponibilidad: No disponible");
                System.out.println("ERROR: El horario ya se encuentra reservado.");

            } else {

                System.out.println("Disponibilidad: Disponible");

                agenda.guardarReservacion(fechaTexto, hora,
                        diaSemana, diaAnio, nombre);

                System.out.println("Reservación realizada correctamente.");
                System.out.println("Reservado por: " + nombre);
                System.out.println("La agenda ha sido actualizada.");

            }

        } catch (IOException e) {

            System.out.println("Error al trabajar con el archivo.");

        }

    }
}
