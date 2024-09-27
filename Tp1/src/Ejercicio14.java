import java.util.Scanner;
import java.util.Random;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int NumAleatorio = rand.nextInt(100);
        int intentos = 1;

        System.out.println("Bienvenido, adivina el numero generado");
        int numingresado = sc.nextInt();
            while (numingresado != NumAleatorio) {
                if (numingresado > NumAleatorio) {
                    System.out.println("El numero generado es menor");
                    numingresado = sc.nextInt();
                    intentos++;
                }
                else {
                    System.out.println("El numero generado es mayor");
                    numingresado = sc.nextInt();
                    intentos++;
                }

        }
        System.out.println("Acertaste");
        System.out.println("Numero de intentos: "+intentos);
    }
}
