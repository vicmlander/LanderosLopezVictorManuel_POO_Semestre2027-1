/*====================================
    Práctica 4-8
    Programación Orientada a Objetos 2027-1

    Landeros López Victor Manuel.
    Equipo 1
    No: 3-16229849

    Clase abstracta que contiene la información
    común de las personas de la biblioteca.
====================================*/

public abstract class Persona {

    // == Atributos ==
    protected int id;
    protected String nombre;
    protected String correo;

    // == Constructor vacío ==
    public Persona() { }

    // == Constructor completo ==
    public Persona(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    // == Setters ==
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // == Getters ==
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    // == Método abstracto ==
    public abstract void mostrarInformacion();
}