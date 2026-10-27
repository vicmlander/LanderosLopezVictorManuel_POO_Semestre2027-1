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

    Clase principal que ejecuta los casos de prueba
    del sistema de gestión de biblioteca.
    El usuario elige qué hacer mediante un menú en consola.
====================================*/

import java.util.Scanner;

/**
 * Clase principal que ejecuta los casos de prueba
 * del sistema de gestión de biblioteca.
 * <p>
 * Al iniciar se cargan el bibliotecario y los libros de ejemplo, y después
 * se muestra un menú en consola para que el usuario elija qué operación realizar.
 */
public class Main {

    /** Objeto Scanner para leer los datos que escribe el usuario en la consola. */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Método principal del programa.
     *
     * @param args argumentos de la línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        // == Creación de la biblioteca ==
        Biblioteca biblioteca = new Biblioteca();

        // == Registro del bibliotecario ==
        System.out.println("===== REGISTRO DE EMPLEADOS =====");
        Bibliotecario bibliotecario = new Bibliotecario(100, "Laura Martínez",
                "laura@biblioteca.com", "Matutino", 12000.0);
        biblioteca.registrarEmpleado(bibliotecario);

        // == Caso 1: Registro de libros ==
        System.out.println("\n===== CASO 1: REGISTRO DE LIBROS =====");

        Libro javaBasico = new Libro();                // Constructor vacío + setters
        javaBasico.setIsbn("ISBN-001");
        javaBasico.setTitulo("Java Básico");
        javaBasico.setAutor("Varios autores");
        javaBasico.setAnioPublicacion(2020);

        Libro cleanCode = new Libro("ISBN-002", "Clean Code", "Robert C. Martin", 2008);
        Libro patrones = new Libro("ISBN-003", "Patrones de Diseño", "Erich Gamma", 1994);

        biblioteca.agregarLibro(javaBasico);
        biblioteca.agregarLibro(cleanCode);
        biblioteca.agregarLibro(patrones);

        // == Libros que ya estaban disponibles en la biblioteca ==
        biblioteca.agregarLibro(new Libro("ISBN-004", "Cien años de soledad", "Gabriel García Márquez", 1967));
        biblioteca.agregarLibro(new Libro("ISBN-005", "Don Quijote de la Mancha", "Miguel de Cervantes", 1605));

        Libro principito = new Libro("El Principito", "Antoine de Saint-Exupéry"); // Constructor con título y autor
        principito.setIsbn("ISBN-006");   // Se le asigna ISBN para poder buscarlo, prestarlo o eliminarlo desde el menú
        biblioteca.agregarLibro(principito);

        // == Punto extra: interfaz Prestable (polimorfismo) ==
        System.out.println("\n===== PUNTO EXTRA: INTERFAZ PRESTABLE =====");
        Prestable prestable = patrones;   // Un Libro se puede tratar como Prestable
        prestable.prestar();
        prestable.devolver();

        // == Declaración y definición de variables del menú ==
        int opcion = -1;            // Opción elegida por el usuario
        int id = 0;                 // ID de un usuario
        int anio = 0;               // Año de publicación de un libro
        String isbn = "";           // ISBN de un libro
        String titulo = "";         // Título de un libro
        String autor = "";          // Autor de un libro
        String nombre = "";         // Nombre de un usuario
        String correo = "";         // Correo de un usuario
        String telefono = "";       // Teléfono celular de un usuario
        String respuesta = "";      // Respuesta s/n del usuario
        Libro libro = null;         // Libro con el que se va a trabajar
        Libro encontrado = null;    // Libro encontrado en una búsqueda
        Usuario usuario = null;     // Usuario con el que se va a trabajar
        Prestamo prestamo = null;   // Préstamo con el que se va a trabajar

