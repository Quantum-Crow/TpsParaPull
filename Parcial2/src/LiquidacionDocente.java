import java.util.ArrayList;
import java.util.Scanner;

class Catedra {
    private int codigo;
    private String denominacion;
    private int horasCatedra;

    public Catedra(int codigo, String denominacion, int horasCatedra) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.horasCatedra = horasCatedra;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getHorasCatedra() {
        return horasCatedra;
    }
}

class Docente {
    private String nombreCompleto;
    private int legajo;
    private double antiguedad;
    private Catedra catedra;

    public Docente(String nombreCompleto, int legajo, double antiguedad, Catedra catedra) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.antiguedad = antiguedad;
        this.catedra = catedra;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getLegajo() {
        return legajo;
    }

    public double getAntiguedad() {
        return antiguedad;
    }

    public Catedra getCatedra() {
        return catedra;
    }

    public double salarioDocenteCalculado(double valorHoraCatedraBase) {
        int horasCatedra = catedra.getHorasCatedra();
        double salarioBase = valorHoraCatedraBase * horasCatedra;
        double aumentoPorAntiguedad = (salarioBase * antiguedad) / 100;
        return salarioBase + aumentoPorAntiguedad;
    }
}

class Universidad {
    private String cuit;
    private String razonSocial;
    private double valorHoraCatedraBase;
    private ArrayList<Docente> docentes;

    public Universidad(String cuit, String razonSocial, double valorHoraCatedraBase) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.valorHoraCatedraBase = valorHoraCatedraBase;
        this.docentes = new ArrayList<>();
    }

    public String getCuit() {
        return cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public double getValorHoraCatedraBase() {
        return valorHoraCatedraBase;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public void agregarDocente(Docente docente) {
        docentes.add(docente);
    }
}

public class LiquidacionDocente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Catedra> catedrasCarrera = new ArrayList<>();
        catedrasCarrera.add(new Catedra(10, "Analisis Matematico", 8));
        catedrasCarrera.add(new Catedra(20, "Algoritmos", 4));
        catedrasCarrera.add(new Catedra(30, "Paradigmas de la Computación", 6));
        catedrasCarrera.add(new Catedra(40, "Inteligencia Artificial", 12));

        String cuit;
        do {
            System.out.print("Ingrese el CUIT de la universidad (11 dígitos): ");
            cuit = scanner.nextLine();
        } while (cuit.length() != 11);

        String razonSocial;
        do {
            System.out.print("Ingrese la razón social de la universidad: ");
            razonSocial = scanner.nextLine();
        } while (razonSocial.isEmpty());

        double valorHoraCatedraBase;
        do {
            System.out.print("Ingrese el valor base por hora cátedra: ");
            valorHoraCatedraBase = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea
        } while (valorHoraCatedraBase <= 0);

        Universidad universidad = new Universidad(cuit, razonSocial, valorHoraCatedraBase);

        String continuar;
        do {
            String nombreCompleto;
            do {
                System.out.print("Ingrese el nombre completo del docente: ");
                nombreCompleto = scanner.nextLine();
            } while (nombreCompleto.isEmpty());

            int legajo;
            boolean legajoExistente;
            do {
                legajoExistente = false;
                System.out.print("Ingrese el legajo del docente: ");
                legajo = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                for (Docente docente : universidad.getDocentes()) {
                    if (docente.getLegajo() == legajo) {
                        legajoExistente = true;
                        System.out.println("El legajo ingresado ya fue cargado anteriormente.");
                        break;
                    }
                }
            } while (legajoExistente);

            double antiguedad;
            do {
                System.out.print("Ingrese la antigüedad del docente (en años): ");
                antiguedad = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea
            } while (antiguedad < 0 || antiguedad >= 120);

            Catedra catedra = null;
            int codigoCatedra;
            do {
                System.out.print("Ingrese el código de la cátedra: ");
                codigoCatedra = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                for (Catedra cat : catedrasCarrera) {
                    if (cat.getCodigo() == codigoCatedra) {
                        catedra = cat;
                        break;
                    }
                }

                if (catedra == null) {
                    System.out.println("El código ingresado no existe, intente nuevamente.");
                }
            } while (catedra == null);

            Docente docente = new Docente(nombreCompleto, legajo, antiguedad, catedra);
            universidad.agregarDocente(docente);

            System.out.print("¿Desea continuar cargando docentes? (si/no): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("si"));

        System.out.println("Universidad: " + universidad.getRazonSocial());
        System.out.println("CUIT: " + universidad.getCuit());
        System.out.println("Valor Base Hora Cátedra: " + universidad.getValorHoraCatedraBase());
        System.out.println("------------------------Docentes------------------------------");

        for (Docente docente : universidad.getDocentes()) {
            System.out.println("Nombre Completo: " + docente.getNombreCompleto());
            System.out.println("Catedra: " + docente.getCatedra().getDenominacion());
            System.out.println("Salario: $" + docente.salarioDocenteCalculado(universidad.getValorHoraCatedraBase()));
            System.out.println("---------------------------------------------------------------------");
        }

        scanner.close();
    }
}
