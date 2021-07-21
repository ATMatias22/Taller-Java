/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import taller.modelo.clases.TipoSeccion;
import taller.modelo.clases.Cliente;
import taller.interfaces.SeccionDeNegocio;

/**
 *
 * @author Matias
 */
public class JFrameCliente<T extends SeccionDeNegocio> extends JFrameSecciones<T> {

    private Cliente cl;
    private final static String TITULO = "Clientes";

    public JFrameCliente(JFrame parent) {
        super(TITULO, TipoSeccion.CLIENTE, parent);
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

     public Cliente getCliente() {
        if (cl == null) {
            throw new RuntimeException("Debe seleccionar un Cliente");
        }
        return cl;
    }
    
    private void llenarFormularioConDatos(int fila) {
        cl = new Cliente((int) getTabla().getValueAt(fila, 0), getTabla().getValueAt(fila, 1).toString(), getTabla().getValueAt(fila, 2).toString(), getTabla().getValueAt(fila, 3).toString(), getTabla().getValueAt(fila, 4).toString(), (int) getTabla().getValueAt(fila, 5));
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
                cl = null;
                getTabla().setRowSelectionAllowed(false);
                habilitarODeshabiliarBotones(false);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
