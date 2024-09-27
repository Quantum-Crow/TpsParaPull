import java.util.ArrayList;

public class Ejercicio9 {
    public static void main(String[] args) {
        ArrayList divisiblePor2 = new ArrayList();
        ArrayList divisiblePor3 = new ArrayList();

        for (int i =1; i<=100; i++ ){
            if (i % 2 == 0) {
                divisiblePor2.add(i);
            }
            else if (i % 3 == 0){
                divisiblePor3.add(i);
            }
        }
        System.out.println("Del 1 al 100:");
        System.out.println("Los divisibles por 2 son: "+divisiblePor2);
        System.out.println("Y los divisibles por 3 son: "+divisiblePor3);
    }
}
