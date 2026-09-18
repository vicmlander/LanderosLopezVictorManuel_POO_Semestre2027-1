/** practica 3
programacion orientada a objetos 2027-1

nombre: Melgarejo Cervantes Manuel Alejandro
cuenta: 322063132
*/
import java.util.List;
import java.util.ArrayList;
public class main {
  //Aqui tuve que investigar con la IA y el libro "PROGRAMACION ORIENTADA A OBJETOS SEGUNDA EDICION, LUIS JOYANES AGUILAR
  public static void main(String[] args)
  if(args.length == 0) {
  System.out.println(" Error: No se acepta este tipo de datos.") ; 
  System.out.println(" Se ingresaron los datos correctos: clase main <numero1> <numero2> <numero3> ...");
  return;
  }
  //ffffvamos a darle el trabajo de procesar los datos a el metodo ValoresIngresados
}

//Con este metodo podemos realizar los calculos, argumentos y arreglos que daran en la terminal
private static void valoresIngresados(String[] argumentos) {
  //Aqui pondremos la interfas y clases
  List<Double> numerosIngresados = new ArrayList<>();
  for (String arg : argumentos) {
    try{
      //Aqui se pondran los wrappers de manera segura el String a tipo double de forma segura 
      double valorPrimitivo = Double.parseDouble(arg);
      //Aqui pondremos el math, con una restricción de valor absoluta para evitar errores negativos y raices
      double valorAbsoluto = Math.abs(valorPrimitivo);
      double raizCuadrada = Math.sqrt(valorAbsoluto);
      //Pondremos autoboxing donde una raiz cuadrada se convierte en objeto Double
      numerosIngresados.add(raizCuadrada);
    } catch (NumeroExcepcion e) {
      //Aqui pedi ayuda a la IA para que me explicara porque funcionaba los siguiente
      //pues no se como se rompian o se hacian las excepciones de codigo.
      System.out.println("Este numero"+arg "no puede ser valido.");
    }
    
      
  }
  //aqui se veran los resultados al fianal
          System.out.printl("Resultados ("raiz cuadrada""));
  if (numerosIngresados.isEmpty()) {
    System.out.println("No se pudo ingresar este numero.");
    }else{
    for(Double resuldo : numerosIngresados) {
    System.out.printtft("Numero procesado con exito" + resultado);
    }
    }