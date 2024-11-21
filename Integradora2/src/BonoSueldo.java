public class BonoSueldo {
    private Empleado empleado;
    private int mesLiquidacion;
    private int anioLiquidacion;
    private double montoLiquidacion;
    private String[][] haberes;
    private String[][] deducciones;
    private double sumaHaberes;
    private double sumaDeducciones;

    public double getSumaHaberes() {
        return sumaHaberes;
    }

    public void setSumaHaberes(double sumaHaberes) {
        this.sumaHaberes = sumaHaberes;
    }

    public double getSumaDeducciones() {
        return sumaDeducciones;
    }

    public void setSumaDeducciones(double sumaDeducciones) {
        this.sumaDeducciones = sumaDeducciones;
    }

    public String[][] getHaberes() {
        return haberes;
    }

    public void setHaberes(String[][] haberes) {
        this.haberes = haberes;
    }

    public String[][] getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(String[][] deducciones) {
        this.deducciones = deducciones;
    }

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

    public void mostrarBonoSueldo() {
        String[][] bonoEncabezado = {{"NOMBRE", this.empleado.getNombreEmpleado(), "", ""},
                {"CUIL", String.valueOf(this.empleado.getCuil()), "", ""},
                {"MES LIQUIDACION", String.valueOf(this.mesLiquidacion), "AÑO LIQUIDACION", String.valueOf(this.anioLiquidacion)},
                {"SUELDO BASICO", String.valueOf(this.empleado.getSalarioBasico()), "AÑO INGRESO", String.valueOf(this.empleado.getAnioIngreso())},
                {"ITEM","DESCRIPCION","HABERES","DEDUCCIONES"}
        };

        System.out.println("\n***************************************** BONO *****************************************");

        for (String[] fila : bonoEncabezado) {
            System.out.printf("%-15s %-40s %-15s %-15s%n", fila[0], fila[1], fila[2], fila[3]);
        }
        Validaciones val = new Validaciones();
        val.validarNull(haberes);
        val.validarNull(deducciones);

        for (String[] fila : haberes) {
            if (!fila[0].equals("XXXXXXX")) {
                System.out.printf("%-15s %-40s %-15s %-15s%n", fila[0], fila[1], fila[2], fila[3]);
            }
        }
        for (String[] fila : deducciones) {
            if (!fila[0].equals("XXXXXXX")) {
                System.out.printf("%-15s %-40s %-15s %-15s%n", fila[0], fila[1], fila[2], fila[3]);
            }
        }
        System.out.printf("%-15s %-40s %-15s %-15s%n", "", "SUB TOTAL", sumaHaberes, sumaDeducciones);
        System.out.printf("%-15s %-40s %-15s %-15s%n", "", "", "TOTAL", this.montoLiquidacion);

        System.out.println("****************************************************************************************");
    }
}