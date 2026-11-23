/* =====================================================
Práctica 12
Villalobos Estrada Osvaldo
322024443
Clase base abstracta: es un hilo que mide su tiempo y guarda el resultado de una operación matemática.
===================================================== */

import java.math.BigInteger;

public abstract class Operacion extends Thread {

    // Nombre que se muestra en consola y valor sobre el que se calcula
    protected final String nombre;
    protected final int n;

    // Se llenan dentro del hilo y se leen desde main solo después de join(), por eso no requieren synchronized
    private String resultado = "sin calcular";
    private long tiempoMs = 0;

    public Operacion(String nombre, int n) {
        this.nombre = nombre;
        this.n = n;
    }

    // Cada clase hija implementa aquí su cálculo y devuelve el resultado como texto
    protected abstract String calcular();

    // Da formato a un número grande: si es corto se muestra completo, si no, solo sus primeros dígitos y cuántos tiene
    protected String formatear(BigInteger valor) {
        String texto = valor.toString();
        if (texto.length() <= 30) {
            return texto;
        }
        return texto.substring(0, 15) + "... (" + texto.length() + " dígitos)";
    }

    // Lo ejecuta el hilo al llamar start(): mide el tiempo y delega el cálculo a la clase hija (polimorfismo)
    @Override
    public void run() {
        System.out.println("[" + nombre + "] iniciada");
        long inicio = System.nanoTime();
        resultado = calcular();
        tiempoMs = (System.nanoTime() - inicio) / 1_000_000;
        System.out.println("[" + nombre + "] terminada");
    }

    // Getters que main usa para mostrar los datos una vez que el hilo terminó
    public String getResultado() {
        return resultado;
    }

    public long getTiempoMs() {
        return tiempoMs;
    }
}
