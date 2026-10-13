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

public class Prestamo {

    // == Atributos ==
    private Usuario usuario;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private boolean activo;

    // == Constructor ==
    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        fechaPrestamo = "";
        fechaDevolucion = "";
        activo = false;
    }

    // == Setters ==
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // == Getters ==
    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean getActivo() {
        return activo;
    }

    // == Iniciar préstamo ==
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
    public void finalizarPrestamo() {
        if (activo) {
            libro.devolver();
            usuario.devolverLibro();

            fechaDevolucion = "Préstamo finalizado";
            activo = false;
        }
    }

    // == Consultar estado del préstamo ==
    public boolean estaActivo() {
        return activo;
    }
}
