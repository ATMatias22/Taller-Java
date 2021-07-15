/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import taller.modelo.clases.Automovil;
import taller.modelo.clases.Categoria;

/**
 *
 * @author Matias
 */
public class JFrameAutomoviles extends JFrameTemplate {

    private Automovil a;
    private final static String NOMBRE_ARCHIVO_LOGO =  "automovil.png";
    

    public JFrameAutomoviles(JFrame parent) {
        super("Automoviles", Categoria.AUTOMOVIL, parent, NOMBRE_ARCHIVO_LOGO);
        getTabla().addMouseListener(new LlenarFormularioConElAutomovilSeleccionado());
    }

    private class LlenarFormularioConElAutomovilSeleccionado extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                getTabla().setRowSelectionAllowed(true);
                int fila = getTabla().rowAtPoint(e.getPoint());
                a = new Automovil((int) getTabla().getValueAt(fila, 0), getTabla().getValueAt(fila, 1).toString(), getTabla().getValueAt(fila, 2).toString(), getTabla().getValueAt(fila, 3).toString(), (int) getTabla().getValueAt(fila, 4), getTabla().getValueAt(fila, 5).toString());
                habilitarODeshabiliarBotones(true);
            } else if (e.getClickCount() == 1) {
                a = null;
                getTabla().setRowSelectionAllowed(false);
                habilitarODeshabiliarBotones(false);
            }
        }
    }

    public Automovil getAutomovil() {
        if (a == null) {
            throw new RuntimeException("Debe seleccionar un automovil");
        }
        return a;
    }

    public void actualizarListaAutomoviles(Collection<Automovil> automoviles) {
        vaciar();
        mostrarAutomoviles(automoviles);
    }

    public void mostrarAutomoviles(Collection<Automovil> automoviles) {
        for (Automovil emp : automoviles) {
            agregarFila(emp);
        }
    }

    private void agregarFila(Automovil e) {
        Object[] datos = {e.getIdAutomovil(), e.getPatente(), e.getMarca(), e.getModelo(), e.getAnioFabricacion(), e.getDniCliente()};
        DefaultTableModel dtm = (DefaultTableModel) getTabla().getModel();
        dtm.addRow(datos);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
