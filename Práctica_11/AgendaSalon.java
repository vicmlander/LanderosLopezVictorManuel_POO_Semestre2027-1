/*====================================
    Práctica 11
    Programación Orientada a Objetos 2027-1

    Landeros López Victor Manuel.
    Equipo 1
    No: 3-16229849
====================================*/

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;

public class AgendaSalon {

    // == Atributos ==
    File archivo;

    // == Constructor ==
    public AgendaSalon() throws IOException {

        archivo = new File("agenda.txt");

        // == Creación del archivo y datos iniciales ==
        if (!archivo.exists()) {

            FileWriter escritor = new FileWriter(archivo);

            LocalDate fechaEjemplo = LocalDate.now().plusDays(1);

            escritor.write(fechaEjemplo + ";15:00;"
                    + fechaEjemplo.getDayOfWeek() + ";"
                    + fechaEjemplo.getDayOfYear()
                    + ";No disponible;Empresa de ejemplo\n");

            escritor.write(fechaEjemplo + ";18:00;"
                    + fechaEjemplo.getDayOfWeek() + ";"
                    + fechaEjemplo.getDayOfYear()
                    + ";No disponible;Persona de ejemplo\n");

            escritor.close();
        }
    }

    // == Método para consultar disponibilidad ==
    public boolean estaOcupado(String fechaTexto, String hora)
            throws IOException {

        String linea;
        boolean ocupado = false;

        BufferedReader lector = new BufferedReader(new FileReader(archivo));

        while ((linea = lector.readLine()) != null) {

            if (linea.startsWith(fechaTexto + ";" + hora + ";")) {
                ocupado = true;
            }
        }

        lector.close();

        return ocupado;
    }

    // == Método para guardar reservación ==
    public void guardarReservacion(String fechaTexto, String hora,
            String diaSemana, int diaAnio, String nombre)
            throws IOException {

        FileWriter escritor = new FileWriter(archivo, true);

        escritor.write(fechaTexto + ";" + hora + ";"
                + diaSemana + ";" + diaAnio
                + ";No disponible;" + nombre + "\n");

        escritor.close();
    }
}
