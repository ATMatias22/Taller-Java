/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Color;
import java.awt.Component;
import java.util.Collection;

/**
 *
 * @author Matias
 */
public class JFrameFormularioAgregarServicio extends JFrameFormularioServicio {

    private final static String TITULO = "Agregar Servicio";
    private final static String TEXTO_BOTON = "Agregar Servicio";
    private final static Color COLOR_FONDO = new Color(0, 153, 0);
    private final static Color COLOR_TEXTO = new Color(255, 255, 255);
    private final static int HEIGHT_PANEL_FORMULARIO = 271;

    public JFrameFormularioAgregarServicio(Component parent, Collection<String> patentesAutomoviles) {
        super(parent, patentesAutomoviles,TITULO, TEXTO_BOTON,COLOR_FONDO, COLOR_TEXTO, HEIGHT_PANEL_FORMULARIO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Servicio");
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
