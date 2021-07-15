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
import taller.modelo.clases.Categoria;
import taller.modelo.clases.Servicio;

/**
 *
 * @author Matias
 */
public class JFrameServicios extends JFrameTemplate {

    private Servicio se;
    private final static String NOMBRE_ARCHIVO_LOGO = "servicio.png";

    public JFrameServicios(JFrame parent) {
        super("Servicios", Categoria.SERVICIO, parent, NOMBRE_ARCHIVO_LOGO);
        getTabla().addMouseListener(new LlenarFormularioConElServicioSeleccionado());
    }

    private class LlenarFormularioConElServicioSeleccionado extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                getTabla().setRowSelectionAllowed(true);
                int fila = getTabla().rowAtPoint(e.getPoint());
                se = new Servicio((int) getTabla().getValueAt(fila, 0), getTabla().getValueAt(fila, 1).toString(), (double) getTabla().getValueAt(fila, 2), getTabla().getValueAt(fila, 3).toString(), (int) getTabla().getValueAt(fila, 4));
                habilitarODeshabiliarBotones(true);
            } else if (e.getClickCount() == 1) {
                se = null;
                getTabla().setRowSelectionAllowed(false);
                habilitarODeshabiliarBotones(false);
            }
        }
    }
    
    public Servicio getServicio() {
        if (se == null) {
            throw new RuntimeException("Debe seleccionar un Servicio");
        }
        return se;
    }

    public void actualizarListaServicio(Collection<Servicio> servicios) {
        vaciar();
        mostrarServicios(servicios);
    }

    public void mostrarServicios(Collection<Servicio> servicios) {
        for (Servicio emp : servicios) {
            agregarFila(emp);
        }
    }

    private void agregarFila(Servicio e) {

        Object[] datos = {e.getIdServicio(), e.obtenerFechaLegible(), e.getCosto(), e.getPatenteDelAutomovil(), e.getCantKms()};
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
