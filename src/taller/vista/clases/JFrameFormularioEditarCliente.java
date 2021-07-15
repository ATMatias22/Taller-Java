/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import taller.modelo.clases.Cliente;

/**
 *
 * @author Matias
 */
public class JFrameFormularioEditarCliente extends javax.swing.JFrame {
 private Cliente cl;

    public JFrameFormularioEditarCliente(Cliente cl, Component parent) {
        initComponents();
        this.cl = cl;
        setVisible(true);
        setLocationRelativeTo(parent);
        colocarClienteEnFormulario();
        
    } 

     public void colocarClienteEnFormulario() {
        jTextFieldDNI.setText(cl.getDni());
        jTextFieldNombre.setText(cl.getNombre());
        jTextFieldApellido.setText(cl.getApellido());
        jTextFieldMail.setText(cl.getMail());
        jTextFieldTelefono.setText(cl.getTelefono() + "");
    }
     
      public Cliente getClienteEditado() {
        int id = cl.getIdCliente();
        String dni = jTextFieldDNI.getText();
        String nombre = jTextFieldNombre.getText();
        String apellido = jTextFieldApellido.getText();
        String mail = jTextFieldMail.getText();
        int telefono = Integer.parseInt(jTextFieldTelefono.getText());
        return new Cliente(id, dni, nombre, apellido, mail, telefono);
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
        jLabelDNI = new javax.swing.JLabel();
        jTextFieldDNI = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelApellido = new javax.swing.JLabel();
        jTextFieldApellido = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        jTextFieldMail = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jButtonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Cliente");
        setBackground(new java.awt.Color(51, 255, 51));
        setResizable(false);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 204, 204));
        jPanelPrincipal.setForeground(new java.awt.Color(102, 102, 102));

        jLabelTitulo.setBackground(new java.awt.Color(255, 204, 0));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(153, 102, 0));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Editar Cliente");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setOpaque(true);

        jPanelFormulario.setBackground(new java.awt.Color(255, 204, 204));
        jPanelFormulario.setForeground(new java.awt.Color(255, 255, 255));
        jPanelFormulario.setPreferredSize(new java.awt.Dimension(800, 227));

        jLabelDNI.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelDNI.setText("DNI");

        jTextFieldDNI.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelNombre.setText("Nombre");

        jTextFieldNombre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelApellido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelApellido.setText("Apellido");

        jTextFieldApellido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelMail.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMail.setText("Mail");

        jTextFieldMail.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTelefono.setText("Telefono");

        jTextFieldTelefono.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

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
                                    .addComponent(jLabelTelefono)
                                    .addComponent(jLabelMail))
                                .addGap(60, 60, 60))
                            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                                .addComponent(jLabelApellido)
                                .addGap(68, 68, 68)))
                        .addGroup(jPanelFormularioLayout.createSequentialGroup()
                            .addComponent(jLabelNombre)
                            .addGap(68, 68, 68)))
                    .addGroup(jPanelFormularioLayout.createSequentialGroup()
                        .addComponent(jLabelDNI)
                        .addGap(115, 115, 115)))
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanelFormularioLayout.setVerticalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellido)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMail)
                    .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelFormulario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButtonEditar)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelFormulario;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
