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
        Computadora computadoras[] = new Computadora[10];

        // == Operaciones ==

        // Creación de los dos primeros objetos
        // mediante el constructor completo
        computadoras[0] = new Computadora(
                "Intel Core i5",
                16,
                512,
                true,
                650
        );

        computadoras[1] = new Computadora(
                "AMD Ryzen 5",
                8,
                1000,
                false,
                550
        );

        int i = 2;

        // Creación de los objetos restantes
        // mediante el constructor vacío
        do {

            computadoras[i] = new Computadora();

            String cpu;
            int ram;
            int almacenamiento;
            int fuenteEnergia;
            char respuestaGPU;

            System.out.println("\nDatos de la computadora " + (i + 1));

            System.out.println("Por favor proporcione el CPU: ");
            sc.nextLine();
            cpu = sc.nextLine();

            System.out.println("Por favor proporcione la cantidad de RAM (GB): ");
            ram = sc.nextInt();

            System.out.println("Por favor proporcione el almacenamiento (GB): ");
            almacenamiento = sc.nextInt();

            System.out.println("¿La computadora cuenta con GPU dedicada? (S/N): ");
            respuestaGPU = sc.next().charAt(0);

            System.out.println("Por favor proporcione la fuente de energía (W): ");
            fuenteEnergia = sc.nextInt();

            computadoras[i].setCpu(cpu);
            computadoras[i].setRam(ram);
            computadoras[i].setAlmacenamiento(almacenamiento);
            computadoras[i].setFuenteEnergia(fuenteEnergia);

            if (respuestaGPU == 'S' || respuestaGPU == 's') {
                computadoras[i].setGpu(true);
            } else {
                computadoras[i].setGpu(false);
            }

            i++;

        } while (i < 10);

        // == Impresión en pantalla ==
        System.out.println("\n===== LISTA DE COMPUTADORAS =====");

        for (i = 0; i < 10; i++) {

            System.out.println("\nComputadora " + (i + 1));
            System.out.println("CPU: " + computadoras[i].getCpu());
            System.out.println("RAM: " + computadoras[i].getRam() + " GB");
            System.out.println("Almacenamiento: "
                    + computadoras[i].getAlmacenamiento() + " GB");

            if (computadoras[i].getGpu()) {
                System.out.println("GPU dedicada: Sí");
            } else {
                System.out.println("GPU dedicada: No");
            }

            System.out.println("Fuente de energía: "
                    + computadoras[i].getFuenteEnergia() + " W");
        }
    }
}