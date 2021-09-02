package bo.edu.ucb.est.modelo;

import java.util.Scanner;

public class CajeroPantalla {

    Banco bancoActual;
    Cliente clienteSeleccionado;

    CajeroTeclado ct = new CajeroTeclado();
    CajeroVerificar cv = new CajeroVerificar();

    public CajeroPantalla(Banco bancoActual) {

        this.bancoActual = bancoActual;
    }





    public Banco getBancoActual() {
        return bancoActual;
    }

    public void setBancoActual(Banco bancoActual) {
        this.bancoActual = bancoActual;
    }

    public void ingreso() {

        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("Ingrese el código: ");
            String cod = ct.teclasLiterales();
            System.out.println("Ingrese el pin: ");
            String pin = null;
            try {
                pin  = ct.teclasNumerales();
                cv.verificarPin(pin);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            clienteSeleccionado = bancoActual.buscarClientePorCodigo(cod, pin);
            try {
                cv.clienteEncotrado(clienteSeleccionado);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            if(clienteSeleccionado != null){
                menu();
            }
        }

    }
    public void menu(){
        String op;

        while (true){
            System.out.println(" -----------------------------------------\nMENÚ DE OPCIONES\n -----------------------------------------");
            System.out.println("1.- Consulta"); //Ver saldo
            System.out.println("2.- Retiro");
            System.out.println("3.- Depósito");
            System.out.println("4.- Salir\n----------------------------------------------------------------");
            System.out.print("Ingrese una opción: ");
            try {
                op = ct.teclasNumerales();
                cv.opcionMenu(op);
                Movimientos mov = new Movimientos(Integer.parseInt(op));
                mov.operaciones(clienteSeleccionado);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }


        }

    }
}
