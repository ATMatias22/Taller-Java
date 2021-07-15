/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import taller.modelo.clases.Automovil;
import taller.modelo.clases.Cliente;

/**
 *
 * @author Matias
 */
public class JFrameFormularioAgregarAutomovil extends javax.swing.JFrame {

    private final int WIDTH_JFRAME = 689;
    private final int HEIGHT_JFRAME_MIN = 480;
    private final int HEIGHT_JFRAME_MAX = 750;

    public JFrameFormularioAgregarAutomovil(Component parent, ArrayList<String> dniClientes) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(parent);
        iniciar(dniClientes);

    }

    public void iniciar(ArrayList<String> dniClientes) {
        colocarDNIClientes(dniClientes);
        this.jCheckBoxHabilitarCliente.addActionListener(new MostrarFormularioCliente());
        jPanelFormularioAgregarCliente.setVisible(false);

    }

    public void colocarDNIClientes(ArrayList<String> dniClientes) {
        String[] dni = new String[dniClientes.size()];
        dniClientes.toArray(dni);
        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(dni));
    }

    public Automovil getAutomovilAAgregar() {
        String patente = jTextFieldPatente.getText();
        String marca = jTextFieldMarca.getText();
        String modelo = jTextFieldModelo.getText();
        int anioFabricacion = Integer.parseInt(jTextFieldAnioFabricacion.getText());
        String dniCliente = (String) this.jComboBoxCliente.getSelectedItem();
        return new Automovil(0, patente, marca, modelo, anioFabricacion, dniCliente);
    }

    public Cliente getClienteAAgregar() {
        String dni = jTextFieldDNICliente.getText();
        String nombre = jTextFieldNombreCliente.getText();
        String apellido = jTextFieldApellidoCliente.getText();
        String mail = jTextFieldMailCliente.getText();
        int telefono = Integer.parseInt(jTextFieldTelefonoCliente.getText());
        return new Cliente(0, dni, nombre, apellido, mail, telefono);
    }

    public Automovil getAutomovilAAgregar(String dni) {
        String patente = jTextFieldPatente.getText();
        String marca = jTextFieldMarca.getText();
        String modelo = jTextFieldModelo.getText();
        int anioFabricacion = Integer.parseInt(jTextFieldAnioFabricacion.getText());
        String dniCliente = dni;
        return new Automovil(0, patente, marca, modelo, anioFabricacion, dniCliente);
    }

    public void addActionListenerBotonAgregar(ActionListener al) {
        this.jButtonAgregar.addActionListener(al);
    }

    public void tamanioVentana(int height, boolean b) {
        this.setSize(WIDTH_JFRAME, height);
        jLabelCliente.setVisible(b);
        jComboBoxCliente.setVisible(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
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
        jCheckBoxHabilitarCliente = new javax.swing.JCheckBox();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();
        jPanelFormularioAgregarCliente = new javax.swing.JPanel();
        jLabelTituloCliente = new javax.swing.JLabel();
        jPanelFormularioCliente = new javax.swing.JPanel();
        jLabelDNICliente = new javax.swing.JLabel();
        jLabelNombreCliente = new javax.swing.JLabel();
        jLabelApellidoCliente = new javax.swing.JLabel();
        jLabelMailCliente = new javax.swing.JLabel();
        jLabelTelefonoCliente = new javax.swing.JLabel();
        jTextFieldTelefonoCliente = new javax.swing.JTextField();
        jTextFieldMailCliente = new javax.swing.JTextField();
        jTextFieldApellidoCliente = new javax.swing.JTextField();
        jTextFieldNombreCliente = new javax.swing.JTextField();
        jTextFieldDNICliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Automovil");
        setPreferredSize(new java.awt.Dimension(689, 480));
        setResizable(false);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 204, 204));

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
                .addGap(28, 28, 28)
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
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAnioFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanelFormularioLayout.setVerticalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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

        jCheckBoxHabilitarCliente.setBackground(new java.awt.Color(255, 204, 204));
        jCheckBoxHabilitarCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jCheckBoxHabilitarCliente.setText("En caso de no tener el dni del cliente");

        jLabelTitulo.setBackground(new java.awt.Color(0, 153, 0));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Agregar Automovil");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setOpaque(true);

        jButtonAgregar.setBackground(new java.awt.Color(0, 153, 0));
        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setBorderPainted(false);

        jPanelFormularioAgregarCliente.setBackground(new java.awt.Color(255, 204, 204));

        jLabelTituloCliente.setBackground(new java.awt.Color(0, 153, 0));
        jLabelTituloCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTituloCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloCliente.setText("Agregar Cliente");
        jLabelTituloCliente.setOpaque(true);

        jPanelFormularioCliente.setBackground(new java.awt.Color(255, 204, 204));

        jLabelDNICliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelDNICliente.setText("DNI");

        jLabelNombreCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelNombreCliente.setText("Nombre");

        jLabelApellidoCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelApellidoCliente.setText("Apellido");

        jLabelMailCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMailCliente.setText("Mail");

        jLabelTelefonoCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTelefonoCliente.setText("Telefono");

        jTextFieldTelefonoCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jTextFieldMailCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jTextFieldApellidoCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jTextFieldNombreCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jTextFieldDNICliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanelFormularioClienteLayout = new javax.swing.GroupLayout(jPanelFormularioCliente);
        jPanelFormularioCliente.setLayout(jPanelFormularioClienteLayout);
        jPanelFormularioClienteLayout.setHorizontalGroup(
            jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioClienteLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormularioClienteLayout.createSequentialGroup()
                        .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMailCliente)
                            .addComponent(jLabelTelefonoCliente))
                        .addGap(178, 178, 178)
                        .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMailCliente)
                            .addComponent(jTextFieldTelefonoCliente)))
                    .addGroup(jPanelFormularioClienteLayout.createSequentialGroup()
                        .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDNICliente)
                            .addComponent(jLabelNombreCliente)
                            .addComponent(jLabelApellidoCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDNICliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldApellidoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        jPanelFormularioClienteLayout.setVerticalGroup(
            jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioClienteLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDNICliente)
                    .addComponent(jTextFieldDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreCliente)
                    .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidoCliente)
                    .addComponent(jTextFieldApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMailCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefonoCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelFormularioAgregarClienteLayout = new javax.swing.GroupLayout(jPanelFormularioAgregarCliente);
        jPanelFormularioAgregarCliente.setLayout(jPanelFormularioAgregarClienteLayout);
        jPanelFormularioAgregarClienteLayout.setHorizontalGroup(
            jPanelFormularioAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTituloCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelFormularioCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelFormularioAgregarClienteLayout.setVerticalGroup(
            jPanelFormularioAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioAgregarClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTituloCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFormularioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanelFormularioAgregarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jCheckBoxHabilitarCliente))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxHabilitarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFormularioAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAgregar)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    public boolean conCliente() {
        return jCheckBoxHabilitarCliente.isSelected();
    }

    //758 500
    private class MostrarFormularioCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (conCliente()) {
                jPanelFormularioAgregarCliente.setVisible(true);
                tamanioVentana(HEIGHT_JFRAME_MAX, false);
            } else {
                jPanelFormularioAgregarCliente.setVisible(false);
                tamanioVentana(HEIGHT_JFRAME_MIN, true);
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JCheckBox jCheckBoxHabilitarCliente;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JLabel jLabelAnioFabricacion;
    private javax.swing.JLabel jLabelApellidoCliente;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelDNICliente;
    private javax.swing.JLabel jLabelMailCliente;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelNombreCliente;
    private javax.swing.JLabel jLabelPatente;
    private javax.swing.JLabel jLabelTelefonoCliente;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTituloCliente;
    private javax.swing.JPanel jPanelFormulario;
    private javax.swing.JPanel jPanelFormularioAgregarCliente;
    private javax.swing.JPanel jPanelFormularioCliente;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JTextField jTextFieldAnioFabricacion;
    private javax.swing.JTextField jTextFieldApellidoCliente;
    private javax.swing.JTextField jTextFieldDNICliente;
    private javax.swing.JTextField jTextFieldMailCliente;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldPatente;
    private javax.swing.JTextField jTextFieldTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
