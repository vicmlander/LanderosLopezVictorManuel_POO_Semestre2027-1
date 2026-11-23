/* =====================================================
Práctica 12
Coronado Ramirez Luis Angel
426059057
clase padre: contiene los datos basicos de una clase que seran utilizados en las siguientes
===================================================== */


package Práctica_12.Programa_2;

public class Personaje {
    private String nombre;//atributos privados para que solo personaje pueda modificarlas
    private int nivelVida;

    public Personaje() {
    }

    public Personaje(String nombre, int nivelVida) {//constructor lleno
        this.nombre = nombre;
        this.nivelVida = nivelVida;
    }
//getters
    public String getNombre() {
        return nombre;
    }
    public int getNivelVida() {
        return nivelVida;
    }
//setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }
}
