/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.ucb.est.modelo;

import java.util.Scanner;

/**
 *
 * @author ecampohermoso
 */
public class Cajero {
    public void ingreso(Banco b){
        while (true){
            Scanner s = new Scanner(System.in);
            System.out.println("Ingrese el código: ");
            String cod = s.nextLine();
            System.out.println("Ingrese el pin: ");
            String pin = s.nextLine();
            Cliente c =  b.buscarClientePorCodigo(cod,pin);
            if(c != null){
                menu(c);
            }
        }



    }
    public void menu(Cliente cli){
        short op;
        Scanner s = new Scanner(System.in);
        Cuenta cuentaSeleccionada = null;
        while(true){
            System.out.println(" -----------------------------------------\nMENÚ DE OPCIONES\n -----------------------------------------");
            System.out.println("1.- Consulta"); //Ver saldo
            System.out.println("2.- Retiro");
            System.out.println("3.- Depósito");
            System.out.println("4.- Salir\n----------------------------------------------------------------");
            System.out.print("Ingrese una opcion: ");
            op = s.nextShort();
            switch (op){
                case 1:
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Selccione la cuenta: ");
                    for(int i = 0; i < cli.getCuentas().size(); i++){
                        System.out.println((i + 1) + ".- " + cli.getCuentas().get(i));
                    }
                    short eleccion = s.nextShort();
                    if (eleccion <= 0 || eleccion > cli.getCuentas().size()) {
                        System.out.println("Ingrese una cuenta valida. ");
                    } else {
                        cuentaSeleccionada = cli.getCuentas().get(eleccion-1);
                        System.out.println(cuentaSeleccionada.toString());
                    }
                    break;
                case 2:
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Selccione la cuenta: ");
                    for(int i = 0; i < cli.getCuentas().size(); i++){
                        System.out.println((i + 1) + ".- " + cli.getCuentas().get(i));
                    }
                    short eleccion1 = s.nextShort();
                    if (eleccion1 <= 0 || eleccion1 > cli.getCuentas().size()) {
                        System.out.println("Ingrese una cuenta valida. ");
                    } else {
                        cuentaSeleccionada = cli.getCuentas().get(eleccion1-1);
                        System.out.println("Ingrese el monto: ");
                        double monto = s.nextDouble();
                        cuentaSeleccionada.retirar(monto);
                    }
                    break;
                case 3:
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Selccione la cuenta: ");
                    for(int i = 0; i < cli.getCuentas().size(); i++){
                        System.out.println((i + 1) + ".- " + cli.getCuentas().get(i));
                    }
                    short eleccion2 = s.nextShort();
                    if (eleccion2 <= 0 || eleccion2 > cli.getCuentas().size()) {
                        System.out.println("Ingrese una cuenta valida. ");
                    } else {
                        cuentaSeleccionada = cli.getCuentas().get(eleccion2-1);
                        System.out.println("Ingrese el monto: ");
                        double monto = s.nextDouble();
                        cuentaSeleccionada.depositar(monto);
                    }
                    break;

            }
        }
    }
    
}
