import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int filas = 0;
        int columnas = 0;

        while (filas < 3 || columnas < 2) {
            System.out.print("Ingrese el número de filas (mínimo 3): ");
            filas = scanner.nextInt();
            System.out.print("Ingrese el número de columnas (mínimo 2): ");
            columnas = scanner.nextInt();

            if (filas < 3 || columnas < 2) {
                System.out.println("El tamaño de la matriz debe ser al menos 3x2. Intente nuevamente.");
            }
        }

        double[][] v1 = new double[filas][columnas];
        System.out.println("Ingrese los valores para la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                v1[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("Nuestro vector");
        for (int i = 0; i < v1.length; i++) {
            for (int j = 0; j < v1[i].length; j++) {
                System.out.print(v1[i][j] + " ");
            }
            System.out.println();
        }

        double[] sumatorias = new double[filas];
        for (int i = 0; i < filas; i++) {
            double suma = 0;
            for (int j = 0; j < columnas; j++) {
                suma += v1[i][j];
            }
            sumatorias[i] = suma;
        }
        System.out.println("Matriz de sumatorias:");
        for (int i = 0; i < filas; i++) {
            System.out.println(sumatorias[i]);
        }

        double[][] matrizOrdenada = new double[filas][2];

        for (int i = 0; i < filas; i++) {
            matrizOrdenada[i][0] = sumatorias[i];
            matrizOrdenada[i][1] = i;
        }
        Arrays.sort(matrizOrdenada, (a, b) -> Double.compare(b[0], a[0]));
        System.out.println("Matriz ordenada de mayor a menor con índices originales:");
        for (int i = 0; i < filas; i++) {
            System.out.println(matrizOrdenada[i][0] + " " + matrizOrdenada[i][1]);
        }
        double sumaColumna1 = 0;
        for (int i = 0; i < filas; i++) {
            sumaColumna1 += matrizOrdenada[i][0];
        }
        System.out.println("Sumatoria de la primera columna de la matriz ordenada: " + sumaColumna1);

    }
}
