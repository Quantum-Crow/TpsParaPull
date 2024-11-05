import java.util.HashSet;
import java.util.Scanner;

class ComponenteCPU {
    private String componente;
    private String marca;
    private int cantidad;
    private double precio;

    public ComponenteCPU(String componente, String marca, int cantidad, double precio) {
        this.componente = componente;
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getComponente() {
        return componente;
    }

    public String getMarca() {
        return marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getSubTotal() {
        return cantidad * precio;
    }
}

class Computadora {
    private String marca;
    private String modelo;
    private HashSet<ComponenteCPU> componentes;

    public Computadora(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.componentes = new HashSet<>();
    }

    public void agregarComponente(ComponenteCPU componente) {
        this.componentes.add(componente);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public HashSet<ComponenteCPU> getComponentes() {
        return componentes;
    }

    public double calcularCostoTotal() {
        double costoTotal = 0;
        for (ComponenteCPU componente : componentes) {
            costoTotal += componente.getSubTotal();
        }
        return costoTotal;
    }

    public double calcularPrecioSugerido() {
        double costoTotal = calcularCostoTotal();
        if (costoTotal < 50000) {
            return costoTotal + (costoTotal * 0.40);
        } else {
            return costoTotal + (costoTotal * 0.30);
        }
    }
}

public class CostoComputadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese la marca de la computadora: ");
            String marca = scanner.nextLine();

            System.out.print("Ingrese el modelo de la computadora: ");
            String modelo = scanner.nextLine();

            Computadora computadora = new Computadora(marca, modelo);

            while (true) {
                System.out.print("Ingrese el nombre del componente (o 'fin' para terminar): ");
                String nombreComponente = scanner.nextLine();

                if (nombreComponente.equalsIgnoreCase("fin")) {
                    break;
                }

                System.out.print("Ingrese la marca del componente: ");
                String marcaComponente = scanner.nextLine();

                System.out.print("Ingrese la cantidad del componente: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                System.out.print("Ingrese el precio del componente: ");
                double precio = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea

                ComponenteCPU componente = new ComponenteCPU(nombreComponente, marcaComponente, cantidad, precio);
                computadora.agregarComponente(componente);
            }

            System.out.println("-----------Computadora----------------");
            System.out.println("Marca: " + computadora.getMarca());
            System.out.println("Modelo: " + computadora.getModelo());
            System.out.println("Componentes:");
            System.out.println("Componente\tMarca\tCantidad\tPrecio X Unidad\tSubTotal");
            for (ComponenteCPU componente : computadora.getComponentes()) {
                System.out.println(componente.getComponente() + "\t" + componente.getMarca() + "\t" + componente.getCantidad() + "\t" + componente.getPrecio() + "\t" + componente.getSubTotal());
            }
            double costoTotal = computadora.calcularCostoTotal();
            double precioSugerido = computadora.calcularPrecioSugerido();
            System.out.println("Costo Total: " + costoTotal);
            System.out.println("El precio sugerido de venta es: " + costoTotal + " + " + (precioSugerido - costoTotal) + " = " + precioSugerido);

            System.out.print("¿Desea cotizar una nueva computadora? (SI/NO): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("NO")) {
                break;
            }
        }

        scanner.close();
    }
}
