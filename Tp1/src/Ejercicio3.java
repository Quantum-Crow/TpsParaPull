import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        int num1 = num.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        int num2 = num.nextInt();

        int suma =  num1+num2;
        int resta =  num1-num2;
        int multiplicacion =  num1*num2;
        int division =  num1/num2;

        System.out.println("La suma de los numeros es: "+ suma);
        System.out.println("La resta de los numeros es: "+ resta );
        System.out.println("La multiplicacion de los numeros es: "+ multiplicacion);
        System.out.println("La division de los numeros es: "+ division);
    }

}
