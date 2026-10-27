/*====================================
    Práctica 4-8
    Programación Orientada a Objetos 2027-1

    Landeros López Victor Manuel.
    Equipo 1
    No: 3-16229849

    Clase abstracta que contiene la información
    común de las personas de la biblioteca.
====================================*/

/**
 * Clase abstracta que contiene la información común de las personas
 * de la biblioteca (usuarios y bibliotecarios).
 * <p>
 * Al ser abstracta no se puede crear un objeto de tipo Persona directamente;
 * solo sirve para que otras clases (Usuario y Bibliotecario) hereden de ella.
 */
public abstract class Persona {

    // == Atributos ==
    /** Identificador de la persona. Es protected para que las clases hijas lo usen directamente. */
    protected int id;

    /** Nombre de la persona. */
    protected String nombre;

    /** Correo electrónico de la persona. */
    protected String correo;

    // == Constructor vacío ==
    /**
     * Constructor vacío. Crea una persona sin datos.
     */
    public Persona() { }

    // == Constructor completo ==
    /**
     * Constructor completo. Crea una persona con todos sus datos.
     *
     * @param id     identificador de la persona
     * @param nombre nombre de la persona
     * @param correo correo electrónico de la persona
     */
    public Persona(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    // == Setters ==
    /**
     * Asigna el identificador de la persona.
     *
     * @param id nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Asigna el nombre de la persona.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Asigna el correo electrónico de la persona.
     *
     * @param correo nuevo correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // == Getters ==
    /**
     * Regresa el identificador de la persona.
     *
     * @return identificador de la persona
     */
    public int getId() {
        return id;
    }

    /**
     * Regresa el nombre de la persona.
     *
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Regresa el correo electrónico de la persona.
     *
     * @return correo de la persona
     */
    public String getCorreo() {
        return correo;
    }

    // == Método abstracto ==
    /**
     * Muestra en pantalla la información de la persona.
     * Cada clase hija debe escribir su propia versión de este método.
     */
    public abstract void mostrarInformacion();
}
