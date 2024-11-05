import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculoBonoSueldo {

    // Clase interna Empleado
    public static class Empleado {
        private String nombreEmpleado;
        private long cuil;
        private int anioIngreso;
        private double montoAntiguedad;
        private double sueldoBasico;
        private List<BonoSueldo> bonos;

        // Constructor
        public Empleado(String nombreEmpleado, long cuil, int anioIngreso, double sueldoBasico) {
            this.nombreEmpleado = nombreEmpleado;
            this.cuil = cuil;
            this.anioIngreso = anioIngreso;
            this.sueldoBasico = sueldoBasico;
            this.bonos = new ArrayList<>();
        }

        // Getters y Setters
        public String getNombreEmpleado() {
            return nombreEmpleado;
        }

        public void setNombreEmpleado(String nombreEmpleado) {
            this.nombreEmpleado = nombreEmpleado;
        }

        public long getCuil() {
            return cuil;
        }

        public void setCuil(long cuil) {
            this.cuil = cuil;
        }

        public int getAnioIngreso() {
            return anioIngreso;
        }

        public void setAnioIngreso(int anioIngreso) {
            this.anioIngreso = anioIngreso;
        }

        public double getMontoAntiguedad() {
            return montoAntiguedad;
        }

        public void setMontoAntiguedad(double montoAntiguedad) {
            this.montoAntiguedad = montoAntiguedad;
        }

        public double getSueldoBasico() {
            return sueldoBasico;
        }

        public void setSueldoBasico(double sueldoBasico) {
            this.sueldoBasico = sueldoBasico;
        }

        public List<BonoSueldo> getBonos() {
            return bonos;
        }

        public void setBonos(List<BonoSueldo> bonos) {
            this.bonos = bonos;
        }
    }

    // Clase interna BonoSueldo
    public static class BonoSueldo {
        private Empleado empleado;
        private int mesLiquidacion;
        private int anioLiquidacion;
        private double montoLiquidacion;

        // Constructor
        public BonoSueldo(Empleado empleado, int mesLiquidacion, int anioLiquidacion) {
            this.empleado = empleado;
            this.mesLiquidacion = mesLiquidacion;
            this.anioLiquidacion = anioLiquidacion;
        }

        // Getters y Setters
        public Empleado getEmpleado() {
            return empleado;
        }

        public void setEmpleado(Empleado empleado) {
            this.empleado = empleado;
        }

        public int getMesLiquidacion() {
            return mesLiquidacion;
        }

        public void setMesLiquidacion(int mesLiquidacion) {
            this.mesLiquidacion = mesLiquidacion;
        }

        public int getAnioLiquidacion() {
            return anioLiquidacion;
        }

        public void setAnioLiquidacion(int anioLiquidacion) {
            this.anioLiquidacion = anioLiquidacion;
        }

        public double getMontoLiquidacion() {
            return montoLiquidacion;
        }

        public void setMontoLiquidacion(double montoLiquidacion) {
            this.montoLiquidacion = montoLiquidacion;
        }
    }

    private static final String[][] haberes = {
            {"100", "Presentismo", "9"},
            {"101", "Titulo Profesional", "9"},
            {"102", "Horas Extraordinarias", "M"},
            {"103", "Horas Nocturnas", "M"},
            {"104", "Otros Haberes", "M"}
    };

    private static final String[][] deducciones = {
            {"200", "Obra Social", "3"},
            {"201", "Jubilacion", "11"},
            {"202", "Sindicato", "2"},
            {"203", "Seguro", "1.5"},
            {"204", "Otros", "M"}
    };

    private List<Integer> codigosIngresados;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculoBonoSueldo calculoBonoSueldo = new CalculoBonoSueldo();
        calculoBonoSueldo.codigosIngresados = new ArrayList<>();

        // a) Crear una instancia de la clase Empleado
        System.out.println("Ingrese el nombre completo del empleado:");
        String nombreEmpleado = scanner.nextLine();

        System.out.println("Ingrese el CUIL del empleado:");
        long cuil = scanner.nextLong();

        System.out.println("Ingrese el año de ingreso del empleado:");
        int anioIngreso = scanner.nextInt();

        System.out.println("Ingrese el mes de liquidación:");
        int mesLiquidacion = scanner.nextInt();

        System.out.println("Ingrese el año de liquidación:");
        int anioLiquidacion = scanner.nextInt();

        System.out.println("Ingrese el sueldo básico del empleado:");
        double sueldoBasico = scanner.nextDouble();

        Empleado empleado = new Empleado(nombreEmpleado, cuil, anioIngreso, sueldoBasico);

        // b) Validar que el año de ingreso y liquidación no superen el año actual
        int añoActual = java.time.Year.now().getValue();
        if (anioIngreso > añoActual || anioLiquidacion > añoActual) {
            System.out.println("El año de ingreso o liquidación no puede superar el año actual.");
            return;
        }

        // c) Calcular el monto de antigüedad
        int añosAntiguedad = añoActual - anioIngreso;
        double montoAntiguedad = sueldoBasico * 0.02 * añosAntiguedad;
        empleado.setMontoAntiguedad(montoAntiguedad);

        // d) Crear una instancia de la clase BonoSueldo
        BonoSueldo bonoSueldo = new BonoSueldo(empleado, mesLiquidacion, anioLiquidacion);

        // e) Crear la matriz bonoCalculado
        String[][] bonoCalculado = new String[10][4];

        // f) Solicitar los haberes a computar
        System.out.println("Ingrese los Haberes del Empleado");
        boolean haberIngresado = false;
        while (true) {
            System.out.println("Ingrese el código del ítem (000 para finalizar):");
            String codigoHaber = scanner.next();

            if (codigoHaber.equals("000")) {
                if (!haberIngresado) {
                    System.out.println("Debe ingresar al menos 1 haber");
                    continue;
                }
                break;
            }

            if (calculoBonoSueldo.codigosIngresados.contains(Integer.parseInt(codigoHaber))) {
                System.out.println("El código ya ha sido cargado. Ingrese otro código.");
                continue;
            }

            boolean codigoEncontrado = false;
            for (String[] haber : haberes) {
                if (haber[0].equals(codigoHaber)) {
                    codigoEncontrado = true;
                    String denominacion = haber[1];
                    String porcentaje = haber[2];

                    double montoHaber;
                    if (porcentaje.equals("M")) {
                        System.out.println("Ingrese el monto del haber:");
                        montoHaber = scanner.nextDouble();
                    } else {
                        montoHaber = sueldoBasico * Double.parseDouble(porcentaje) / 100;
                    }

                    // Asignar en la matriz bonoCalculado
                    for (int i = 0; i < bonoCalculado.length; i++) {
                        if (bonoCalculado[i][0] == null) {
                            bonoCalculado[i][0] = codigoHaber;
                            bonoCalculado[i][1] = denominacion;
                            bonoCalculado[i][2] = String.valueOf(montoHaber);
                            bonoCalculado[i][3] = "0"; // Deducción inicial en 0
                            haberIngresado = true;
                            calculoBonoSueldo.codigosIngresados.add(Integer.parseInt(codigoHaber));
                            break;
                        }
                    }
                }
            }

            if (!codigoEncontrado) {
                System.out.println("El código ingresado es incorrecto");
            }
        }

        // Solicitar las deducciones a computar
        System.out.println("Ingrese las deducciones del empleado");
        boolean deduccionIngresada = false;
        while (true) {
            System.out.println("Ingrese el código del ítem (000 para finalizar):");
            String codigoDeduccion = scanner.next();

            if (codigoDeduccion.equals("000")) {
                if (!deduccionIngresada) {
                    System.out.println("Debe ingresar al menos 1 deducción");
                    continue;
                }
                break;
            }

            if (calculoBonoSueldo.codigosIngresados.contains(Integer.parseInt(codigoDeduccion))) {
                System.out.println("El código ya ha sido cargado. Ingrese otro código.");
                continue;
            }

            boolean codigoEncontrado = false;
            for (String[] deduccion : deducciones) {
                if (deduccion[0].equals(codigoDeduccion)) {
                    codigoEncontrado = true;
                    String denominacion = deduccion[1];
                    String porcentaje = deduccion[2];

                    double montoDeduccion;
                    if (porcentaje.equals("M")) {
                        System.out.println("Ingrese el monto de la deducción:");
                        montoDeduccion = scanner.nextDouble();
                    } else {
                        montoDeduccion = sueldoBasico * Double.parseDouble(porcentaje) / 100;
                    }

                    // Asignar en la matriz bonoCalculado
                    for (int i = 0; i < bonoCalculado.length; i++) {
                        if (bonoCalculado[i][0] == null) {
                            bonoCalculado[i][0] = codigoDeduccion;
                            bonoCalculado[i][1] = denominacion;
                            bonoCalculado[i][2] = "0"; // Haber inicial en 0
                            bonoCalculado[i][3] = String.valueOf(montoDeduccion);
                            deduccionIngresada = true;
                            calculoBonoSueldo.codigosIngresados.add(Integer.parseInt(codigoDeduccion));
                            break;
                        }
                    }
                }
            }

            if (!codigoEncontrado) {
                System.out.println("El código ingresado es incorrecto");
            }
        }

        // Calcular el monto a liquidar al empleado
        double sumaHaberes = 0;
        double sumaDeducciones = 0;
        for (String[] fila : bonoCalculado) {
            if (fila[0] != null) {
                sumaHaberes += Double.parseDouble(fila[2]);
                sumaDeducciones += Double.parseDouble(fila[3]);
            }
        }

        double montoLiquidacion = sueldoBasico + montoAntiguedad + sumaHaberes - sumaDeducciones;
        bonoSueldo.setMontoLiquidacion(montoLiquidacion);
        empleado.getBonos().add(bonoSueldo);

        // Preguntar si desea generar un nuevo bono de sueldo
        System.out.println("¿Desea generar un nuevo bono de sueldo? (S/N)");
        String respuesta = scanner.next();
        if (respuesta.equalsIgnoreCase("S")) {
            main(args); // Repetir el proceso
        } else {
            // Mostrar los bonos cargados
            for (BonoSueldo bono : empleado.getBonos()) {
                System.out.println("El bono de sueldo a Liquidar es:");
                System.out.println("Nombre: " + empleado.getNombreEmpleado());
                System.out.println("CUIL: " + empleado.getCuil());
                System.out.println("Mes Liquidación: " + bono.getMesLiquidacion() + " Año Liquidación: " + bono.getAnioLiquidacion());
                System.out.println("Sueldo Básico: " + empleado.getSueldoBasico() + " Año Ingreso: " + empleado.getAnioIngreso());
                System.out.println("Código Ítem Denominación Haberes Deducciones");
                System.out.println("Sueldo Básico: " + empleado.getSueldoBasico());
                System.out.println("Antigüedad: " + empleado.getMontoAntiguedad());
                for (String[] fila : bonoCalculado) {
                    if (fila[0] != null) {
                        System.out.println(fila[0] + " " + fila[1] + " " + fila[2] + " " + fila[3]);
                    }
                }
                System.out.println("SUB TOTAL: " + (sueldoBasico + montoAntiguedad + sumaHaberes) + " " + sumaDeducciones);
                System.out.println("NETO: " + bono.getMontoLiquidacion());
            }
        }
    }
}
