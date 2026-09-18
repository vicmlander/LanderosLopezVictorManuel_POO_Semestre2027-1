import java.util.HashMap;
import java.util.Map;
/**
Práctica 3
    Programación Orientada a Objetos 2027-1

    Melgarejo Cervantes Manuel Alejandro
    Equipo 1
    No cuenta: 322063132
  */
public class inventario {
  piblic static void main(String[] args) { 

  Map<Integer, Double> inventario = new HashMap<>();

  inventario.put(101, 45.5);
    inventario.put(102, 120.0);
    inventario.put(103, 8.75);

  System.out.println(  "Empezando inventario" );
    mostrarInventario(inventario);
aplicarRedondeoSeguro(inventario);
    System.out.println("Terminando inventario");

  }
   private static void aplicarRedondeoSeguro(Map<Integer, Double> mapa) {
if (mapa == null || mapa.isEmpty()) { 
  return;
}
    for (Map.Entry<Integer, Double> elemento : mapa.entrySet()) {
      double stockActual = elemento.getValue();
      double stockRedondeado = Math.ceil(stockActual);

      elemento.setValue(stockredondeado);
    }}

  private static void mostrarinventario(Map<Integer, double> mapa){ 
    for (Map.Entry<Integer, Double> registro : mapa.entrySet()) {

      System.out.println("Codigo Producto: " + registro.getKey() + " | almacen disponible: " + registro.getValue());
    }
  }
}