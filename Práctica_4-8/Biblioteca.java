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

    Coronado Ramirez Luis Angel
    No: 426059057

    Clase encargada de administrar los libros
    y usuarios de la biblioteca.
====================================*/

import java.util.ArrayList;

/**
 * Clase principal del sistema. Administra los libros, usuarios,
 * empleados y préstamos de la biblioteca.
 * <p>
 * Aplica composición, ya que la biblioteca está formada por
 * listas (ArrayList) de libros, usuarios, bibliotecarios y préstamos.
 */
public class Biblioteca {

    // == Atributos ==
    /** Lista de libros de la biblioteca. */
    private ArrayList<Libro> libros;

    /** Lista de usuarios registrados. */
    private ArrayList<Usuario> usuarios;

    /** Lista de bibliotecarios (empleados) de la biblioteca. */
    private ArrayList<Bibliotecario> empleados;

    /** Lista de préstamos realizados. */
    private ArrayList<Prestamo> prestamos;

    // == Constructor ==
    /**
     * Crea una biblioteca e inicializa todas las listas vacías.
     */
    public Biblioteca() {
        libros = new ArrayList<Libro>();
        usuarios = new ArrayList<Usuario>();
        empleados = new ArrayList<Bibliotecario>();
        prestamos = new ArrayList<Prestamo>();
    }

    // ==================== GESTIÓN DE LIBROS ====================

