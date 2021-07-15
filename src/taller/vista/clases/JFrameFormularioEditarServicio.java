/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import taller.modelo.clases.Servicio;

/**
 *
 * @author Matias
 */
public class JFrameFormularioEditarServicio extends javax.swing.JFrame {

    private Servicio se;

    public JFrameFormularioEditarServicio(Servicio se, Component parent, ArrayList<String> patentesAutomoviles) {
        System.out.println("Hola");
        initComponents();
        this.se = se;
        setVisible(true);
        setLocationRelativeTo(parent);
        colocarServicioEnFormulario(patentesAutomoviles);
    }

    public void colocarServicioEnFormulario(ArrayList<String> patentesAutomoviles) {
        rSDateChooserFechaRealizacion.setDate(se.getFechaDeRealizacion());
        jTextFieldCosto.setText(se.getCosto() + "");
        colocarPatentesAutomoviles(patentesAutomoviles);
        jTextFieldCantKMS.setText(se.getCantKms() + "");
    }

    public void colocarPatentesAutomoviles(ArrayList<String> patentesAutomoviles) {
        String[] patentes = new String[patentesAutomoviles.size()];
        patentesAutomoviles.toArray(patentes);
        jComboBoxPatenteAuto.setModel(new javax.swing.DefaultComboBoxModel<>(patentes));
        jComboBoxPatenteAuto.setSelectedIndex(colocarPorDefectoLaPatenteEnComboBox(patentesAutomoviles, se.getPatenteDelAutomovil()));
    }

    public Servicio getServicioEditado() {
        int id = se.getIdServicio();
        Date fechaRealizacion =  rSDateChooserFechaRealizacion.getDate();
        double costo = Double.parseDouble(jTextFieldCosto.getText());
        String patenteDelAutomovil = (String) this.jComboBoxPatenteAuto.getSelectedItem();
        int cantKms = Integer.parseInt(jTextFieldCantKMS.getText());
        return new Servicio(id, fechaRealizacion, costo, patenteDelAutomovil, cantKms);
    }

    public int colocarPorDefectoLaPatenteEnComboBox(ArrayList<String> patentesAutomoviles, String dato) {
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < patentesAutomoviles.size() && !encontrado) {
            if (patentesAutomoviles.get(posicion).equalsIgnoreCase(dato)) {
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
        jLabelFechaRealizacion = new javax.swing.JLabel();
        jLabelCosto2 = new javax.swing.JLabel();
        jTextFieldCosto = new javax.swing.JTextField();
        jLabelPatenteAuto = new javax.swing.JLabel();
        jLabelCantKMS = new javax.swing.JLabel();
        jTextFieldCantKMS = new javax.swing.JTextField();
        rSDateChooserFechaRealizacion = new newscomponents.RSDateChooser();
        jComboBoxPatenteAuto = new javax.swing.JComboBox<>();
        jButtonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Servicio");
        setResizable(false);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 204, 204));

        jLabelTitulo.setBackground(new java.awt.Color(255, 204, 0));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(153, 102, 0));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Editar Servicio");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setOpaque(true);

        jPanelFormulario.setBackground(new java.awt.Color(255, 204, 204));
        jPanelFormulario.setPreferredSize(new java.awt.Dimension(800, 227));

        jLabelFechaRealizacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelFechaRealizacion.setText("Fecha de Realizacion");

        jLabelCosto2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCosto2.setText("Costo");

        jTextFieldCosto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelPatenteAuto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPatenteAuto.setText("Patente del auto");

        jLabelCantKMS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCantKMS.setText("Cantidad de kms");

        jTextFieldCantKMS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        rSDateChooserFechaRealizacion.setBackground(new java.awt.Color(0, 0, 0));
        rSDateChooserFechaRealizacion.setBgColor(new java.awt.Color(0, 0, 0));
        rSDateChooserFechaRealizacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rSDateChooserFechaRealizacion.setFormatDate("d-M-YYYY");

        jComboBoxPatenteAuto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(jPanelFormulario);
        jPanelFormulario.setLayout(jPanelFormularioLayout);
        jPanelFormularioLayout.setHorizontalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFechaRealizacion)
                    .addComponent(jLabelPatenteAuto)
                    .addComponent(jLabelCosto2)
                    .addComponent(jLabelCantKMS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSDateChooserFechaRealizacion, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(jTextFieldCosto)
                    .addComponent(jComboBoxPatenteAuto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCantKMS))
                .addGap(35, 35, 35))
        );
        jPanelFormularioLayout.setVerticalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSDateChooserFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaRealizacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCosto2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPatenteAuto)
                    .addComponent(jComboBoxPatenteAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCantKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCantKMS))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JComboBox<String> jComboBoxPatenteAuto;
    private javax.swing.JLabel jLabelCantKMS;
    private javax.swing.JLabel jLabelCosto2;
    private javax.swing.JLabel jLabelFechaRealizacion;
    private javax.swing.JLabel jLabelPatenteAuto;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelFormulario;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JTextField jTextFieldCantKMS;
    private javax.swing.JTextField jTextFieldCosto;
    private newscomponents.RSDateChooser rSDateChooserFechaRealizacion;
    // End of variables declaration//GEN-END:variables
}
