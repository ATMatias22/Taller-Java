/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import taller.modelo.clases.Automovil;

/**
 *
 * @author Matias
 */
public class JFrameFormularioEditarAutomovil extends javax.swing.JFrame {

    private Automovil au;

    public JFrameFormularioEditarAutomovil(Automovil au, Component parent, ArrayList<String> dniClientes) {
        System.out.println("Hola");
        initComponents();
        this.au = au;
        setVisible(true);
        setLocationRelativeTo(parent);
        colocarAutomovilEnFormulario(dniClientes);
    }

    public void colocarAutomovilEnFormulario(ArrayList<String> dniClientes) {
        jTextFieldPatente.setText(au.getPatente());
        jTextFieldMarca.setText(au.getMarca());
        jTextFieldModelo.setText(au.getModelo());
        jTextFieldAnioFabricacion.setText(au.getAnioFabricacion() + "");
        colocarDNIClientes(dniClientes);
    }

    public void colocarDNIClientes(ArrayList<String> dniClientes) {
        String[] dni = new String[dniClientes.size()];
        dniClientes.toArray(dni);
        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(dni));
        jComboBoxCliente.setSelectedIndex(colocarPorDefectoElClienteEnComboBox(dniClientes, au.getDniCliente() ));
    }

    public Automovil getAutomovilEditado() {
        int id = au.getIdAutomovil();
        String patente = jTextFieldPatente.getText();
        String marca = jTextFieldMarca.getText();
        String modelo = jTextFieldModelo.getText();
        int anioFabricacion = Integer.parseInt(jTextFieldAnioFabricacion.getText());
        String cliente = (String) this.jComboBoxCliente.getSelectedItem();
        return new Automovil(id, patente, marca, modelo, anioFabricacion, cliente);
    }
    
    public int colocarPorDefectoElClienteEnComboBox(ArrayList<String> dniClientes, String dato){
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < dniClientes.size() && !encontrado) {            
            if(dniClientes.get(posicion).equalsIgnoreCase(dato)){
                encontrado = true;
            }
            posicion++;
        }
        return --posicion;
    }

    public void addActionListenerBotonEditar(ActionListener al) {
        this.jButtonEditar.addActionListener(al);
    }

    public boolean confirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje) == 0;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
        this.dispose();
    }
    
     public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error...", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelFormulario = new javax.swing.JPanel();
        jLabelPatente = new javax.swing.JLabel();
        jTextFieldPatente = new javax.swing.JTextField();
        jLabelMarca = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jLabelModelo = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jLabelAnioFabricacion = new javax.swing.JLabel();
        jTextFieldAnioFabricacion = new javax.swing.JTextField();
        jLabelCliente = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jButtonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Automovil");
        setResizable(false);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 204, 204));

        jLabelTitulo.setBackground(new java.awt.Color(255, 204, 0));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(153, 102, 0));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Editar Automovil");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setOpaque(true);

        jPanelFormulario.setBackground(new java.awt.Color(255, 204, 204));
        jPanelFormulario.setPreferredSize(new java.awt.Dimension(800, 227));

        jLabelPatente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPatente.setText("Patente");

        jTextFieldPatente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelMarca.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMarca.setText("Marca");

        jTextFieldMarca.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelModelo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelModelo.setText("Modelo");
        jLabelModelo.setToolTipText("");

        jTextFieldModelo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelAnioFabricacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelAnioFabricacion.setText("Año de fabricacion");

        jTextFieldAnioFabricacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCliente.setText("DNI Cliente");

        jComboBoxCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(jPanelFormulario);
        jPanelFormulario.setLayout(jPanelFormularioLayout);
        jPanelFormularioLayout.setHorizontalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCliente)
                                    .addComponent(jLabelAnioFabricacion))
                                .addGap(60, 60, 60))
                            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                                .addComponent(jLabelModelo)
                                .addGap(68, 68, 68)))
                        .addGroup(jPanelFormularioLayout.createSequentialGroup()
                            .addComponent(jLabelMarca)
                            .addGap(68, 68, 68)))
                    .addGroup(jPanelFormularioLayout.createSequentialGroup()
                        .addComponent(jLabelPatente)
                        .addGap(115, 115, 115)))
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldAnioFabricacion)
                    .addComponent(jTextFieldModelo)
                    .addComponent(jTextFieldMarca)
                    .addComponent(jTextFieldPatente)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanelFormularioLayout.setVerticalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPatente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMarca)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModelo)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAnioFabricacion)
                    .addComponent(jTextFieldAnioFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCliente)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButtonEditar.setBackground(new java.awt.Color(255, 204, 0));
        jButtonEditar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(153, 102, 0));
        jButtonEditar.setText("Editar");
        jButtonEditar.setBorderPainted(false);

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonEditar)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JLabel jLabelAnioFabricacion;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelPatente;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelFormulario;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JTextField jTextFieldAnioFabricacion;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldPatente;
    // End of variables declaration//GEN-END:variables
}
