/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.modelo.clases;

import taller.interfaces.SeccionDeNegocio;

/**
 *
 * @author Matias
 */
public class Cliente implements SeccionDeNegocio {

    private int idCliente;
    private String dni;
    private String nombre;
    private String apellido;
    private String mail;
    private int telefono;

    public Cliente(int idCliente, String dni, String nombre, String apellido, String mail, int telefono) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return mail;
    }

    public int getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", telefono=" + telefono + '}';
    }

    @Override
    public Object[] getArrayAtributos() {
        return new Object[]{this.getIdCliente(), this.getDni(), this.getNombre(), this.getApellido(), this.getMail(), this.getTelefono()};
    }


}
