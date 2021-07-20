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
public enum TipoSeccion  {

    CLIENTE("Cliente",
            "cliente.png",
            "cliente_mini.png",
            new String[]{"dni", "nombre", "apellido", "mail", "telefono"}, 
            new String[]{"id", "dni", "nombre", "apellido", "mail", "telefono"}, 
            new String[]{"dni", "nombre", "apellido", "mail", "telefono"}),
    
    AUTOMOVIL("Automovil",
            "automovil.png",
            "automovil_mini.png",
            new String[]{"patente", "marca", "modelo", "año de fabricacion", "dni cliente"},
            new String[]{"id", "patente", "marca", "modelo", "año de fabricacion", "dni cliente"},
            new String[]{"patente", "marca", "modelo", "anioFabricacion", "dniCliente"}),
    
    SERVICIO("Servicio",
            "servicio.png",
            "servicio_mini.png",
            new String[]{"costo", "patente del automovil", "cantidad de kilometros"},
            new String[]{"id", "fecha de realizacion", "costo", "patente del automovil", "cantidad de kilometros"},
            new String[]{"costo", "patenteDelAutomovil", "cantKms"});

    private String nombre;
    private String nombreLogo;
    private String nombreLogoMini;
    private String[] nombresDeCategoriasParaElFiltro;
    private String[] nombreDeCategoriasParaLaTabla;
    private String[] nombreEnBD;
    

    private TipoSeccion(String nombre,String nombreLogo, String nombreLogoMini,String[] nombresDeCategoriasParaElFiltro, String[] nombreDeCategoriasParaLaTabla, String[] nombreEnBD) {
        this.nombre = nombre;
        this.nombreLogo = nombreLogo;
        this.nombreLogoMini = nombreLogoMini;
        this.nombresDeCategoriasParaElFiltro = nombresDeCategoriasParaElFiltro;
        this.nombreDeCategoriasParaLaTabla = nombreDeCategoriasParaLaTabla;
        this.nombreEnBD = nombreEnBD;
    }

    public String[] getNombreDeCategoriasParaElFiltro() {
        return this.nombresDeCategoriasParaElFiltro;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getNombreLogo(){
        return this.nombreLogo;
    }
    
    public String getNombreLogoMini(){
        return this.nombreLogoMini;
    }

    public String[] getNombreDeCategoriasParaLaTabla() {
        return this.nombreDeCategoriasParaLaTabla;
    }
    
    public String buscarEquivalenteEnBD(int posicion){
        return nombreEnBD[posicion];
    }
 
}
