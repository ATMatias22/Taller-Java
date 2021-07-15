/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.modelo.clases;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Matias
 */
public class Servicio {
    
    private int idServicio;
    private Date fechaDeRealizacion;
    private double costo;
    private String patenteDelAutomovil;
    private int cantKms ;

    public Servicio(int idServicio, Date fechaDeRealizacion, double costo, String patenteDelAutomovil, int cantKms) {
        this.idServicio = idServicio;
        this.fechaDeRealizacion = fechaDeRealizacion;
        this.costo = costo;
        this.patenteDelAutomovil = patenteDelAutomovil;
        this.cantKms = cantKms;
    }
    
     public Servicio(int idServicio, String fechaDeRealizacion, double costo, String patenteDelAutomovil, int cantKms) {
        this.idServicio = idServicio;
        this.fechaDeRealizacion =  convertirFechaLegibleADate(fechaDeRealizacion);
        this.costo = costo;
        this.patenteDelAutomovil = patenteDelAutomovil;
        this.cantKms = cantKms;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public Date getFechaDeRealizacion() {
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
    
    public String obtenerFechaLegible(){
        LocalDate fechaFormato =LocalDate.parse(fechaDeRealizacion.toString());
        return fechaFormato.getDayOfMonth()+"-"+ fechaFormato.getMonthValue()+"-"+fechaFormato.getYear();
    }
    
    public Date convertirFechaLegibleADate(String fechaDeRealizacion){
        return java.sql.Date.valueOf(LocalDate.parse(fechaDeRealizacion, DateTimeFormatter.ofPattern("d-M-yyyy")));
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", fechaDeRealizacion=" + fechaDeRealizacion + ", costo=" + costo + ", patenteDelAutomovil=" + patenteDelAutomovil + ", cantKms=" + cantKms + '}';
    }
    
    
    
    
 
    
    
    
}
