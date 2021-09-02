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

    public void menu(Banco ba){
        CajeroPantalla cp = new CajeroPantalla(ba);
        cp.ingreso();

    }
    
}
