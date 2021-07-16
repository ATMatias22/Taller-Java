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
        jLabelFechaRealizacion.setText("<html><p>Fecha de</p> Realizacion</html>");

        jLabelCosto2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCosto2.setText("Costo");

        jTextFieldCosto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelPatenteAuto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPatenteAuto.setText("<html><p>Patente</p> del auto</html>");

        jLabelCantKMS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCantKMS.setText("<html><p>Cantidad</p>de kms</html>");

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
                .addGap(42, 42, 42)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPatenteAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCosto2)
                    .addComponent(jLabelCantKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSDateChooserFechaRealizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBoxPatenteAuto, 0, 212, Short.MAX_VALUE)
                        .addComponent(jTextFieldCantKMS, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                    .addComponent(jTextFieldCosto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        jPanelFormularioLayout.setVerticalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSDateChooserFechaRealizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCosto2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelPatenteAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPatenteAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelCantKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCantKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(222, 222, 222))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButtonEditar)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
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
