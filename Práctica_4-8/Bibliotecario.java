/*====================================
    Práctica 4-8
    Programación Orientada a Objetos 2027-1

    Coronado Ramirez Luis Ángel.
    Equipo 1
    No: 426059057

    Clase que representa al bibliotecario encargado
    de administrar los préstamos y libros.
====================================*/

public class Bibliotecario extends Persona {

    // == Atributos ==
    private String turno;
    private double salario;

    // == Constructor vacío ==
    public Bibliotecario() { }

    // == Constructor completo ==
    public Bibliotecario(int id, String nombre, String correo,
                         String turno, double salario) {
        super(id, nombre, correo);
        this.turno = turno;
        this.salario = salario;
    }

    // == Setters ==
    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // == Getters ==
    public String getTurno() {
        return turno;
    }

    public double getSalario() {
        return salario;
    }

    // == Autorizar préstamo ==
    public void autorizarPrestamo() {
        System.out.println("Préstamo autorizado.");
    }

    // == Registrar libro ==
    public void registrarLibro() {
        System.out.println("Libro registrado.");
    }

    // == Eliminar libro ==
    public void eliminarLibro() {
        System.out.println("Libro eliminado.");
    }

    // == Mostrar información ==
    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Turno: " + turno);
        System.out.println("Salario: $" + salario);
    }
}