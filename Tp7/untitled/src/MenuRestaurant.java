import java.util.ArrayList;
import java.util.Scanner;

class Ingrediente {
    private String nombre;
    private double cantidad;
    private String unidadDeMedida;

    public Ingrediente(String nombre, double cantidad, String unidadDeMedida) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }
}

class Plato {
    private String nombreCompleto;
    private double precio;
    private boolean esBebida;
    private ArrayList<Ingrediente> ingredientes;

    public Plato(String nombreCompleto, double precio, boolean esBebida) {
        this.nombreCompleto = nombreCompleto;
        this.precio = precio;
        this.esBebida = esBebida;
        this.ingredientes = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEsBebida() {
        return esBebida;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }
}

public class MenuRestaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Plato> platosMenu = new ArrayList<>();

        while (true) {
            System.out.print("Ingrese el nombre del plato (o 'fin' para terminar): ");
            String nombreCompleto = scanner.nextLine();

            if (nombreCompleto.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.print("Ingrese el precio del plato: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea

            System.out.print("¿Es una bebida? (si/no): ");
            boolean esBebida = scanner.nextLine().equalsIgnoreCase("si");

            Plato plato = new Plato(nombreCompleto, precio, esBebida);

            if (!esBebida) {
                while (true) {
                    System.out.print("Ingrese el nombre del ingrediente (o 'fin' para terminar): ");
                    String nombreIngrediente = scanner.nextLine();

                    if (nombreIngrediente.equalsIgnoreCase("fin")) {
                        break;
                    }

                    System.out.print("Ingrese la cantidad del ingrediente: ");
                    double cantidad = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("Ingrese la unidad de medida del ingrediente: ");
                    String unidadDeMedida = scanner.nextLine();

                    Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidad, unidadDeMedida);
                    plato.agregarIngrediente(ingrediente);
                }
            }

            platosMenu.add(plato);
        }

        System.out.println("-----------MENÚ----------------");
        for (Plato plato : platosMenu) {
            System.out.println(plato.getNombreCompleto());
            System.out.println("Precio: $ " + plato.getPrecio());

            if (!plato.isEsBebida()) {
                System.out.println("Ingredientes:");
                System.out.println("Nombre\tCantidad\tUnidad de Medida");
                for (Ingrediente ingrediente : plato.getIngredientes()) {
                    System.out.println(ingrediente.getNombre() + "\t" + ingrediente.getCantidad() + "\t" + ingrediente.getUnidadDeMedida());
                }
            }

            System.out.println("----------------------------------");
        }

        scanner.close();
    }
}
