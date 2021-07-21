/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import taller.modelo.clases.Servicio;
import taller.modelo.clases.TipoSeccion;
import taller.interfaces.SeccionDeNegocio;

/**
 *
 * @author Matias
 */
public class JFrameServicio<T extends SeccionDeNegocio> extends JFrameSecciones<T> {

    private Servicio se;
    private final static String TITULO = "Servicios";

    public JFrameServicio(JFrame parent) {
        super(TITULO, TipoSeccion.SERVICIO, parent);
        habilitarBotonDeListar(true);
        getTabla().addMouseListener(new LlenarFormularioConLaSeccionSeleccionado());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     private void llenarFormularioConDatos(int fila) {
        se = new Servicio((int) getTabla().getValueAt(fila, 0), getTabla().getValueAt(fila, 1).toString(), (double) getTabla().getValueAt(fila, 2), getTabla().getValueAt(fila, 3).toString(), (int) getTabla().getValueAt(fila, 4));
    }

    public Servicio getServicio() {
        if (se == null) {
            throw new RuntimeException("Debe seleccionar un Servicio");
        }
        return se;
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
                se = null;
                getTabla().setRowSelectionAllowed(false);
                habilitarODeshabiliarBotones(false);
            }
        }
    }
    
    public void addActionListenerListarAutomoviles(ActionListener al){
        getButtonListar().addActionListener(al);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
