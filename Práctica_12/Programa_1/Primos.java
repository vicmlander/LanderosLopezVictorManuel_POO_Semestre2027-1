/* =====================================================
Práctica 12
Villalobos Estrada Osvaldo
322024443
Hija de Operacion: cuenta los números primos hasta n con la criba de Eratóstenes y muestra el mayor.
===================================================== */

public class Primos extends Operacion {

    public Primos(int n) {
        super("Primos", n);
    }

    @Override
    protected String calcular() {
        // esPrimo[i] será true si i es primo; se asume que todos lo son y se descartan los compuestos
        boolean[] esPrimo = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            esPrimo[i] = true;
        }

        // Por cada primo i se tachan sus múltiplos desde i*i, porque los menores ya fueron tachados antes
        for (int i = 2; i * i <= n; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= n; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        // Se cuentan los primos y se guarda el mayor encontrado
        int cantidad = 0;
        int mayor = 0;
        for (int i = 2; i <= n; i++) {
            if (esPrimo[i]) {
                cantidad++;
                mayor = i;
            }
        }

        if (cantidad == 0) {
            return "No hay primos menores o iguales a " + n;
        }
        return "Primos <= " + n + ": " + cantidad + " (el mayor es " + mayor + ")";
    }
}
