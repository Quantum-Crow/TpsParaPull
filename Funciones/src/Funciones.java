import java.util.Random;
import java.util.Scanner;

public class Funciones {

    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    /*         ****** IMPORTANTE ******

    Recuerden mejor 7 veces con blanca nieves y no una con cada enano
            Siempre calidad antes que cantidad
            #ConsejosQueNadiePidio
            #SiMePagarPorHablarBoludeces */


    //// Funciones para Arrays
    public void rellenarArrayRandom(int[] array,int rango) {

        for (int i = 0; i < array.length; i++) {
            int num = rd.nextInt(rango) + 1;
            array[i] = num;

        }
    }

    public void rellenarArrayRandom(double[] array,int rango) {

        for (int i = 0; i < array.length; i++) {
            int num = rd.nextInt(rango) + 1;
            array[i] = num;

        }
    }

    public void rellenarArrayPorConsola(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.println("ingrese el elemento");
            array[i] = sc.nextInt();
        }
    }

    public void rellenarArrayPorConsola(double[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.println("ingrese un elemento");
            array[i] = sc.nextDouble();
        }
    }

    public void mostrarArray(int[] array) {

        for (int i : array) System.out.print(i + " ; ");

    }

    public void mostrarArray(double[] array) {

        for (double i : array) System.out.print(i + " ; ");

    }

    public void mostrarArray(String[] array) {

        for (String i : array) System.out.print(i + " ; ");

    }

    public double determinarMeyorInArray(double[] array) {

        double numeroMayor = 0;
        for (double j : array) {
            if (j > numeroMayor) numeroMayor = j;
        }
        return numeroMayor;

    }

    public double determinarMenorInArray(double[] array) {

        double numeroMenor = array[0];
        for (double j : array) {
            if (j < numeroMenor) numeroMenor = j;
        }
        return numeroMenor;

    }

    public void ordenarArregloMenorMayor(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public void ordenarArregloMayorMenor(int[] array) {
        int l = array.length;
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    ////// funciones para matrices

    public void mostrarMatriz(String[][] array){

        for (String[] strings : array) {
            System.out.println("");
            for (String string : strings) {
                System.out.print(string + " ");
            }
        }
    }

    public void mostrarMatriz(int[][] array){

        for(int i = 0; i < array.length; i++){
            System.out.println("");
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
        }
    }

    public void mostrarMatriz(double[][] array){

        for(int i = 0; i < array.length; i++){
            System.out.print(" ");
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
        }
    }

    public void rellenarColumna(String[][] array, int columna){

        int numeroFilas=array.length;

        for(int i = 0; i < array.length; i++){

            System.out.print("ingrese un valor");
            array[i][columna] = sc.nextLine();

        }

    }

    public void rellenarFila(String[][] array, int fila){

        int numColumnas=array[0].length;

        for(int i = 0; i < numColumnas; i++){
            System.out.print("ingrese un valor");
            array[fila][i]= sc.nextLine();
        }
    }

    public int[][] crearYrellenarrMatrizPorConsola(int x, int y){

        System.out.println("Ahora procederemos a rellenarla, ingresa los valores q deseas guardar en la matriz");
        int [][] matriz = new int[x][y];

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                matriz[i][j] = sc.nextInt();
            }
        }

        return matriz;
    }


    public double calcularPromedioDeMatriz(int[][] matriz){
        int suma = 0;
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                suma = suma + matriz[i][j];
            }
        }
        return (double) suma /(matriz.length*matriz[0].length);
    }


}