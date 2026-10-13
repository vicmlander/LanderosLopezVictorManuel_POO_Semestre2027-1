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

public class Libro {

    // == Atributos ==
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;

    // == Atributo estático ==
    private static int totalLibros = 0;

    // == Constructor vacío ==
    public Libro() { }

    // == Constructor con sobrecarga ==
    public Libro(String titulo, String autor) {
        isbn = "";
        this.titulo = titulo;
        this.autor = autor;
        anioPublicacion = 0;
        disponible = true;

        totalLibros++;
    }

    // == Constructor con sobrecarga ==
    public Libro(String isbn, String titulo, String autor, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        anioPublicacion = anio;
        disponible = true;

        totalLibros++;
    }

    // == Setters ==
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // == Getters ==
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public static int getTotalLibros() {
        return totalLibros;
    }

    // == Consultar disponibilidad ==
    public boolean estaDisponible() {
        return disponible;
    }

//10/10/26 se han modificado los metodos prestar y devolver 
//para que cambien su estado segun la existencia o devolucion de un libro

    // == Prestar libro ==
    public void prestar() {

        if (disponible==false) {
            System.out.println("El libro solicitado no se encuentra disponible");}
        
        else{
            System.out.println("prestamo autorizado");
            disponible=false;

    }
        }
        
    // == Devolver libro ==
    public void devolver() {
       if  (disponible == false){
        System.out.println("Libro devuelto");
         disponible=true;

       }else{
        System.out.println("Libro ya disponible");
         
       }
    }

    // == Mostrar información ==
    public void mostrarInformacion() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + anioPublicacion);
        System.out.println("Disponible: " + disponible);
    }
}