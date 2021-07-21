/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Color;
import java.awt.Component;
import taller.modelo.clases.Cliente;

/**
 *
 * @author Matias
 */
public class JFrameFormularioEditarCliente extends JFrameFormularioCliente {

    private Cliente cl;
    private final static String TITULO = "Editar Cliente";
    private final static String TEXTO_BOTON = "Editar Cliente";
    private final static Color COLOR_FONDO = new Color(255, 204, 0);
    private final static Color COLOR_TEXTO = new Color(153, 102, 0);
    private final static int HEIGHT_PANEL_FORMULARIO = 204;

    public JFrameFormularioEditarCliente(Cliente cl, Component parent) {
        super(parent, TITULO, TEXTO_BOTON, COLOR_FONDO, COLOR_TEXTO, HEIGHT_PANEL_FORMULARIO);
        this.cl = cl;
        iniciar();
    }

    private void iniciar() {
        colocarClienteEnFormulario();
    }

    private void colocarClienteEnFormulario() {
        getTextFieldDNI().setText(cl.getDni());
        getTextFieldNombre().setText(cl.getNombre());
        getTextFieldApellido().setText(cl.getApellido());
        getTextFieldMail().setText(cl.getMail());
        getTextFieldTelefono().setText(cl.getTelefono() + "");
    }
//
    @Override
    public Cliente getCliente() {
        Cliente cNuevo = super.getCliente();
        cNuevo.setIdCliente(cl.getIdCliente());
        return cNuevo;
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Cliente");
        setBackground(new java.awt.Color(51, 255, 51));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
