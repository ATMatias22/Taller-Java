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
public enum Categoria  {

    CLIENTE(new String[]{"dni", "nombre", "apellido", "mail", "telefono"}, 
            new String[]{"id", "dni", "nombre", "apellido", "mail", "telefono"}, 
            new String[]{"idCliente", "dni", "nombre", "apellido", "mail", "telefono"}),
    
    AUTOMOVIL(new String[]{"patente", "marca", "modelo", "año de fabricacion", "dni cliente"},
            new String[]{"id", "patente", "marca", "modelo", "año de fabricacion", "dni cliente"},
            new String[]{"idAutomovil", "patente", "marca", "modelo", "anioFabricacion", "dniCliente"}),
    
    SERVICIO(new String[]{"fecha de realizacion", "costo", "patente del automovil", "cantidad de kilometros"},
            new String[]{"id", "fecha de realizacion", "costo", "patente del automovil", "cantidad de kilometros"},
            new String[]{"idServicio", "fechaDeRealizacion", "costo", "patenteDelAutomovil", "cantKms"});

    private String[] nombresDeCategoriasParaElFiltro;
    private String[] nombreDeCategoriasParaLaTabla;
    private String[] nombreEnBD;

    private Categoria(String[] nombresDeCategoriasParaElFiltro, String[] nombreDeCategoriasParaLaTabla, String[] nombreEnBD) {
        this.nombresDeCategoriasParaElFiltro = nombresDeCategoriasParaElFiltro;
        this.nombreDeCategoriasParaLaTabla = nombreDeCategoriasParaLaTabla;
        this.nombreEnBD = nombreEnBD;
    }

    public String[] getNombreDeCategoriasParaElFiltro() {
        return this.nombresDeCategoriasParaElFiltro;
    }

    public String[] getNombreDeCategoriasParaLaTabla() {
        return this.nombreDeCategoriasParaLaTabla;
    }
    
    public String buscarEquivalenteEnBD(int posicion){
        return nombreEnBD[posicion];
    }
 
}
