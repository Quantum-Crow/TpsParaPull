import java.util.Scanner;

public class Computadora {
    private String marca;
    private String modelo;
    private long codigoBarras;
    private double precioTotal;
    private double porsentajeAlumnos;
    private double montoFinal;
    private String[][] componentes;

    public Computadora() {
        this.marca = marca;
        this.modelo = modelo;
        this.codigoBarras = codigoBarras;
        this.precioTotal = precioTotal;
        this.porsentajeAlumnos = porsentajeAlumnos;
        this.montoFinal = montoFinal;
        this.componentes = componentes;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public long getCodigoBarras() {
        return codigoBarras;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
    public double getPorsentajeAlumnos() {
        return porsentajeAlumnos;
    }

    public double getMontoFinal() {
        return montoFinal;
    }
    public String[][] getComponentes() {
        return componentes;
    }

    public String[][] asigComponentes(int cant){

        String[][] componentes = new String[cant][cant];
        return componentes;
    }
}

class GeneraPC {
    public static void main(String[] args) {
        String[][] componentesPc = {{"AAA", "Placa Madre", "20000", "S"},
                {"BBB", "Procesador", "25000", "S"},
                {"CCC", "Memoria RAM", "5000", "S"},
                {"DDD", "Placa de Red", "3000", "N"},
                {"EEE", "Disco Rigido SSD", "22000", "S"},
                {"FFF", " Placa de Video", "42000", "N"},
                {"GGG", "Monitor Led 21", "32000", "N"},
                {"HHH", "Monitor Led 25", "41000", "N"},
                {"JJJ", "Kit Teclado - Mouse", "9000", "N"},
                {"KKK", "Gabinete", "6500", "S"},
                {"LLL", "Fuente  Alimentación", "6500", "S"},
                {"MMM", "Placa de Sonido", "16500", "N"}};

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("vamos a armar una computadora");
            System.out.println("ingrese los componentes:");
            System.out.println("----------------");
            System.out.println("ingrese la marca: ");
            String marca = sc.nextLine();
            System.out.println("ingrese el modelo: ");
            String modelo = sc.nextLine();
            System.out.println("ingrese el codigo de barraas: ");
            long codigoBarras = sc.nextInt();
            validacionCodigo(codigoBarras);
            while (true) {
                System.out.println("");
                System.out.println("-------------");
                System.out.println("Que cantidad de componentes quiere llevar?");
                int cant = sc.nextInt();
                Computadora computadora = new Computadora();
                String[][] comp = computadora.asigComponentes(cant);
                validacionCantComp(cant);
                System.out.println("ingrese los componentes");
                String comps = sc.nextLine();
                System.out.println("ingrese los codigos de los componentes");
                int codigosC = sc.nextInt();
                for (int i = 0; i < componentesPc.length; i++) {
                    System.out.println((i + 1));
                }
            }
        }
    }

    public static void validacionCodigo(long codigoBarras) {
        if (codigoBarras < 7 || codigoBarras >= 15) {
            System.out.println("ERROR; el codigo de barras tiene que tener entre 7 y 15 caracteres maximos, ingreselo nuevamente");
//            compraPC();
        } else {
            System.out.println("Codigo de barras correcto");
            System.out.println("Gracias por comprar");
        }
    }

    public static void validacionCantComp(int cant) {
        if (cant >= 5 || cant <= 12) {
            System.out.println("Gracias por comprar");
        } else {
            System.out.println("ERROR:cantidad de componentes invalida");
            System.out.println("vuelva a ingresar la cantidad");
        }
    }
}