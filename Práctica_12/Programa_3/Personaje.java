package Práctica_12.Programa_3;

/* =====================================================
Práctica 12 - Hilos en Java
Manuel Alejandro Melgarejo Cervantes
322063132

Descripción:
Programa que utiliza tres hilos para simular el
entrenamiento de distintos personajes. Cada hilo
trabaja de forma independiente y muestra su avance
en la consola.
===================================================== */


// Clase padre
public class Personaje {

    private String nombre;
    private int nivelVida;

    public Personaje() {
    }

    public Personaje(String nombre, int nivelVida) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }
}
