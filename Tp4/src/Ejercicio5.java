import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] golosinas = {
                {"KitKat", "32", "10"},
                {"Chicles", "2", "0"},
                {"Caramelos de Menta", "2", "50"},
                {"Huevo Kinder", "25", "10"},
                {"Chetoos", "30", "10"},
                {"Twix", "26", "10"},
                {"M&M'S", "35", "10"},
                {"Papas Lays", "40", "20"},
                {"Milkybar", "30", "10"},
                {"Alfajor Tofi", "20", "15"},
                {"Lata Coca", "50", "20"},
                {"Chitos", "45", "10"}
        };
        int ventas = 0;

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Pedir golosina");
            System.out.println("2. Mostrar golosinas");
            System.out.println("3. Rellenar golosinas");
            System.out.println("4. Apagar máquina");
            System.out.println("----------------------");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1": {
                    System.out.println("Seleccione una opción: ");
                    System.out.println("Opcion - Precio - Cantidad ");
                    for (int i = 0; i < golosinas.length; i++) {
                        System.out.print((i+1) +". ");
                        for (int j = 0; j < golosinas[i].length; j++) {

                            System.out.print( golosinas[i][j] + " ");

                        }
                        System.out.println();
                    }
                    int posicion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    if (posicion < 1 || posicion > golosinas.length) {
                        System.out.println("Posición no válida.");
                        return;
                    }

                    int stock = Integer.parseInt(golosinas[posicion - 1][2]);
                    if (stock > 0) {
                        stock--;
                        golosinas[posicion - 1][2] = String.valueOf(stock);
                        int precio = Integer.parseInt(golosinas[posicion - 1][1]);
                        ventas += precio;
                        System.out.println("Golosina entregada: " + golosinas[posicion - 1][0]);
                    } else {
                        System.out.println("La golosina seleccionada está agotada. Por favor, seleccione otra.");
                    }
                    break;
                }
                case "2":{
                    System.out.println("Golosinas disponibles:");
                    for (int i = 0; i < golosinas.length; i++) {
                        System.out.println((i + 1) + ". " + golosinas[i][0] + " - Precio: " + golosinas[i][1] + " - Stock: " + golosinas[i][2]);
                    }
                }
                break;
                case "3":{
                    System.out.print("Ingrese la contraseña: ");
                    String contraseña = scanner.nextLine();
                    if (!contraseña.equals("AdminXYZ")) {
                        System.out.println("Contraseña incorrecta.");
                        return;
                    }
                    System.out.print("Ingrese la posición de la golosina (1-" + golosinas.length + "): ");
                    int posicion = scanner.nextInt();
                    scanner.nextLine();
                    if (posicion < 1 || posicion > golosinas.length) {
                        System.out.println("Posición no válida.");
                        return;
                    }
                    System.out.print("Ingrese la cantidad a recargar: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    int stockActual = Integer.parseInt(golosinas[posicion - 1][2]);
                    stockActual += cantidad;
                    golosinas[posicion - 1][2] = String.valueOf(stockActual);
                    System.out.println("Golosina recargada: " + golosinas[posicion - 1][0]);
                }

                break;
                case "4": {
                    System.out.println("Precio de ventas totales: $" + ventas);
                    System.out.println("Apagando máquina...");
                    return;
                }
                default: {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }
    }
}