/* =====================================================
Práctica 12
Villalobos Estrada Osvaldo
322024443
Hija de Operacion: calcula el factorial de n usando BigInteger para soportar números muy grandes.
===================================================== */

import java.math.BigInteger;

public class Factorial extends Operacion {

    public Factorial(int n) {
        // Reutiliza el constructor de la clase base
        super("Factorial", n);
    }

    // Multiplica 2 * 3 * ... * n con BigInteger, porque un long se desborda desde 21!
    @Override
    protected String calcular() {
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return n + "! = " + formatear(resultado);
    }
}
