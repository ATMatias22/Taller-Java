package taller.vista.clases;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import taller.modelo.clases.Categoria;
import taller.modelo.clases.Cliente;

public class JFrameClientes extends JFrameTemplate {

    private Cliente c;
        private final static String NOMBRE_ARCHIVO_LOGO =  "cliente.png";


    public JFrameClientes(JFrame parent) {
        super("Clientes",Categoria.CLIENTE, parent, NOMBRE_ARCHIVO_LOGO);
        getTabla().addMouseListener(new LlenarFormularioConElClienteSeleccionado());
    }

    private class LlenarFormularioConElClienteSeleccionado extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                getTabla().setRowSelectionAllowed(true);
                int fila = getTabla().rowAtPoint(e.getPoint());
                c = new Cliente((int) getTabla().getValueAt(fila, 0), getTabla().getValueAt(fila, 1).toString(), getTabla().getValueAt(fila, 2).toString(), getTabla().getValueAt(fila, 3).toString(), getTabla().getValueAt(fila, 4).toString(), (int) getTabla().getValueAt(fila, 5));
                habilitarODeshabiliarBotones(true);
            } else if (e.getClickCount() == 1) {
                c= null;
                getTabla().setRowSelectionAllowed(false);
                habilitarODeshabiliarBotones(false);
            }
        }
    }

    public Cliente getCliente() {
        if (c == null) {
            throw new RuntimeException("Debe seleccionar un cliente");
        }
        return c;
    }

    public void actualizarListaClientes(Collection<Cliente> clientes) {
        vaciar();
        mostrarClientes(clientes);
    }

    public void mostrarClientes(Collection<Cliente> clientes) {
        for (Cliente emp : clientes) {
            agregarFila(emp);
        }
    }

    private void agregarFila(Cliente e) {
        Object[] datos = {e.getIdCliente(), e.getDni(), e.getNombre(), e.getApellido(), e.getMail(), e.getTelefono()};
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
