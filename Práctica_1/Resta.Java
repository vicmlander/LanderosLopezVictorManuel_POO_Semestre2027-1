/*============== practica 1 ================
programaciòn orientada a objetos 2027-1

Coronado Ramirez Luis Angel  Equipo 1
Cuenta: 426059057
============================================*/
//importacion del scanner para la entrada de los datos
import java.util.Scanner;
public class Resta {
    public static void main(String[]args){
        //inicializacion del scanner
        Scanner teclado = new Scanner (System.in);
        //solicitud del primer numero
        System.out.println("ingrese el primer entero:");
        //almacenamiento del primer numero
        double num1 = teclado.nextDouble();
        //solicitud del segundo numero
        System.out.println("ingrese el segundo entero:");
        //almacenamiento del segundo numero
        double num2 = teclado.nextDouble();
        //realiza la operacion 
        double resultado = num1- num2;
        //imprime el resultado en pantalla
        System.out.println("El resultado es:" +resultado);
    } 
}