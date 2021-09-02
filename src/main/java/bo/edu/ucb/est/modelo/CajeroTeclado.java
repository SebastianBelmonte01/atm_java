package bo.edu.ucb.est.modelo;

import java.util.Scanner;

public class CajeroTeclado {
    CajeroVerificar cv = new CajeroVerificar();
    public String teclasNumerales() throws Exception {
        Scanner s = new Scanner(System.in);
        String numero = s.nextLine();
        cv.verificarDigitos(numero);
        return numero;
    }
    public String teclasLiterales(){
        Scanner s = new Scanner(System.in);
        String numero = s.nextLine();
        return numero;
    }
    public double teclasMontos() throws Exception {
        Scanner s = new Scanner(System.in);
        String monto = s.nextLine();
        cv.verificarMontos(monto);
        return Double.parseDouble(monto);
    }
}
