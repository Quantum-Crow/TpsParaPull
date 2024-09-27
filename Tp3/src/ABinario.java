import java.math.BigDecimal;
import java.util.Scanner;
public class ABinario {
    public static void main(String[] args) {
        boolean validar = false;
        int contador = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a este traductor de mierda");

       while (validar==false) {
           System.out.println("Queres ingresar?(s/n)");
           String opcion = scanner.nextLine();
           opcion = opcion.toLowerCase();

           if (opcion.equals("s")) {
               System.out.println("Ingresa el texto:");
               String texto = scanner.nextLine();
               String binario = ABinario(texto);
               System.out.println("Binario: " + binario);
               contador++;

           }else
               if (opcion.equals("n")) {
                   System.out.println("Gato");
                   validar = true;
               }
       }
    }
    public static String ABinario(String texto) {
        StringBuilder binario = new StringBuilder();
        for (char caracter : texto.toCharArray()) {
            binario.append(Integer.toBinaryString(caracter)).append(" ");
        }
        return binario.toString();
    }
}