        // == Menú principal ==
        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro por ISBN");
            System.out.println("4. Buscar libro por título y autor");
            System.out.println("5. Consultar disponibilidad de un libro");
            System.out.println("6. Mostrar catálogo");
            System.out.println("7. Registrar usuario");
            System.out.println("8. Buscar usuario");
            System.out.println("9. Mostrar usuarios");
            System.out.println("10. Realizar préstamo");
            System.out.println("11. Devolver libro");
            System.out.println("12. Mostrar préstamos");
            System.out.println("13. Mostrar empleados");
            System.out.println("0. Salir");

            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {

                // == Agregar libro ==
                case 1:
                    System.out.println("\n===== AGREGAR LIBRO =====");
                    isbn = leerTexto("ISBN: ");

                    if (biblioteca.buscarLibro(isbn) != null) {
                        System.out.println("Ya existe un libro con ese ISBN.");
                    } else {
                        titulo = leerTexto("Título: ");
                        autor = leerTexto("Autor: ");
                        anio = leerEntero("Año de publicación: ");

                        biblioteca.agregarLibro(new Libro(isbn, titulo, autor, anio));
                    }
                    break;

                // == Eliminar libro ==
                case 2:
                    System.out.println("\n===== ELIMINAR LIBRO =====");
                    isbn = leerTexto("ISBN del libro a eliminar: ");

                    biblioteca.eliminarLibro(isbn);
                    break;

                // == Búsqueda de libros (sobrecarga de métodos) ==
                case 3:
                    System.out.println("\n===== BÚSQUEDA DE LIBROS =====");
                    isbn = leerTexto("ISBN del libro: ");

                    encontrado = biblioteca.buscarLibro(isbn);

                    if (encontrado == null) {
                        System.out.println("No se encontró el libro.");
                    } else {
                        System.out.println("Búsqueda por ISBN: " + encontrado.getTitulo());
                        encontrado.mostrarInformacion();
                    }
                    break;

                case 4:
                    System.out.println("\n===== BÚSQUEDA DE LIBROS =====");
                    titulo = leerTexto("Título del libro: ");
                    autor = leerTexto("Autor del libro: ");

                    encontrado = biblioteca.buscarLibro(titulo, autor);

                    if (encontrado == null) {
                        System.out.println("No se encontró el libro.");
                    } else {
                        System.out.println("Búsqueda por título y autor: " + encontrado.getTitulo());
                        encontrado.mostrarInformacion();
                    }
                    break;

                // == Consultar disponibilidad de un libro ==
                case 5:
                    System.out.println("\n===== DISPONIBILIDAD DE LIBRO =====");
                    isbn = leerTexto("ISBN del libro: ");

                    libro = biblioteca.buscarLibro(isbn);

                    if (libro == null) {
                        System.out.println("No se encontró el libro.");
                    } else {
                        System.out.println("Libro: " + libro.getTitulo());
                        libro.mostrarDisponibilidad();
                    }
                    break;

                // == Mostrar catálogo ==
                case 6:
                    System.out.println();
                    biblioteca.mostrarCatalogo();
                    System.out.println("\nTotal de libros creados: " + Libro.getTotalLibros());
                    break;

                // == Caso 2: Registro de usuarios ==
                case 7:
                    System.out.println("\n===== REGISTRO DE USUARIOS =====");
                    id = leerEntero("ID del usuario: ");

                    if (biblioteca.buscarUsuario(id) != null) {
                        System.out.println("Ya existe un usuario con ese ID.");
                    } else {
                        nombre = leerTexto("Nombre: ");
                        correo = leerTexto("Correo: ");
                        telefono = leerTexto("Teléfono celular (ej. 55-55-55-55-55): ");

                        // Se pregunta hasta que la respuesta sea s o n
                        respuesta = "";
                        while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n")) {
                            respuesta = leerTexto("¿El usuario está activo? (s/n): ");
                        }

                        usuario = new Usuario(id, nombre, correo, respuesta.equalsIgnoreCase("s"));
                        usuario.setTelefonoCelular(telefono);

                        biblioteca.registrarUsuario(usuario);
                    }
                    break;

