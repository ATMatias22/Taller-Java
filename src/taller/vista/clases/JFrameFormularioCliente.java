/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import taller.helpers.Validaciones;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTextField;
import taller.modelo.clases.TipoSeccion;
import taller.modelo.clases.Cliente;

/**
 *
 * @author Matias
 */
public abstract  class JFrameFormularioCliente extends JFrameFormularioTemplate {

    private final static String NOMBRE_LOGO = TipoSeccion.CLIENTE.getNombreLogoMini();

    private JLabel jLabelApellido;
    private JLabel jLabelDNI;
    private JLabel jLabelMail;
    private JLabel jLabelNombre;
    private JLabel jLabelTelefono;
    private JTextField jTextFieldApellido;
    private JTextField jTextFieldDNI;
    private JTextField jTextFieldMail;
    private JTextField jTextFieldNombre;
    private JTextField jTextFieldTelefono;

    public JFrameFormularioCliente(Component parent, String titulo, String textoBoton, Color colorFondo, Color colorTexto, int altoPanel) {
        super(NOMBRE_LOGO, titulo, textoBoton, parent, colorFondo, colorTexto, altoPanel);
        iniciar();
    }

    private void iniciar() {
        jLabelDNI = new JLabel();
        jTextFieldDNI = new JTextField();
        jLabelNombre = new JLabel();
        jTextFieldNombre = new JTextField();
        jLabelApellido = new JLabel();
        jTextFieldApellido = new JTextField();
        jLabelMail = new JLabel();
        jTextFieldMail = new JTextField();
        jLabelTelefono = new JLabel();
        jTextFieldTelefono = new JTextField();
        estilosFormulario();
    }

    public JTextField getTextFieldDNI() {
        return jTextFieldDNI;
    }

    public JTextField getTextFieldNombre() {
        return jTextFieldNombre;
    }

    public JTextField getTextFieldApellido() {
        return jTextFieldApellido;
    }

    public JTextField getTextFieldMail() {
        return jTextFieldMail;
    }

    public JTextField getTextFieldTelefono() {
        return jTextFieldTelefono;
    }

    public Cliente getCliente() {
        validarCampos();
        String dni = jTextFieldDNI.getText();
        String nombre = jTextFieldNombre.getText();
        String apellido = jTextFieldApellido.getText();
        String mail = jTextFieldMail.getText();
        int telefono = Integer.parseInt(jTextFieldTelefono.getText());

        return new Cliente(0, dni, nombre, apellido, mail, telefono);
    }

    private void validarCampos() {
        if (Validaciones.estaVacio(jTextFieldDNI.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldDNI.getName() + "\" está vacío");
        }
        if (Validaciones.estaVacio(jTextFieldNombre.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldNombre.getName() + "\" está vacío");
        }
        if (Validaciones.estaVacio(jTextFieldApellido.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldApellido.getName() + "\" está vacío");
        }

        if (!Validaciones.esMailValido(jTextFieldMail.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldMail.getName() + "\" no es un mail valido");
        }
        if (!Validaciones.esNumeroEntero(jTextFieldTelefono.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldTelefono.getName() + "\" no es un numero");
        }
    }

    private void estilosFormulario() {
        jLabelDNI.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelDNI.setText("DNI");

        jTextFieldDNI.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldDNI.setName("DNI");

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelNombre.setText("Nombre");

        jTextFieldNombre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldNombre.setName("nombre");

        jLabelApellido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelApellido.setText("Apellido");

        jTextFieldApellido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldApellido.setName("apellido");

        jLabelMail.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMail.setText("Mail");

        jTextFieldMail.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldMail.setName("mail");

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTelefono.setText("Telefono");

        jTextFieldTelefono.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldTelefono.setName("telefono");

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(super.getPanelFormulario());
        super.getPanelFormulario().setLayout(jPanelFormularioLayout);
        jPanelFormularioLayout.setHorizontalGroup(
                jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelTelefono)
                                                        .addComponent(jLabelMail))
                                                .addComponent(jLabelApellido))
                                        .addComponent(jLabelDNI)
                                        .addComponent(jLabelNombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42))
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
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelApellido)
                                        .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelMail)
                                        .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTelefono)
                                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Cliente");
        setBackground(new java.awt.Color(51, 255, 51));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
