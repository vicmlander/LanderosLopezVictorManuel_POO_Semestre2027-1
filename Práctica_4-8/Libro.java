/*====================================
    Práctica 4-8
    Programación Orientada a Objetos 2027-1

    Melgarejo Cervantes Manuel Alejandro.
    Coronado Ramirez LUis Angel
    Equipo 1
    No: 322063132
    No: 426059057

    Clase que representa un libro de la biblioteca
    y controla su disponibilidad.
====================================*/

/**
 * Clase que representa un libro físico de la biblioteca
 * y controla su disponibilidad.
 * <p>
 * Implementa la interfaz {@link Prestable}, por lo que
 * está obligada a tener los métodos prestar() y devolver().
 */
public class Libro implements Prestable {

    // == Atributos ==
    /** Código ISBN del libro. */
    private String isbn;

    /** Título del libro. */
    private String titulo;

    /** Autor del libro. */
    private String autor;

    /** Año de publicación del libro. */
    private int anioPublicacion;

    /** Indica si el libro está disponible para préstamo. */
    private boolean disponible;

    // == Atributo estático ==
    /** Contador de todos los objetos Libro creados en el sistema. Es compartido por todos los libros. */
    private static int totalLibros = 0;

    // == Constructor vacío ==
    /**
     * Constructor vacío. Crea un libro sin datos, disponible,
     * y aumenta el contador de libros.
     */
    public Libro() {
        isbn = "";
        titulo = "";
        autor = "";
        anioPublicacion = 0;
        disponible = true;

        totalLibros++;
    }

    // == Constructor con sobrecarga ==
    /**
     * Constructor que crea un libro solo con título y autor.
     *
     * @param titulo título del libro
     * @param autor  autor del libro
     */
    public Libro(String titulo, String autor) {
        isbn = "";
        this.titulo = titulo;
        this.autor = autor;
        anioPublicacion = 0;
        disponible = true;

        totalLibros++;
    }

    // == Constructor con sobrecarga ==
    /**
     * Constructor que crea un libro con todos sus datos.
     *
     * @param isbn   código ISBN del libro
     * @param titulo título del libro
     * @param autor  autor del libro
     * @param anio   año de publicación del libro
     */
    public Libro(String isbn, String titulo, String autor, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        anioPublicacion = anio;
        disponible = true;

        totalLibros++;
    }

    // == Setters ==
    /**
     * Asigna el ISBN del libro.
     *
     * @param isbn nuevo ISBN
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Asigna el título del libro.
     *
     * @param titulo nuevo título
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Asigna el autor del libro.
     *
     * @param autor nuevo autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Asigna el año de publicación del libro.
     *
     * @param anioPublicacion nuevo año de publicación
     */
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    /**
     * Asigna si el libro está disponible o no.
     *
     * @param disponible true si está disponible, false si no
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // == Getters ==
    /**
     * Regresa el ISBN del libro.
     *
     * @return ISBN del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Regresa el título del libro.
     *
     * @return título del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Regresa el autor del libro.
     *
     * @return autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Regresa el año de publicación del libro.
     *
     * @return año de publicación
     */
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    /**
     * Regresa si el libro está disponible.
     *
     * @return true si está disponible, false si no
     */
    public boolean getDisponible() {
        return disponible;
    }

    /**
     * Regresa cuántos libros se han creado en el sistema.
     * Es static porque pertenece a la clase y no a un libro en particular.
     *
     * @return total de libros creados
     */
    public static int getTotalLibros() {
        return totalLibros;
    }

    // == Consultar disponibilidad ==
    /**
     * Consulta si el libro está disponible para préstamo.
     *
     * @return true si está disponible, false si no
     */
    public boolean estaDisponible() {
        return disponible;
    }

//10/10/26 se han modificado los metodos prestar y devolver
//para que cambien su estado segun la existencia o devolucion de un libro

    // == Prestar libro ==
    /**
     * Presta el libro si está disponible y lo marca como no disponible.
     * Viene de la interfaz Prestable.
     */
    @Override
    public void prestar() {
        if (disponible == false) {
            System.out.println("El libro solicitado no se encuentra disponible");
        } else {
            System.out.println("prestamo autorizado");
            disponible = false;
        }
    }

    // == Devolver libro ==
    /**
     * Devuelve el libro si estaba prestado y lo marca como disponible.
     * Viene de la interfaz Prestable.
     */
    @Override
    public void devolver() {
        if (disponible == false) {
            System.out.println("Libro devuelto");
            disponible = true;
        } else {
            System.out.println("Libro ya disponible");
        }
    }

    //17/10/26 se agrego el metodo mostrar disponibilidad
    /**
     * Muestra en pantalla si el libro está disponible o no.
     */
    public void mostrarDisponibilidad() {
        if (disponible == false) {
            System.out.println("El libro no esta disponible");
        } else {
            System.out.println("el libro esta disponible");
        }
    }

    // == Mostrar información ==
    /**
     * Muestra en pantalla la información del libro.
     */
    public void mostrarInformacion() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + anioPublicacion);
        System.out.println("Disponible: " + disponible);
    }
}
