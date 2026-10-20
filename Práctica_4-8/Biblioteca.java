
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

public class Biblioteca {

    // == Atributos ==
    private Libro[] libros;
    private Usuario[] usuarios;
    private int cantidadLibros;
    private int cantidadUsuarios;

    // == Constructor ==
    public Biblioteca() {
        libros = new Libro[100];
        usuarios = new Usuario[100];
        cantidadLibros = 0;
        cantidadUsuarios = 0;
    }

    // == Agregar libro ==
    public void agregarLibro(Libro libro) {
        if (cantidadLibros < libros.length) {
            libros[cantidadLibros] = libro;
            cantidadLibros++;
            System.out.println("Libro agregado correctamente.");
        } else {
            System.out.println("No hay espacio para más libros.");
        }
    }

    // == Eliminar libro ==
    public void eliminarLibro(String isbn) {
        int posicion = -1;

        // == Buscar posición del libro ==
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].getIsbn().equals(isbn)) {
                posicion = i;
                break;
            }
        }

        // == Eliminar libro encontrado ==
        if (posicion != -1) {
            if (libros[posicion].estaDisponible()) {
                for (int i = posicion; i < cantidadLibros - 1; i++) {
                    libros[i] = libros[i + 1];
                }

                cantidadLibros--;
                libros[cantidadLibros] = null;

                System.out.println("Libro eliminado correctamente.");
            } else {
                System.out.println("No se puede eliminar un libro prestado.");
            }
        } else {
            System.out.println("No se encontró el libro.");
        }
    }

    // == Buscar libro por ISBN ==
    public Libro buscarLibro(String isbn) {
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].getIsbn().equals(isbn)) {
                return libros[i];
            }
        }

        return null;
    }

    // == Buscar libro por título y autor ==
    public Libro buscarLibro(String titulo, String autor) {
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)
                    && libros[i].getAutor().equalsIgnoreCase(autor)) {
                return libros[i];
            }
        }

        return null;
    }

    // == Mostrar catálogo ==
    public void mostrarCatalogo() {
        System.out.println("===== CATÁLOGO DE LIBROS =====");

        if (cantidadLibros == 0) {
            System.out.println("No hay libros registrados.");
        } else {
            for (int i = 0; i < cantidadLibros; i++) {
                System.out.println("\nLibro " + (i + 1));
                libros[i].mostrarInformacion();
            }
        }
    }

    // == Registrar usuario ==
    public void registrarUsuario(Usuario usuario) {
        if (cantidadUsuarios < usuarios.length) {
            usuarios[cantidadUsuarios] = usuario;
            cantidadUsuarios++;
            System.out.println("Usuario registrado correctamente.");
        } else {
            System.out.println("No hay espacio para más usuarios.");
        }
    }

    // == Buscar usuario ==
    public Usuario buscarUsuario(int id) {
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i].getId() == id) {
                return usuarios[i];
            }
        }

        return null;
    }

    // == Mostrar usuarios ==
    public void mostrarUsuarios() {
        System.out.println("===== USUARIOS REGISTRADOS =====");

        if (cantidadUsuarios == 0) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (int i = 0; i < cantidadUsuarios; i++) {
                System.out.println("\nUsuario " + (i + 1));
                usuarios[i].mostrarInformacion();
            }
        }
    }
}
