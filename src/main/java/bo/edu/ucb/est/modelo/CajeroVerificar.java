package bo.edu.ucb.est.modelo;

public class CajeroVerificar {
    public void verificarPin(String pinIngresado) throws Exception {
        if(pinIngresado.length() != 4){
            throw new Exception("Su pin debe contener 4 dígitos. ");
        }
    }
    public void verificarDigitos(String numero) throws Exception {
        try{
            Integer.parseInt(numero);
        }catch (NumberFormatException e){
            throw  new Exception("Debe ingresar dígitos. ");
        }
    }
    public void verificarMontos(String numero) throws Exception {
        try{
            Double.parseDouble(numero);
        }catch (NumberFormatException e){
            throw  new Exception("Debe ingresar dígitos. ");
        }
    }
    public void clienteEncotrado(Cliente cli) throws Exception {
        if(cli == null){
            throw new Exception("PIN ó Código incorrecto \nIntente de nuevo ... ");
        }
    }
    public void opcionMenu(String op) throws Exception {
        if(Integer.parseInt(op) > 4 || Integer.parseInt(op) < 1){
            throw new Exception("Debe seleccionar una opcón entre uno y cuatro");
        }
    }
    public void verificarEleccionCuenta(Cliente c, int eleccion) throws Exception {
        if(eleccion > c.getCuentas().size() || eleccion < 1){
            throw  new Exception("Debe seleccionar una cuenta existente. ");
        }
    }
    public void verificarTransacciones(Boolean flag) throws Exception {
        if(!flag){
            throw  new Exception("Debe ingresar un monto correcto! ");
        }
    }
}
