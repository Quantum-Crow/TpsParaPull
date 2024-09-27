import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero mayor o igual a 0: ");
        int num = sc.nextInt();

        do {
            if (num <0) {
                System.out.println(num + " es menor que 0, ingrese otro numero");
                num = sc.nextInt();
            }
        }
        while (num < 0);
        System.out.println("Okay el numero es "+num);

    }
}