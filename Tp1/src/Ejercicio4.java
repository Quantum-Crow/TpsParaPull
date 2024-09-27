import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        int num1 = sc.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        int num2 = sc.nextInt();

        if (num1 > num2) {
            System.out.println("El primer numero mayor que el segundo numero");
        }
        else if (num1 < num2) {
            System.out.println("El segundo numero mayor que el primer numero");
        }
        else
            System.out.println("Los numeros son iguales");
        }

    }

