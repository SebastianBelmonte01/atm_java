/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.ucb.est.modelo;

/**
 *
 * @author ecampohermoso
 */
public class Cuenta {
    private String moneda;
    private String tipo;
    private double saldo;
    private String numeroCuenta;

    public Cuenta(String moneda, String tipo, double saldoInicial, String numeroCuenta) {
        this.moneda = moneda;
        this.tipo = tipo;
        this.saldo = saldoInicial;
        this.numeroCuenta = numeroCuenta;
    }

    public boolean retirar(double monto) {
        boolean resultado = false;
        if (monto > 0 && monto <= saldo) { // verifica que no sea negativo, cero o exceda su saldo
            saldo = saldo - monto;
            resultado = true; // si he podido retirar
        }
        return resultado;
    }
    
    public boolean depositar(double monto) {
        boolean resultado = false;
        if (monto > 0 ) { // verifica que no sea negativo, cero o exceda su saldo
            saldo = saldo + monto;
            resultado = true; // si he podido retirar
        }
        return resultado;
    }
            
    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "Moneda: " + moneda + "\n"+
                "Tipo: " + tipo + "\n" +
                "Saldo: " + saldo + "\n";
    }
}
