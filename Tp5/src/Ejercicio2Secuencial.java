public class Ejercicio2Secuencial {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int key = 30;
        int result = sequentialSearch(array, key);
        if (result != -1) {
            System.out.println("Elemento encontrado en el índice: " + result);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
    public static int sequentialSearch(int[] array, int key) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == key) {
                    return i; // Elemento encontrado, devuelve el índice
                }
            }return -1; // Elemento no encontrado
    }
}

