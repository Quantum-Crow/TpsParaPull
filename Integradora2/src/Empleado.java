import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Empleado {

    Validaciones v = new Validaciones();
    LocalDate fechaActual = LocalDate.now();
    private final int anioActual=fechaActual.getYear();
    private String nombreEmpleado;
    private long cuil;
    private int anioIngreso;
    private double montoAntiguedad=2*(anioActual-anioIngreso);
    private double salarioBasico;
    private List<BonoSueldo> bonos;

    public List<BonoSueldo> getBonos() {
        return bonos;
    }

    public void setBonos(List<BonoSueldo> bonos) {
        this.bonos = bonos;
    }

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

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public void crearEmpleado(){
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        System.out.println("ingrese nombre completo del empleado");
        this.nombreEmpleado = sc.nextLine();

        System.out.println("ingrese cuil del empleado");
        this.cuil = Long.parseLong(sc.next());

        do {
            System.out.println("ingrese año en el que ingreso el empleado");
            this.anioIngreso = Integer.parseInt(sc.next());
            v.validar(anioIngreso);
        }while (!v.validar(anioIngreso));

        System.out.println("ingrese sueldo basico del empleado");
        this.salarioBasico = Double.parseDouble(sc.next());

    }

    public void agregarBono(BonoSueldo bono){
        if (this.bonos==null){
            this.bonos = new ArrayList<>();
            bonos.add(bono);
        }else {
            bonos.add(bono);
        }
    }
}