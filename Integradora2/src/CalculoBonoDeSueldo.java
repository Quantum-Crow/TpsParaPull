import java.time.LocalDate;
import java.util.*;

public class CalculoBonoDeSueldo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LocalDate fechaActual = LocalDate.now();
        Validaciones val = new Validaciones();
        int mesFact = 0;
        int anioFact = 0;
        double sumaHaberes=0;
        double sumaDeducciones=0;
        String item = "";


        String[][] haberes = {{"100", "Presentismo", "9"}, {"101", "Titulo Profesional", "9"},
                {"102", "Horas Extraordinarias", "M"}, {"103", "Horas Nocturnas", "M"}, {"104", "Otros haberes ","M"}};


        String[][] deducciones = {{"200", "Obra Social", "3"}, {"201", "Jubilacion", "11"},
                {"202", "Sindicato", "2"}, {"203", "Seguro", "1.5"}, {"204", "Otros", "M"}};

        HashSet<Integer> codigosIngresados = new HashSet<>();

        ArrayList<String>bonosCalculados = new ArrayList<>();

        /// CREO EMPLEADOO **************************

        Empleado elRulo = new Empleado();

        elRulo.crearEmpleado();

        while (true) {


            do {
                System.out.println("ingrese año de facturacion");
                anioFact = Integer.parseInt(sc.next());
                val.validar(anioFact);
            } while (!val.validar(anioFact));

            do {
                System.out.println("ingrese mes de facturacion");
                mesFact = Integer.parseInt(sc.next());
                val.validar(mesFact);
            } while (!val.validar(mesFact));



            BonoSueldo bonoSueldo = new BonoSueldo();
            bonoSueldo.setEmpleado(elRulo);
            bonoSueldo.setAnioLiquidacion(anioFact);
            bonoSueldo.setMesLiquidacion(mesFact);


            String[][] bonoCalculado = new String[10][4];


            int x = 0;


            System.out.println("Ingrese los haberes del empleado");
            String[][] haberesIngresados = new String[5][4];

            while (true) {

                System.out.println("ingrese codigo del item o ingrese 999 para finalizar la carga de haberes");

                item = sc.next();
                if (item.equals("999")) {
                    if (codigosIngresados.isEmpty()) {
                        System.out.println("debe ingresar por lo menos un haber");
                    } else {
                        break;
                    }
                }

                boolean existe = val.validarCodigoExistente(item, haberes);
                boolean yaSeIngreso = val.validarCodigoYaingresad0(item, codigosIngresados);
                if (existe) {
                    if (yaSeIngreso) {
                        System.out.println("El item ya fue ingresado anteriormente");
                    } else {
                        codigosIngresados.add(Integer.parseInt(item));

                        for (int i = 0; i < haberes.length; i++) {
                            if (haberes[i][0].equals(item)) {

                                if (!haberes[i][2].equals("M")) {
                                    bonoCalculado[x][0] = haberes[i][0];
                                    bonoCalculado[x][1] = haberes[i][1];
                                    bonoCalculado[x][2] = String.valueOf((Double.parseDouble(haberes[i][2]) / 100 )* elRulo.getSalarioBasico());
                                    sumaHaberes = sumaHaberes + Double.parseDouble(bonoCalculado[x][2]);
                                    haberesIngresados[x][0] = haberes[i][0];
                                    haberesIngresados[x][1] = haberes[i][1];
                                    haberesIngresados[x][2] = bonoCalculado[x][2];

                                } else {
                                    bonoCalculado[x][0] = haberes[i][0];
                                    bonoCalculado[x][1] = haberes[i][1];
                                    System.out.println("Ingrese el monto a pagar por " + haberes[i][1]);
                                    double monto = Double.parseDouble(sc.next());
                                    bonoCalculado[x][2] = String.valueOf((double) monto);
                                    sumaHaberes = sumaHaberes + monto;
                                    haberesIngresados[x][0] = haberes[i][0];
                                    haberesIngresados[x][1] = haberes[i][1];
                                    haberesIngresados[x][2] = bonoCalculado[x][2];

                                }

                                break;
                            }
                        }
                        x++;
                    }

                } else {

                    System.out.println("codigo invalido, intente nuevamente");
                }

            }

            System.out.println(" ************************************************************************");

            System.out.println("\ningrese las deducciones del empleado");
            String[][] deduccionesIngresadas = new String[5][4];

            while (true) {
                System.out.println("Ingrese código del ítem o ingrese 000 para finalizar la carga de deducciones");

                item = sc.next();
                if (item.equals("000")) {
                    if (codigosIngresados.isEmpty()) {
                        System.out.println("Debe ingresar por lo menos una deducción");
                    } else {
                        break;
                    }
                }

                boolean existe = val.validarCodigoExistente(item, deducciones);
                boolean yaSeIngreso = val.validarCodigoYaingresad0(item, codigosIngresados);
                if (existe) {
                    if (yaSeIngreso) {
                        System.out.println("El ítem ya fue ingresado anteriormente");
                    } else {
                        codigosIngresados.add(Integer.parseInt(item));

                        for (int i = 0; i < deducciones.length; i++) {
                            if (deducciones[i][0].equals(item)) {

                                if (!deducciones[i][2].equals("M")) {
                                    bonoCalculado[x][0] = deducciones[i][0];
                                    bonoCalculado[x][1] = deducciones[i][1];
                                    bonoCalculado[x][3] = String.valueOf(Double.parseDouble(deducciones[i][2]) / 100 * elRulo.getSalarioBasico());
                                    sumaDeducciones += Double.parseDouble(bonoCalculado[x][3]);
                                    deduccionesIngresadas[x][0] = deducciones[i][0];
                                    deduccionesIngresadas[x][1] = deducciones[i][1];
                                    deduccionesIngresadas[x][3] = bonoCalculado[x][3];
                                } else {
                                    bonoCalculado[x][0] = deducciones[i][0];
                                    bonoCalculado[x][1] = deducciones[i][1];
                                    System.out.println("Ingrese el monto a pagar por " + deducciones[i][1]);
                                    double monto = Double.parseDouble(sc.next());
                                    bonoCalculado[x][3] = String.valueOf(monto);
                                    sumaDeducciones += monto;
                                    deduccionesIngresadas[x][0] = deducciones[i][0];
                                    deduccionesIngresadas[x][1] = deducciones[i][1];
                                    deduccionesIngresadas[x][3] = bonoCalculado[x][3];
                                }
                                break;
                            }
                        }
                        x = x + 1;
                    }
                } else {
                    System.out.println("Código inválido, intente nuevamente");
                }
            }

            bonoSueldo.setDeducciones(deduccionesIngresadas);
            bonoSueldo.setHaberes(haberesIngresados);



            double liquidacionFinal = (elRulo.getSalarioBasico() + elRulo.getMontoAntiguedad() + sumaHaberes) - sumaDeducciones;
            bonoSueldo.setSumaDeducciones(sumaDeducciones);
            bonoSueldo.setSumaHaberes(sumaHaberes);

            bonoSueldo.setMontoLiquidacion(liquidacionFinal);
            elRulo.agregarBono(bonoSueldo);



            int opcion = 0;
            while (true) {
                System.out.println("Desea generar otro bono de sueldo ?");
                System.out.println("1.Si");
                System.out.println("2.No");
                opcion = Integer.parseInt(sc.next());

                if (opcion==1||opcion==2) {
                    codigosIngresados.clear();
                    break;
                }else {
                    System.out.println("error: Opcion invalida");
                }
            }
            if (opcion==2) {
                for(BonoSueldo bono:elRulo.getBonos()){
                    bono.mostrarBonoSueldo();

                }

                break;
            }

        }

    }
}