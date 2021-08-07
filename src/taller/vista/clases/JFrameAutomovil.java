/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import taller.modelo.clases.Automovil;
import taller.modelo.clases.TipoSeccion;
import taller.interfaces.SeccionDeNegocio;

/**
 *
 * @author Matias
 */
public  class JFrameAutomovil<T extends SeccionDeNegocio> extends JFrameSecciones<T> {

    private Automovil au;
    private final static String TITULO = "Automoviles";

    public JFrameAutomovil(JFrame parent) {
        super(TITULO, TipoSeccion.AUTOMOVIL, parent);
        getTabla().addMouseListener(new LlenarFormularioConLaSeccionSeleccionado());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarFormularioConDatos(int fila) {
      au = new Automovil((int) getTabla().getValueAt(fila, 0), getTabla().getValueAt(fila, 1).toString(), getTabla().getValueAt(fila, 2).toString(), getTabla().getValueAt(fila, 3).toString(), (int) getTabla().getValueAt(fila, 4), getTabla().getValueAt(fila, 5).toString());
    }

    public Automovil getAutomovil() {
        if (au == null) {
            throw new RuntimeException("Debe seleccionar un Automovil");
        }
        return au;
    }

    private class LlenarFormularioConLaSeccionSeleccionado extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                getTabla().setRowSelectionAllowed(true);
                int filaSeleccionada = getTabla().rowAtPoint(e.getPoint());
                llenarFormularioConDatos(filaSeleccionada);
                habilitarODeshabiliarBotones(true);
            } else if (e.getClickCount() == 1) {
                au = null;
                getTabla().setRowSelectionAllowed(false);
                habilitarODeshabiliarBotones(false);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
