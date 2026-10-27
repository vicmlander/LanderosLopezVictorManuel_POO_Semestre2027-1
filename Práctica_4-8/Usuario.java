/*====================================
    Práctica 4-8
    Programación Orientada a Objetos 2027-1

    Villalobos Estrada Osvaldo Yafte.
    Equipo 1
    No: 322024443

    Clase que representa a los usuarios de la biblioteca.
====================================*/

/**
 * Clase que representa a los usuarios de la biblioteca,
 * es decir, a las personas que pueden solicitar préstamos.
 * <p>
 * Hereda de la clase abstracta {@link Persona}.
 */
public class Usuario extends Persona {

    // == Atributos ==
    /** Cantidad de libros que el usuario tiene prestados. */
    private int librosPrestados;

    /** Teléfono celular del usuario (ej. 55-55-55-55-55). */
    private String telefonoCelular;

    /** Indica si el usuario está activo en la biblioteca. */
    private boolean activo;

    // == Constructor vacío ==
    /**
     * Constructor vacío. Crea un usuario sin datos.
     */
    public Usuario() { }

    // == Constructor completo ==
    /**
     * Constructor que crea un usuario con nombre y correo.
     *
     * @param id     identificador del usuario
     * @param nombre nombre del usuario
     * @param correo correo electrónico del usuario
     * @param activo indica si el usuario está activo
     */
    public Usuario(int id, String nombre, String correo, boolean activo) {
        super(id, nombre, correo);
        librosPrestados = 0;
        telefonoCelular = "";
        this.activo = activo;
    }

    // == Constructor con sobrecarga ==
    // Se cambió el orden de los parámetros (activo va antes que telefonoCelular)
    // porque Java no permite dos constructores con los mismos tipos de datos
    // en el mismo orden (int, String, String, boolean).
    /**
     * Constructor que crea un usuario con nombre y teléfono celular.
     * <p>
     * El parámetro activo va antes del teléfono para que Java pueda
     * distinguir este constructor del que recibe nombre y correo.
     *
     * @param id              identificador del usuario
     * @param nombre          nombre del usuario
     * @param activo          indica si el usuario está activo
     * @param telefonoCelular teléfono celular del usuario
     */
    public Usuario(int id, String nombre, boolean activo, String telefonoCelular) {
        super(id, nombre, "");
        librosPrestados = 0;
        this.telefonoCelular = telefonoCelular;
        this.activo = activo;
    }

    // == Constructor con sobrecarga ==
    // Se cambió el orden de los parámetros (activo va después del id)
    // por la misma razón que en el constructor anterior.
    /**
     * Constructor que crea un usuario con correo y teléfono celular.
     * <p>
     * El parámetro activo va después del id para que Java pueda
     * distinguir este constructor de los otros dos.
     *
     * @param id              identificador del usuario
     * @param activo          indica si el usuario está activo
     * @param correo          correo electrónico del usuario
     * @param telefonoCelular teléfono celular del usuario
     */
    public Usuario(int id, boolean activo, String correo, String telefonoCelular) {
        super(id, "", correo);
        librosPrestados = 0;
        this.telefonoCelular = telefonoCelular;
        this.activo = activo;
    }

    // == Setters ==
    /**
     * Asigna la cantidad de libros prestados.
     *
     * @param librosPrestados nueva cantidad de libros prestados
     */
    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    /**
     * Asigna el teléfono celular del usuario.
     *
     * @param telefonoCelular nuevo teléfono celular
     */
    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    /**
     * Asigna si el usuario está activo o no.
     *
     * @param activo true si el usuario está activo, false si no
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // == Getters ==
    /**
     * Regresa la cantidad de libros que tiene prestados el usuario.
     *
     * @return cantidad de libros prestados
     */
    public int getLibrosPrestados() {
        return librosPrestados;
    }

    /**
     * Regresa el teléfono celular del usuario.
     *
     * @return teléfono celular
     */
    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    /**
     * Regresa si el usuario está activo.
     *
     * @return true si el usuario está activo, false si no
     */
    public boolean getActivo() {
        return activo;
    }

    // == Solicitar préstamo ==
    /**
     * Registra que el usuario solicitó un préstamo,
     * aumentando en uno sus libros prestados.
     */
    public void solicitarPrestamo() {
        librosPrestados++;
    }

    // == Devolver libro ==
    /**
     * Registra que el usuario devolvió un libro,
     * disminuyendo en uno sus libros prestados.
     */
    public void devolverLibro() {
        if (librosPrestados > 0) {
            librosPrestados--;
        }
    }

    // == Mostrar información ==
    /**
     * Muestra en pantalla la información del usuario.
     */
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
