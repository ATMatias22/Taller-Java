/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.modelo.clases;


/**
 *
 * @author Matias
 */
public class Automovil {
    
    private int idAutomovil;
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private String dniCliente;

    public Automovil(int idAutomovil, String patente, String marca, String modelo, int anioFabricacion, String dniCliente) {
        this.idAutomovil = idAutomovil;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.dniCliente = dniCliente;
    }
    public int getIdAutomovil() {
        return idAutomovil;
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    @Override
    public String toString() {
        return "Automovil{" + "idAutomovil=" + idAutomovil + ", patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + ", anioFabricacion=" + anioFabricacion + ", dniCliente=" + dniCliente + '}';
    }
    
    

 
    
    
    
}
