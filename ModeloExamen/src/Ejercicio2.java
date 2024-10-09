import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Indique el tamaño de la matriz");
            System.out.print("Filas: ");
            int filas = scanner.nextInt();
            System.out.print("Columnas: ");
            int columnas = scanner.nextInt();

            if (filas < 3 || columnas < 2) {
                System.out.println("El tamaño mínimo válido de la matriz es 3x2.");
                return;
            }
            double[][] v1 = new double[filas][columnas];

            System.out.println("Ingrese los valores:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                    v1[i][j] = scanner.nextDouble();
                }
            }
            System.out.println("La matriz cargada es:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
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
            System.out.println("La matriz de sumatorias es:");
            for (int i = 0; i < filas; i++) {
                System.out.println(sumatorias[i]);
            }
            double[][] nuevaMatriz = new double[filas][2];

            for (int i = 0; i < filas; i++) {
                nuevaMatriz[i][0] = sumatorias[i];
                nuevaMatriz[i][1] = i;
            }
            Arrays.sort(nuevaMatriz, (a, b) -> Double.compare(b[0], a[0]));

            System.out.println("La nueva matriz ordenada es:");
            for (int i = 0; i < filas; i++) {
                System.out.println(nuevaMatriz[i][0] + " " + nuevaMatriz[i][1]);
            }
            double sumaColumna1 = 0;
            for (int i = 0; i < filas; i++) {
                sumaColumna1 += nuevaMatriz[i][0];
            }
            System.out.println("  ");
            System.out.println("La sumatoria de la primera columna de la nueva matriz es: " + sumaColumna1);
        }
}
