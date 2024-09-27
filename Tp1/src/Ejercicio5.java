import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero: ");
        int num1 = sc.nextInt();

        if (num1 % 2 == 0) {
            System.out.println("El numero es divisible por 2");
        }
        else {
            System.out.println("El numero no es divisible por 2");
        }

    }
}
