/*====================================
    Práctica 2
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
        Alumno alumnos[] = new Alumno[10];

        // == Operaciones ==

        // Creación de los dos primeros alumnos
        // mediante el constructor completo

        alumnos[0] = new Alumno(20, 8.5F, "Pedro", "3er Semestre", 'H');
        alumnos[1] = new Alumno(21, 9.0F, "Ana", "3er Semestre", 'M');
        int i = 2;

        // Creación de los alumnos restantes
        // mediante el constructor vacío
        while (i < 10) {

            alumnos[i] = new Alumno();

            String nombre, semestre;
            int edad;
            float promedio;
            char sexo;
            
            //Lectura de datos a asignar 
            System.out.println("\nDatos del alumno " + (i + 1));
            System.out.println("Por favor proporcione el nombre: ");
            nombre = sc.next();

            System.out.println("Por favor proporcione el semestre: ");
            sc.nextLine();
            semestre = sc.nextLine();

            System.out.println("Por favor proporcione la edad: ");
            edad = sc.nextInt();

            System.out.println("Por favor proporcione el promedio: ");
            promedio = sc.nextFloat();

            System.out.println("Por favor proporcione el sexo (H/h o M/m): ");
            sexo = sc.next().charAt(0);

            //Asignación de información en las variables
            // al objeto Alumno que está iterando
            alumnos[i].setNombre(nombre);
            alumnos[i].setSemestre(semestre);
            alumnos[i].setEdad(edad);
            alumnos[i].setPromedio(promedio);

            if (sexo == 'H' || sexo == 'h') {
                alumnos[i].setSexo('H');
            } else {
                alumnos[i].setSexo('M');
            }
            i++;
        }

        // == Impresión en pantalla ==
        System.out.println("\n===== LISTA DE ALUMNOS =====");
        for (i = 0; i < 10; i++) {
            System.out.println("\nAlumno " + (i + 1));
            System.out.println("Nombre: " + alumnos[i].getNombre());
            System.out.println("Semestre: " + alumnos[i].getSemestre());
            System.out.println("Edad: " + alumnos[i].getEdad());
            System.out.println("Promedio: " + alumnos[i].getPromedio());
            System.out.println("Sexo: " + alumnos[i].getSexo());
        }
    }
}