/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import taller.helpers.Validaciones;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import taller.helpers.CollectionToArray;
import taller.modelo.clases.Servicio;
import taller.modelo.clases.TipoSeccion;

/**
 *
 * @author Matias
 */
public class JFrameFormularioServicio extends JFrameFormularioTemplate {

    private final static String NOMBRE_LOGO = TipoSeccion.SERVICIO.getNombreLogoMini();

    private javax.swing.JComboBox<String> jComboBoxPatenteAuto;
    private com.toedter.calendar.JDateChooser jDateChooserFechaRealizacion;
    private javax.swing.JLabel jLabelCantKMS;
    private javax.swing.JLabel jLabelCosto;
    private javax.swing.JLabel jLabelFechaRealizacion;
    private javax.swing.JLabel jLabelPatenteAuto;
    private javax.swing.JTextField jTextFieldCantKMS;
    private javax.swing.JTextField jTextFieldCosto;

    public JFrameFormularioServicio(Component parent, Collection<String> patentesAutomoviles, String titulo, String textoBoton, Color colorFondo, Color colorTexto, int altoFormulario) {
        super(NOMBRE_LOGO, titulo, textoBoton, parent, colorFondo, colorTexto, altoFormulario);
        iniciar(patentesAutomoviles);
    }

    private void iniciar(Collection<String> patentesAutomoviles) {

        jLabelFechaRealizacion = new javax.swing.JLabel();
        jLabelCosto = new javax.swing.JLabel();
        jTextFieldCosto = new javax.swing.JTextField();
        jLabelPatenteAuto = new javax.swing.JLabel();
        jLabelCantKMS = new javax.swing.JLabel();
        jTextFieldCantKMS = new javax.swing.JTextField();
        jDateChooserFechaRealizacion = new com.toedter.calendar.JDateChooser(null, null, null, new JSpinnerDateEditor());
        jComboBoxPatenteAuto = new javax.swing.JComboBox<>();
        estilosFormulario();
        colocarPatentesAutomoviles(patentesAutomoviles);

    }

    private void validarCampos() {

        if (!Validaciones.esFecha(jDateChooserFechaRealizacion.getDate())) {
            throw new IllegalStateException("El campo \" " + jDateChooserFechaRealizacion.getName() + " \" está vacío");
        }
        if (!Validaciones.esNumeroDouble(jTextFieldCosto.getText())) {
            throw new IllegalStateException("El campo " + jTextFieldCosto.getName() + " no es un numero valido");
        }
        if (Validaciones.esNull(jComboBoxPatenteAuto.getSelectedItem())) {
            throw new IllegalStateException("El campo " + jComboBoxPatenteAuto.getName() + " está vacío");
        }
        if (!Validaciones.esNumeroEntero(jTextFieldCantKMS.getText())) {
            throw new IllegalStateException("El campo " + jTextFieldCantKMS.getName() + " no es un numero valido");
        }

    }

    private void colocarPatentesAutomoviles(Collection<String> patentesAutomoviles) {
        jComboBoxPatenteAuto.setModel(new javax.swing.DefaultComboBoxModel<>(CollectionToArray.conversionCollectionString(patentesAutomoviles)));
    }

    public Servicio getServicio() {
        validarCampos();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        String fechaRealizacion = formato.format(jDateChooserFechaRealizacion.getDate());
        double costo = Double.parseDouble(jTextFieldCosto.getText());
        String patenteDelAutomovil = (String) this.jComboBoxPatenteAuto.getSelectedItem();
        int cantKms = Integer.parseInt(jTextFieldCantKMS.getText());
        return new Servicio(0, fechaRealizacion, costo, patenteDelAutomovil, cantKms);
    }

    public void setearFecha(String fecha) {
        DateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = sourceFormat.parse(fecha);
            jDateChooserFechaRealizacion.setDate(date);
        } catch (java.text.ParseException e) {
            System.out.println(e);
        }

    }

    public JComboBox getComboBoxPatentes() {
        return jComboBoxPatenteAuto;
    }

    public JTextField getTextFieldCosto() {
        return jTextFieldCosto;
    }

    public JTextField getTextFieldKms() {
        return jTextFieldCantKMS;
    }

    private void estilosFormulario() {
        jLabelFechaRealizacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelFechaRealizacion.setText("<html><p>Fecha de</p> Realizacion</html>");

        jLabelCosto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCosto.setText("Costo");

        jTextFieldCosto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldCosto.setName("costo");

        jLabelPatenteAuto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPatenteAuto.setText("<html><p>Patente</p> del auto</html>");

        jLabelCantKMS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCantKMS.setText("<html><p>Cantidad</p>de kms</html>");

        jTextFieldCantKMS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldCantKMS.setName("Cantidad de kilometros");

        jComboBoxPatenteAuto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboBoxPatenteAuto.setName("patente del automovil");

        jDateChooserFechaRealizacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jDateChooserFechaRealizacion.setName("fecha de realizacion");
        jDateChooserFechaRealizacion.getJCalendar().setWeekOfYearVisible(false);
        jDateChooserFechaRealizacion.getJCalendar().setTodayButtonVisible(true);
        jDateChooserFechaRealizacion.getJCalendar().setTodayButtonText("Hoy Día");
        jDateChooserFechaRealizacion.getJCalendar().setMaxDayCharacters(2);

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(super.getPanelFormulario());
        super.getPanelFormulario().setLayout(jPanelFormularioLayout);
        jPanelFormularioLayout.setHorizontalGroup(
                jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPatenteAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelCosto)
                                        .addComponent(jLabelCantKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jComboBoxPatenteAuto, 0, 212, Short.MAX_VALUE)
                                                .addComponent(jTextFieldCantKMS, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                                        .addComponent(jTextFieldCosto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateChooserFechaRealizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42))
        );
        jPanelFormularioLayout.setVerticalGroup(
                jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioLayout.createSequentialGroup()
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateChooserFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelCosto))
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Servicio");
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
