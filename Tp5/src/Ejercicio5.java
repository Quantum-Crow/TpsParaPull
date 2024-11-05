import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de filas (mayor o igual a 2): ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese la cantidad de columnas (mayor o igual a 2): ");
        int columnas = scanner.nextInt();

        if (filas < 2 || columnas < 2) {
            System.out.println("Las filas y columnas deben ser mayores o iguales a 2.");
            return;
        }

        int[][] matriz = new int[filas][columnas];

        System.out.println("Ingrese los valores para la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        int suma = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma += matriz[i][j];
            }
        }
        int promedio = suma / (filas * columnas);
        System.out.println("El promedio entero de los elementos de la matriz es: " + promedio);

        boolean encontrado = false;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] == promedio) {
                    System.out.println("El promedio se encuentra en la posición [" + i + "][" + j + "]");
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ninguna coincidencia.");
        }

    }
}
