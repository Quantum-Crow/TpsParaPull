import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AgendaTelefonica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Long> agenda = new HashMap<>();

        while (true) {
            System.out.println("Menú de la Agenda Telefónica:");
            System.out.println("1- Cargar Datos en la Agenda");
            System.out.println("2- Buscar Teléfono por Nombre");
            System.out.println("3- Listar Agenda");
            System.out.println("4- Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    cargarDatos(scanner, agenda);
                    break;
                case 2:
                    buscarTelefono(scanner, agenda);
                    break;
                case 3:
                    listarAgenda(agenda);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void cargarDatos(Scanner scanner, HashMap<String, Long> agenda) {
        while (true) {
            System.out.print("Ingrese el nombre completo de la persona (o 'fin' para terminar): ");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            if (agenda.containsKey(nombre)) {
                System.out.println("La persona ya existe en la agenda.");
            } else {
                System.out.print("Ingrese el teléfono de la persona: ");
                long telefono = scanner.nextLong();
                scanner.nextLine(); // Consumir el salto de línea
                agenda.put(nombre, telefono);
                System.out.println("Persona agregada a la agenda.");
            }
        }
    }

    private static void buscarTelefono(Scanner scanner, HashMap<String, Long> agenda) {
        System.out.print("Ingrese el nombre de la persona a buscar: ");
        String nombre = scanner.nextLine();

        if (agenda.containsKey(nombre)) {
            System.out.println("El teléfono de " + nombre + " es: " + agenda.get(nombre));
        } else {
            System.out.println("La persona buscada no se encuentra en la agenda.");
        }
    }

    private static void listarAgenda(HashMap<String, Long> agenda) {
        System.out.println("Listado de la Agenda:");
        for (Map.Entry<String, Long> entry : agenda.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + ", Teléfono: " + entry.getValue());
        }
    }
}
