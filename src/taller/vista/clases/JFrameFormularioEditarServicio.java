/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Color;
import java.awt.Component;
import java.util.Collection;
import taller.modelo.clases.Servicio;

/**
 *
 * @author Matias
 */
public class JFrameFormularioEditarServicio extends JFrameFormularioServicio {

    private Servicio se;
    private final static String TITULO = "Editar Servicio";
    private final static String TEXTO_BOTON = "Editar Servicio";
    private final static Color COLOR_FONDO = new Color(255, 204, 0);
    private final static Color COLOR_TEXTO = new Color(153, 102, 0);
    private final static int HEIGHT_PANEL_FORMULARIO = 253;


    public JFrameFormularioEditarServicio(Servicio se, Component parent, Collection<String> patentesAutomoviles)  {
        super(parent, patentesAutomoviles,TITULO, TEXTO_BOTON, COLOR_FONDO, COLOR_TEXTO, HEIGHT_PANEL_FORMULARIO);
        this.se = se;
        iniciar();
    }

    private void iniciar()  {
        colocarServicioEnFormulario();
    }

    private void colocarServicioEnFormulario()  {
        getTextFieldCosto().setText(se.getCosto() + "");
        getTextFieldKms().setText(se.getCantKms() + "");
        getComboBoxPatentes().setSelectedItem(se.getPatenteDelAutomovil());
        setearFecha(se.getFechaDeRealizacion());
    }
    
    @Override
    public Servicio getServicio(){
        Servicio sNuevo = super.getServicio();
        sNuevo.setIdServicio(se.getIdServicio());
        return sNuevo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Servicio");
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
