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

    Interfaz que define el comportamiento de los
    objetos que se pueden prestar y devolver.
====================================*/

/**
 * Interfaz que funciona como un contrato de comportamiento:
 * cualquier clase que la implemente está obligada a tener
 * los métodos {@code prestar()} y {@code devolver()}.
 * <p>
 * En este proyecto la implementa la clase {@link Libro}.
 */
public interface Prestable {

    /**
     * Presta el objeto.
     */
    void prestar();

    /**
     * Devuelve el objeto.
     */
    void devolver();
}
