import java.util.Scanner;

public class Ejercicio4 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[] array = new int[20];

            System.out.println("Ingrese 20 elementos enteros:");
            for (int i = 0; i < 20; i++) {
                array[i] = scanner.nextInt();
            }

            System.out.println("Array original:");
            for (int j : array) {
                System.out.print(j + " ");
            }
            System.out.println();

            System.out.println("¿Desea ordenar el array de forma ASCENDENTE o DESCENDENTE? (ASC/DESC)");
            String orden = scanner.next();

            System.out.println("¿Qué método de ordenamiento desea aplicar? (insercion, burbuja, selección)");
            String metodo = scanner.next();

            switch (metodo.toLowerCase()) {
                case "insercion":
                    insercion(array, orden);
                    break;
                case "burbuja":
                    burbuja(array, orden);
                    break;
                case "selección":
                    seleccion(array, orden);
                    break;
                default:
                    System.out.println("Método de ordenamiento no válido.");
                    return;
            }

            System.out.println("Array ordenado:");
            for (int j : array) {
                System.out.print(j + " ");
            }
        }
        public static void insercion(int[] array, String orden) {
            int n = array.length;
            boolean asc = orden.equalsIgnoreCase("ASC");
            for (int i = 1; i < n; ++i) {
                int key = array[i];
                int j = i - 1;

                while (j >= 0 && ((asc && array[j] > key) || (!asc && array[j] < key))) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }
        }

        public static void burbuja(int[] array, String orden) {
            int n = array.length;
            boolean asc = orden.equalsIgnoreCase("ASC");
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if ((asc && array[j] > array[j + 1]) || (!asc && array[j] < array[j + 1])) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }

        public static void seleccion(int[] array, String orden) {
            int n = array.length;
            boolean asc = orden.equalsIgnoreCase("ASC");
            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    if ((asc && array[j] < array[minIdx]) || (!asc && array[j] > array[minIdx])) {
                        minIdx = j;
                    }
                }
                int temp = array[minIdx];
                array[minIdx] = array[i];
                array[i] = temp;
            }
        }
    }
