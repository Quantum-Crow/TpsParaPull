import java.util.Scanner;
public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        double precio_iva = precio * 1.21;
        System.out.println("El precio del producto con iva es: " + precio_iva);
    }
}
