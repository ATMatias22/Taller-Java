/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import taller.modelo.clases.Cliente;

/**
 *
 * @author Matias
 */
public class JFramePrincipal extends javax.swing.JFrame {

    private Cliente c;

    public JFramePrincipal() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }
        
    
    public void seleccionDeVentana(ActionListener al){
        for (int i = 0; i < jPanelAcciones.getComponents().length; i++) {
            ((JButton) jPanelAcciones.getComponent(i)).addActionListener(al);
        }
    }
 


//    public void addActionListenerBotonAgregar(ActionListener al) {
//        this.jButtonAgregar.addActionListener(al);
//    }
//
//    public void addActionListenerBotonEliminar(ActionListener al) {
//        this.jButtonEliminar.addActionListener(al);
//    }
//
//    public void addActionListenerBotonEditar(ActionListener al) {
//        this.jButtonEditar.addActionListener(al);
//    }
//
//    public void addKeyListenerJTextFieldFiltrar(KeyListener kl) {
//        this.jTextFieldFiltrar.addKeyListener(kl);
//    }
//
//    public void addActionListenerJComboBoxFiltrar(ActionListener al) {
//        this.jComboBoxFiltro.addActionListener(al);
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jLabelNombreDelNegocio = new javax.swing.JLabel();
        jPanelMenuPrincipal = new javax.swing.JPanel();
        jPanelAcciones = new javax.swing.JPanel();
        jButtonAutomoviles = new javax.swing.JButton();
        jButtonServicios = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Taller");
        setResizable(false);

        jLabelNombreDelNegocio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelNombreDelNegocio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombreDelNegocio.setText("TALLER");

        jButtonAutomoviles.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonAutomoviles.setText("Automoviles");
        jButtonAutomoviles.setName("Automoviles"); // NOI18N

        jButtonServicios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonServicios.setText("Servicios");
        jButtonServicios.setName("Servicios"); // NOI18N

        jButtonClientes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonClientes.setText("Clientes");
        jButtonClientes.setName("Clientes"); // NOI18N

        javax.swing.GroupLayout jPanelAccionesLayout = new javax.swing.GroupLayout(jPanelAcciones);
        jPanelAcciones.setLayout(jPanelAccionesLayout);
        jPanelAccionesLayout.setHorizontalGroup(
            jPanelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAutomoviles, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addComponent(jButtonServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAccionesLayout.setVerticalGroup(
            jPanelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccionesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAutomoviles, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelMenuPrincipalLayout = new javax.swing.GroupLayout(jPanelMenuPrincipal);
        jPanelMenuPrincipal.setLayout(jPanelMenuPrincipalLayout);
        jPanelMenuPrincipalLayout.setHorizontalGroup(
            jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuPrincipalLayout.createSequentialGroup()
                .addComponent(jPanelAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelMenuPrincipalLayout.setVerticalGroup(
            jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabelNombreDelNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelNombreDelNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //CLIENTES
    //---------------------------------------------------------------------------
//    public void agregarFiltro() {
//        jComboBoxFiltro.setModel(new DefaultComboBoxModel(Categoria.CLIENTE.getNombreDeCategorias()));
//    }
//
//    public String obtenerFiltroSeleccionado() {
//        return (String) this.jComboBoxFiltro.getSelectedItem();
//    }
//
//    public String obtenerBusqueda() {
//        return this.jTextFieldFiltrar.getText();
//    }

//    public Cliente getCliente() {
//        if (c == null) {
//            throw new RuntimeException("Debe seleccionar un cliente");
//        }
//        return c;
//    }

//    public void mostrarClientes(Collection<Cliente> clientes) {
//        for (Cliente emp : clientes) {
//            agregarFila(emp);
//        }
//    }

//    private void agregarFila(Cliente e) {
//        Object[] datos = {e.getIdCliente(), e.getDni(), e.getNombre(), e.getApellido(), e.getMail(), e.getTelefono()};
//        DefaultTableModel dtm = (DefaultTableModel) this.jTableClientes.getModel();
//        dtm.addRow(datos);
//    }



//    public void actualizarListaClientes(Collection<Cliente> clientes) {
//        vaciarClientes();
//        mostrarClientes(clientes);
//    }

//    private void habilitarODeshabiliarBotones(boolean b) {
//        jButtonEditar.setEnabled(b);
//        jButtonEliminar.setEnabled(b);
//    }

    //---------------------------------------------------------------------------
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public boolean confirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje) == 0;
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error...", JOptionPane.ERROR_MESSAGE);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAutomoviles;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonServicios;
    private javax.swing.JLabel jLabelNombreDelNegocio;
    private javax.swing.JPanel jPanelAcciones;
    private javax.swing.JPanel jPanelMenuPrincipal;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}
