import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            System.out.println("Ingrese un numero del 1 al 7: ");
            int dia = sc.nextInt();

            while (dia < 1 || dia > 7) {
                System.out.println("El dia no es valido, ingrese un numero nuevo");
                dia = sc.nextInt();

            }
                switch (dia) {
                    case 1:
                        System.out.println("El dia 1 es lunes, un dia laboral");
                        break;
                    case 2:
                        System.out.println("El dia 2 es martes, un dia laboral");
                        break;
                    case 3:
                        System.out.println("El dia 3 es miercoles, un dia laboral");
                        break;
                    case 4:
                        System.out.println("El dia 4 es jueves, un dia laboral");
                        break;
                    case 5:
                        System.out.println("El dia 5 es viernes, un dia laboral");
                        break;
                    case 6:
                        System.out.println("El dia 6 es sabado, un dia no laboral");
                        break;
                    case 7:
                        System.out.println("El dia 7 es domingo, un dia no laboral");
                    default:
                        System.out.println("El numero ingresado no pertenece a uno de los dias asignado");
                }

    }
}
