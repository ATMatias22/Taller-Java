/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.helpers;

import java.util.Date;


/**
 *
 * @author Matias
 */
public class Validaciones {

    public final static boolean esMailValido(String cad) {
        return cad.contains("@") && cad.contains(".");
    }

    public final static boolean esNumeroEntero(String cad) {
        boolean esEntero = true;
        try {
            Integer.parseInt(cad);
        } catch (RuntimeException e) {
            esEntero = false;
        }
        return esEntero;
    }

    public final static boolean esNumeroDouble(String cad) {
        boolean esDouble = true;
        try {
            Double.parseDouble(cad);
        } catch (RuntimeException e) {
            esDouble = false;
        }
        return esDouble;
    }

    public final static boolean estaVacio(String cad) {
        return cad.isBlank();
    }
    
     public final static boolean esFecha(Date d) {
        return d != null ;
    }

}
