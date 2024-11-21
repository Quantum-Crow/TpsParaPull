import java.time.LocalDate;
import java.util.HashSet;

public class Validaciones {

    LocalDate fecha=LocalDate.now();

    public boolean validar(int anio) {
        if (anio> fecha.getYear()){
            System.out.println("El año ingresador no es valido");
            return false;
        }else{
            return true;
        }

    }

    public boolean validadrMes(int mes,int anio){

        if (anio == fecha.getYear()){
            if (mes<fecha.getMonthValue()){
                return true;
            }else{
                return false;
            }

        }else if(anio<fecha.getYear()){
            return true;

        }else{
            System.out.println("Mes ingresado no valido, por favor intente de nuevo");
            return false;
        }

    }

    public boolean validarInColumna(String[][] matriz,int columna, String valor){
        boolean encontrado=false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][columna].equals(valor)){
                encontrado= true;
                break;
            }
        }
        return encontrado;
    }

    public boolean validarInFila(String[][] matriz,int fila, String valor){
        boolean encontrado=false;

        for (int i = 0; i < matriz[0].length; i++) {

            if (matriz[fila][i].equals(valor)){
                encontrado= true;
                break;
            }
        }
        return encontrado;
    }

    public boolean validarCodigoExistente(String codigo,String[][]matriz){
        boolean encontrado=false;

        for (int i = 0; i < matriz.length; i++) {
            if(matriz[i][0].equals(codigo)){
                encontrado= true;
                break;
            }
        }

        return encontrado;

    }

    public boolean validarCodigoYaingresad0(String codigo, HashSet<Integer> lista){

        boolean encontrado=false;

        if(!lista.isEmpty()){
            if(lista.contains(Integer.parseInt(codigo))){
                encontrado=true;
            }
        }

        return encontrado;
    }

    public void validarNull(String[][]matriz){

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j]==null){
                    matriz[i][j]="XXXXXXX";
                }
            }
        }

    }


}