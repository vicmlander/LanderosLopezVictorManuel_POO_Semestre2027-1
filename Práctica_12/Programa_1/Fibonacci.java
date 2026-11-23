/* =====================================================
Práctica 12
Villalobos Estrada Osvaldo
322024443
Hija de Operacion: calcula el n-ésimo término de la sucesión de Fibonacci de forma iterativa.
===================================================== */

import java.math.BigInteger;

public class Fibonacci extends Operacion {

    public Fibonacci(int n) {
        super("Fibonacci", n);
    }

    // Se guardan solo los dos últimos términos y se avanza n veces; es mucho más rápido que la recursión
    @Override
    protected String calcular() {
        BigInteger anterior = BigInteger.ZERO;   // F(0)
        BigInteger actual = BigInteger.ONE;      // F(1)

        for (int i = 2; i <= n; i++) {
            BigInteger siguiente = anterior.add(actual);
            anterior = actual;
            actual = siguiente;
        }
        return "F(" + n + ") = " + formatear(actual);
    }
}
