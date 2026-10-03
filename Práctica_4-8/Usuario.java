/*====================================
    Práctica 4-8
    Programación Orientada a Objetos 2027-1

    Villalobos Estrada Osvaldo Yafte.
    Equipo 1
    No: 322024443

    Clase que representa a los usuarios de la biblioteca.
====================================*/

public class Usuario extends Persona {

    // == Atributos ==
    private int librosPrestados;
    private String telefonoCelular;
    private boolean activo;

    // == Constructor vacío ==
    public Usuario() { }

    // == Constructor completo ==
    public Usuario(int id, String nombre, String correo, boolean activo) {
        super(id, nombre, correo);
        librosPrestados = 0;
        telefonoCelular = "";
        this.activo = activo;
    }

    // == Constructor con sobrecarga ==
    public Usuario(int id, String nombre, String telefonoCelular, boolean activo) {
        super(id, nombre, "");
        librosPrestados = 0;
        this.telefonoCelular = telefonoCelular;
        this.activo = activo;
    }

    // == Constructor con sobrecarga ==
    public Usuario(int id, String correo, String telefonoCelular, boolean activo) {
        super(id, "", correo);
        librosPrestados = 0;
        this.telefonoCelular = telefonoCelular;
        this.activo = activo;
    }

    // == Setters ==
    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // == Getters ==
    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public boolean getActivo() {
        return activo;
    }

    // == Solicitar préstamo ==
    public void solicitarPrestamo() {
        librosPrestados++;
    }

    // == Devolver libro ==
    public void devolverLibro() {
        if (librosPrestados > 0) {
            librosPrestados--;
        }
    }

    // == Mostrar información ==
    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Teléfono: " + telefonoCelular);
        System.out.println("Libros prestados: " + librosPrestados);
        System.out.println("Activo: " + activo);
    }
}