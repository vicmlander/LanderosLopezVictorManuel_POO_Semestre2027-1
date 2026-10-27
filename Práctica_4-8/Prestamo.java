/*====================================
    Práctica 4-8
    Programación Orientada a Objetos 2027-1

    Equipo 1

    Landeros López Victor Manuel.
    No: 3-16229849

    Villalobos Estrada Osvaldo Yafte.
    No: 322024443

    Melgarejo Cervantes Manuel Alejandro.
    No: 322063132

    Clase que representa un préstamo y relaciona
    a un usuario con un libro.
====================================*/

/**
 * Clase que representa un préstamo y relaciona a un usuario con un libro.
 * <p>
 * Contiene un objeto {@link Usuario} y un objeto {@link Libro} (composición)
 * y se comunica con ellos para iniciar y finalizar el préstamo.
 * Las fechas se guardan como textos descriptivos.
 */
public class Prestamo {

    // == Atributos ==
    /** Usuario que solicita el préstamo. */
    private Usuario usuario;

    /** Libro que se presta. */
    private Libro libro;

    /** Texto descriptivo de la fecha de préstamo. */
    private String fechaPrestamo;

    /** Texto descriptivo de la fecha de devolución. */
    private String fechaDevolucion;

    /** Indica si el préstamo sigue activo. */
    private boolean activo;

    // == Constructor ==
    /**
     * Crea un préstamo entre un usuario y un libro.
     * El préstamo inicia como no activo hasta que se llame a iniciarPrestamo().
     *
     * @param usuario usuario que solicita el préstamo
     * @param libro   libro que se presta
     */
    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        fechaPrestamo = "";
        fechaDevolucion = "";
        activo = false;
    }

    // == Setters ==
    /**
     * Asigna el usuario del préstamo.
     *
     * @param usuario nuevo usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Asigna el libro del préstamo.
     *
     * @param libro nuevo libro
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * Asigna el texto de la fecha de préstamo.
     *
     * @param fechaPrestamo nuevo texto de fecha de préstamo
     */
    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Asigna el texto de la fecha de devolución.
     *
     * @param fechaDevolucion nuevo texto de fecha de devolución
     */
    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Asigna si el préstamo está activo o no.
     *
     * @param activo true si el préstamo está activo, false si no
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // == Getters ==
    /**
     * Regresa el usuario del préstamo.
     *
     * @return usuario del préstamo
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Regresa el libro del préstamo.
     *
     * @return libro del préstamo
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Regresa el texto de la fecha de préstamo.
     *
     * @return fecha de préstamo
     */
    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Regresa el texto de la fecha de devolución.
     *
     * @return fecha de devolución
     */
    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Regresa si el préstamo está activo.
     *
     * @return true si el préstamo está activo, false si no
     */
    public boolean getActivo() {
        return activo;
    }

    // == Iniciar préstamo ==
    /**
     * Inicia el préstamo si el libro está disponible.
     * Se comunica con el libro (lo presta) y con el usuario
     * (aumenta sus libros prestados).
     */
    public void iniciarPrestamo() {
        if (libro.estaDisponible() && !activo) {
            libro.prestar();
            usuario.solicitarPrestamo();

            fechaPrestamo = "Préstamo iniciado";
            fechaDevolucion = "Pendiente";
            activo = true;
        }
    }

    // == Finalizar préstamo ==
    /**
     * Finaliza el préstamo si está activo.
     * Se comunica con el libro (lo devuelve) y con el usuario
     * (disminuye sus libros prestados).
     */
    public void finalizarPrestamo() {
        if (activo) {
            libro.devolver();
            usuario.devolverLibro();

            fechaDevolucion = "Préstamo finalizado";
            activo = false;
        }
    }

    // == Consultar estado del préstamo ==
    /**
     * Consulta si el préstamo sigue activo.
     *
     * @return true si el préstamo está activo, false si no
     */
    public boolean estaActivo() {
        return activo;
    }
}
