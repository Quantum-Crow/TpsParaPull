import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {
        System.out.println("Ingrese el numero: ");
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        int contador = 0;
        if (numero == 1) {
            System.out.println("El numero " + numero + " no es primo");
        }
        else {
            for (int i = 1; i <= 10; i++) {
                if (numero % i == 0) {
                    contador++;
                }
            }
            if (contador < 2) {
                System.out.println("El numero " + numero + " es primo ");

            } else
                System.out.println("El numero " + numero + " no es primo ");
        }
    }
}