    // == Agregar libro ==
    /**
     * Agrega un libro al catálogo de la biblioteca.
     *
     * @param libro libro que se va a agregar
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado correctamente.");
    }

    // == Eliminar libro ==
    /**
     * Elimina un libro del catálogo usando su ISBN.
     * No se puede eliminar un libro que está prestado.
     *
     * @param isbn ISBN del libro que se va a eliminar
     */
    public void eliminarLibro(String isbn) {
        int posicion = -1;

        // == Buscar posición del libro ==
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)) {
                posicion = i;
                break;
            }
        }

        // == Eliminar libro encontrado ==
        if (posicion != -1) {
            if (libros.get(posicion).estaDisponible()) {
                libros.remove(posicion);

                System.out.println("Libro eliminado correctamente.");
            } else {
                System.out.println("No se puede eliminar un libro prestado.");
            }
        } else {
            System.out.println("No se encontró el libro.");
        }
    }

    // == Buscar libro por ISBN ==
    /**
     * Busca un libro por su ISBN.
     *
     * @param isbn ISBN del libro a buscar
     * @return el libro encontrado, o null si no existe
     */
    public Libro buscarLibro(String isbn) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)) {
                return libros.get(i);
            }
        }

        return null;
    }

    // == Buscar libro por título y autor ==
    /**
     * Busca un libro por su título y autor (sobrecarga de buscarLibro).
     *
     * @param titulo título del libro a buscar
     * @param autor  autor del libro a buscar
     * @return el libro encontrado, o null si no existe
     */
    public Libro buscarLibro(String titulo, String autor) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equalsIgnoreCase(titulo)
                    && libros.get(i).getAutor().equalsIgnoreCase(autor)) {
                return libros.get(i);
            }
        }

        return null;
    }

    // == Mostrar catálogo ==
    /**
     * Muestra en pantalla todos los libros del catálogo.
     */
    public void mostrarCatalogo() {
        System.out.println("===== CATÁLOGO DE LIBROS =====");

        if (libros.size() == 0) {
            System.out.println("No hay libros registrados.");
        } else {
            for (int i = 0; i < libros.size(); i++) {
                System.out.println("\nLibro " + (i + 1));
                libros.get(i).mostrarInformacion();
            }
        }
    }

    // ==================== GESTIÓN DE USUARIOS ====================

    // == Registrar usuario ==
    /**
     * Registra un usuario en la biblioteca.
     *
     * @param usuario usuario que se va a registrar
     */
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario registrado correctamente.");
    }

    // == Buscar usuario ==
    /**
     * Busca un usuario por su ID.
     *
     * @param id ID del usuario a buscar
     * @return el usuario encontrado, o null si no existe
     */
    public Usuario buscarUsuario(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                return usuarios.get(i);
            }
        }

        return null;
    }

    // == Mostrar usuarios ==
    /**
     * Muestra en pantalla todos los usuarios registrados.
     */
    public void mostrarUsuarios() {
        System.out.println("===== USUARIOS REGISTRADOS =====");

        if (usuarios.size() == 0) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println("\nUsuario " + (i + 1));
                usuarios.get(i).mostrarInformacion();
            }
        }
    }

    // ==================== GESTIÓN DE EMPLEADOS ====================

    // == Registrar empleado ==
    /**
     * Registra un bibliotecario como empleado de la biblioteca.
     *
     * @param empleado bibliotecario que se va a registrar
     */
    public void registrarEmpleado(Bibliotecario empleado) {
        empleados.add(empleado);
        System.out.println("Empleado registrado correctamente.");
    }

    // == Mostrar empleados ==
    /**
     * Muestra en pantalla todos los empleados de la biblioteca.
     */
    public void mostrarEmpleados() {
        System.out.println("===== EMPLEADOS REGISTRADOS =====");

        if (empleados.size() == 0) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (int i = 0; i < empleados.size(); i++) {
                System.out.println("\nEmpleado " + (i + 1));
                empleados.get(i).mostrarInformacion();
            }
        }
    }

    // ==================== GESTIÓN DE PRÉSTAMOS ====================

    // == Realizar préstamo ==
    /**
     * Realiza el préstamo de un libro a un usuario.
     * Solo se presta si el usuario está activo y el libro está disponible.
     *
     * @param usuario usuario que solicita el préstamo
     * @param libro   libro que se va a prestar
     */
    public void realizarPrestamo(Usuario usuario, Libro libro) {
        if (usuario == null || libro == null) {
            System.out.println("No se encontró el usuario o el libro.");
        } else if (!usuario.getActivo()) {
            System.out.println("El usuario no está activo.");
        } else if (!libro.estaDisponible()) {
            System.out.println("El libro solicitado no se encuentra disponible");
        } else {
            Prestamo prestamo = new Prestamo(usuario, libro);
            prestamo.iniciarPrestamo();
            prestamos.add(prestamo);

            System.out.println("Préstamo realizado correctamente.");
        }
    }

    // == Devolver libro ==
    /**
     * Finaliza un préstamo y devuelve el libro a la biblioteca.
     *
     * @param prestamo préstamo que se va a finalizar
     */
    public void devolverLibro(Prestamo prestamo) {
        if (prestamo == null) {
            System.out.println("No se encontró el préstamo.");
        } else if (prestamo.estaActivo()) {
            prestamo.finalizarPrestamo();

            System.out.println("Préstamo finalizado correctamente.");
        } else {
            System.out.println("El préstamo ya había sido finalizado.");
        }
    }

    // == Buscar préstamo ==
    /**
     * Busca el préstamo activo de un usuario con un libro.
     *
     * @param usuario usuario del préstamo
     * @param libro   libro del préstamo
     * @return el préstamo activo encontrado, o null si no existe
     */
    public Prestamo buscarPrestamo(Usuario usuario, Libro libro) {
        for (int i = 0; i < prestamos.size(); i++) {
            // Se compara que sea el mismo objeto usuario y el mismo objeto libro
            if (prestamos.get(i).getUsuario() == usuario
                    && prestamos.get(i).getLibro() == libro
                    && prestamos.get(i).estaActivo()) {
                return prestamos.get(i);
            }
        }

        return null;
    }

    // == Mostrar préstamos ==
    /**
     * Muestra en pantalla todos los préstamos registrados.
     */
    public void mostrarPrestamos() {
        System.out.println("===== PRÉSTAMOS REGISTRADOS =====");

        if (prestamos.size() == 0) {
            System.out.println("No hay préstamos registrados.");
        } else {
            for (int i = 0; i < prestamos.size(); i++) {
                Prestamo prestamo = prestamos.get(i);

                System.out.println("\nPréstamo " + (i + 1));
                System.out.println("Usuario: " + prestamo.getUsuario().getNombre());
                System.out.println("Libro: " + prestamo.getLibro().getTitulo());
                System.out.println("Fecha de préstamo: " + prestamo.getFechaPrestamo());
                System.out.println("Fecha de devolución: " + prestamo.getFechaDevolucion());
                System.out.println("Activo: " + prestamo.estaActivo());
            }
        }
    }
}
