package bo.edu.ucb.est.modelo;

public class Movimientos {
    public int opcion;

    public Movimientos(int opcion) {
        this.opcion = opcion;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
    public void operaciones(Cliente cli) throws Exception {
        CajeroTeclado ct = new CajeroTeclado();
        CajeroVerificar v = new CajeroVerificar();
        if(opcion == 4){
            System.out.println("Gracias por su preferencia :) ");
            System.exit(0);
        }
        Cuenta cuen = seleccionCuenta(cli);
        switch (opcion){
            case 1:
                System.out.println(cuen.toString()); //Debe imprimir el saldo, crear un método para mostrarlo
                break;
            case 2:
                System.out.println("Ingrese el monto a retirar: ");
                double monto = ct.teclasMontos();
                v.verificarTransacciones(cuen.retirar(monto));
                break;
            case 3:
                System.out.println("Ingrese el monto a depositar: ");
                double monto1 = ct.teclasMontos();
                v.verificarTransacciones(cuen.depositar(monto1));
                break;
        }

    }
    public Cuenta seleccionCuenta(Cliente cli){
        CajeroTeclado ct = new CajeroTeclado();
        CajeroVerificar v = new CajeroVerificar();
        String cta;
        Cuenta cu = null;
        while(true){
            System.out.println("----------------------------------------------------------------");
            System.out.println("Selccione la cuenta: ");
            for(int i = 0; i < cli.getCuentas().size(); i++){
                System.out.println((i+1)+".- "+cli.getCuentas().get(i).getNumeroCuenta());
            }
            System.out.println("----------------------------------------------------------------");

            try {
                cta = ct.teclasNumerales();
                v.verificarEleccionCuenta(cli,Integer.parseInt(cta));
                if(cta != null){
                    cu = cli.getCuentas().get(Integer.parseInt(cta)-1);
                    break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }


        }

        return cu;
    }

}
