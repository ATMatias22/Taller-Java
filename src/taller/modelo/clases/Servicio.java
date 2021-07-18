/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.modelo.clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import taller.interfaces.Seccion;

/**
 *
 * @author Matias
 */
public class Servicio implements Seccion {

    private int idServicio;
    private String fechaDeRealizacion;
    private double costo;
    private String patenteDelAutomovil;
    private int cantKms;

    public Servicio(int idServicio, String fechaDeRealizacion, double costo, String patenteDelAutomovil, int cantKms) {
        this.idServicio = idServicio;
        this.fechaDeRealizacion = fechaDeRealizacion;
        this.costo = costo;
        this.patenteDelAutomovil = patenteDelAutomovil;
        this.cantKms = cantKms;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public String getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }

    public double getCosto() {
        return costo;
    }

    public String getPatenteDelAutomovil() {
        return patenteDelAutomovil;
    }

    public int getCantKms() {
        return cantKms;
    }

    public String obtenerFechaLegible() {
        LocalDate l = LocalDate.parse(fechaDeRealizacion);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return l.format(formatter);
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", fechaDeRealizacion=" + fechaDeRealizacion + ", costo=" + costo + ", patenteDelAutomovil=" + patenteDelAutomovil + ", cantKms=" + cantKms + '}';
    }

    @Override
    public Object[] getArrayAtributos() {
        return new Object[]{this.getIdServicio(), obtenerFechaLegible(), this.getCosto(), this.getPatenteDelAutomovil(), this.cantKms};
    }

}
