package Práctica_12.Programa_3;


public class Principal {

    public static void main(String[] args) {

        HiloPersonaje p1 =
                new HiloPersonaje("Guerrero", 100);

        HiloPersonaje p2 =
                new HiloPersonaje("Mago", 80);

        HiloPersonaje p3 =
                new HiloPersonaje("Arquero", 90);

        p1.iniciar();
        p2.iniciar();
        p3.iniciar();

        System.out.println("Entrenamiento iniciado...");
    }
}