                // == Buscar usuario ==
                case 8:
                    System.out.println("\n===== BÚSQUEDA DE USUARIOS =====");
                    id = leerEntero("ID del usuario: ");

                    usuario = biblioteca.buscarUsuario(id);

                    if (usuario == null) {
                        System.out.println("No se encontró el usuario.");
                    } else {
                        usuario.mostrarInformacion();
                    }
                    break;

                // == Mostrar usuarios ==
                case 9:
                    System.out.println();
                    biblioteca.mostrarUsuarios();
                    break;

                // == Caso 3: Solicitud de préstamo ==
                case 10:
                    System.out.println("\n===== SOLICITUD DE PRÉSTAMO =====");
                    id = leerEntero("ID del usuario: ");
                    isbn = leerTexto("ISBN del libro: ");

                    usuario = biblioteca.buscarUsuario(id);
                    libro = biblioteca.buscarLibro(isbn);

                    // El bibliotecario solo autoriza el préstamo si se puede realizar
                    if (usuario != null && libro != null
                            && usuario.getActivo() && libro.estaDisponible()) {
                        bibliotecario.autorizarPrestamo();
                        biblioteca.realizarPrestamo(usuario, libro);

                        prestamo = biblioteca.buscarPrestamo(usuario, libro);

                        System.out.println("\nResultado:");
                        System.out.println("Libro disponible = " + libro.estaDisponible());
                        System.out.println("Préstamo activo = " + prestamo.estaActivo());
                    } else {
                        biblioteca.realizarPrestamo(usuario, libro);   // Muestra por qué no se pudo prestar
                    }
                    break;

                // == Caso 4: Devolución de libro ==
                case 11:
                    System.out.println("\n===== DEVOLUCIÓN DE LIBRO =====");
                    id = leerEntero("ID del usuario: ");
                    isbn = leerTexto("ISBN del libro: ");

                    usuario = biblioteca.buscarUsuario(id);
                    libro = biblioteca.buscarLibro(isbn);
                    prestamo = biblioteca.buscarPrestamo(usuario, libro);

                    biblioteca.devolverLibro(prestamo);

                    if (prestamo != null) {
                        System.out.println("\nResultado:");
                        System.out.println("Libro disponible = " + libro.estaDisponible());
                        System.out.println("Préstamo activo = " + prestamo.estaActivo());
                    }
                    break;

                // == Mostrar préstamos ==
                case 12:
                    System.out.println();
                    biblioteca.mostrarPrestamos();
                    break;

                // == Mostrar empleados ==
                case 13:
                    System.out.println();
                    biblioteca.mostrarEmpleados();
                    break;

                // == Salir ==
                case 0:
                    System.out.println("\nPrograma finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

    }

    // == Leer número entero ==
    /**
     * Pide al usuario un número entero y lo vuelve a pedir
     * mientras lo que escriba no sea un número.
     *
     * @param mensaje texto que se muestra para pedir el dato
     * @return número entero escrito por el usuario
     */
    public static int leerEntero(String mensaje) {
        int numero = 0;

        System.out.print(mensaje);

        while (!sc.hasNextInt()) {
            System.out.print("Dato no válido. Escribe un número: ");
            sc.nextLine();
        }

        numero = sc.nextInt();
        sc.nextLine();   // Limpia el salto de línea que queda después del número

        return numero;
    }

    // == Leer texto ==
    /**
     * Pide al usuario un texto y lo vuelve a pedir
     * mientras lo deje vacío.
     *
     * @param mensaje texto que se muestra para pedir el dato
     * @return texto escrito por el usuario
     */
    public static String leerTexto(String mensaje) {
        String texto = "";

        System.out.print(mensaje);
        texto = sc.nextLine().trim();

        while (texto.equals("")) {
            System.out.print("El dato no puede quedar vacío. Escribe de nuevo: ");
            texto = sc.nextLine().trim();
        }

        return texto;
    }
}
