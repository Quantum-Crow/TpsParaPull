import java.util.ArrayList;
import java.util.Scanner;

class Nota {
    private String catedra;
    private double notaExamen;

    public Nota(String catedra, double notaExamen) {
        this.catedra = catedra;
        this.notaExamen = notaExamen;
    }

    public String getCatedra() {
        return catedra;
    }

    public double getNotaExamen() {
        return notaExamen;
    }
}

class Alumno {
    private String nombreCompleto;
    private long legajo;
    private ArrayList<Nota> notas;

    public Alumno(String nombreCompleto, long legajo) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.notas = new ArrayList<>();
    }

    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getNotaExamen();
        }
        return suma / notas.size();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public long getLegajo() {
        return legajo;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }
}

public class CargaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();

        boolean salirAlumno = false;
        while (!salirAlumno) {
            System.out.println("Ingrese datos del alumno");
            System.out.println("Nombre completo:");
            String nombreCompleto = scanner.nextLine();
            System.out.println("Legajo");
            long legajo = scanner.nextLong();
            scanner.nextLine(); // Consumir el salto de línea

            Alumno alumno = new Alumno(nombreCompleto, legajo);

            boolean salirNotas = false;
            while (!salirNotas) {
                System.out.println("Catedra");
                String nombreCatedra = scanner.nextLine();
                System.out.println("Nota");
                double notaExamen = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea

                Nota nota = new Nota(nombreCatedra, notaExamen);
                alumno.agregarNota(nota);

                System.out.println("Salir de la carga de notas? (SI/NO)");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("SI")) {
                    salirNotas = true;
                }
            }

            alumnos.add(alumno);

            System.out.println("Salir de carga de alumnos? (SI/NO)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("SI")) {
                salirAlumno = true;
            }
        }

        for (Alumno alumno : alumnos) {
            System.out.println("Datos Alumno:");
            System.out.println("Nombre Completo: " + alumno.getNombreCompleto());
            System.out.println("Legajo: " + alumno.getLegajo());
            for (Nota nota : alumno.getNotas()) {
                System.out.println("Catedra: " + nota.getCatedra() + ", Nota: " + nota.getNotaExamen());
            }
            System.out.println("El promedio del alumno es: " + alumno.calcularPromedio());
        }

        scanner.close();
    }
}
