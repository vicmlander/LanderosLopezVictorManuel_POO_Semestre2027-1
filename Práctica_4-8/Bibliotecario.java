/*====================================
    Práctica 4-8
    Programación Orientada a Objetos 2027-1

    Coronado Ramirez Luis Ángel.
    Equipo 1
    No: 426059057

    Clase que representa al bibliotecario encargado
    de administrar los préstamos y libros.
====================================*/

/**
 * Clase que representa al bibliotecario, el empleado encargado
 * de administrar los préstamos y el catálogo de la biblioteca.
 * <p>
 * Hereda de la clase abstracta {@link Persona}.
 */
public class Bibliotecario extends Persona {

    // == Atributos ==
    /** Turno en el que trabaja el bibliotecario (ej. Matutino). */
    private String turno;

    /** Salario del bibliotecario. */
    private double salario;

    // == Constructor vacío ==
    /**
     * Constructor vacío. Crea un bibliotecario sin datos.
     */
    public Bibliotecario() { }

    // == Constructor completo ==
    /**
     * Constructor completo. Crea un bibliotecario con todos sus datos.
     *
     * @param id      identificador del bibliotecario
     * @param nombre  nombre del bibliotecario
     * @param correo  correo electrónico del bibliotecario
     * @param turno   turno en el que trabaja
     * @param salario salario del bibliotecario
     */
    public Bibliotecario(int id, String nombre, String correo,
                         String turno, double salario) {
        super(id, nombre, correo);
        this.turno = turno;
        this.salario = salario;
    }

    // == Setters ==
    /**
     * Asigna el turno del bibliotecario.
     *
     * @param turno nuevo turno
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * Asigna el salario del bibliotecario.
     *
     * @param salario nuevo salario
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // == Getters ==
    /**
     * Regresa el turno del bibliotecario.
     *
     * @return turno del bibliotecario
     */
    public String getTurno() {
        return turno;
    }

    /**
     * Regresa el salario del bibliotecario.
     *
     * @return salario del bibliotecario
     */
    public double getSalario() {
        return salario;
    }

    // == Autorizar préstamo ==
    /**
     * Indica que el bibliotecario autoriza un préstamo.
     */
    public void autorizarPrestamo() {
        System.out.println("Préstamo autorizado.");
    }

    // == Registrar libro ==
    /**
     * Indica que el bibliotecario registra un libro.
     */
    public void registrarLibro() {
        System.out.println("Libro registrado.");
    }

    // == Eliminar libro ==
    /**
     * Indica que el bibliotecario elimina un libro.
     */
    public void eliminarLibro() {
        System.out.println("Libro eliminado.");
    }

    // == Mostrar información ==
    /**
     * Muestra en pantalla la información del bibliotecario.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Turno: " + turno);
        System.out.println("Salario: $" + salario);
    }
}
