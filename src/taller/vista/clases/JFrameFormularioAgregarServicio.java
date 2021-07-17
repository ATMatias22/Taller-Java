/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Color;
import java.awt.Component;
import java.util.Collection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import taller.modelo.clases.TipoSeccion;
import taller.modelo.clases.Servicio;

/**
 *
 * @author Matias
 */
public class JFrameFormularioAgregarServicio extends JFrameFormularioTemplate {

    private final static String NOMBRE_LOGO = TipoSeccion.SERVICIO.getNombreLogoMini();
    private final static String TITULO = "Agregar Servicio";
    private final static String TEXTO_BOTON = "Agregar Servicio";
    private final static Color COLOR_FONDO = new Color(0, 153, 0);
    private final static Color COLOR_TEXTO = new Color(255, 255, 255);
    private final static int HEIGHT_PANEL_FORMULARIO = 271;

    public JFrameFormularioAgregarServicio(Component parent, Collection<String> patentesAutomoviles) {
        super(NOMBRE_LOGO, TITULO, TEXTO_BOTON, parent, COLOR_FONDO, COLOR_TEXTO, HEIGHT_PANEL_FORMULARIO);
        iniciar(patentesAutomoviles);
    }

    private void iniciar(Collection<String> patentesAutomoviles) {
        jLabelFechaRealizacion = new javax.swing.JLabel();
        jLabelCosto = new javax.swing.JLabel();
        jTextFieldCosto = new javax.swing.JTextField();
        jLabelPatenteAuto = new javax.swing.JLabel();
        jLabelCantKMS = new javax.swing.JLabel();
        jTextFieldCantKMS = new javax.swing.JTextField();
        rSDateChooserFechaRealizacion = new newscomponents.RSDateChooser();
        jComboBoxPatenteAuto = new javax.swing.JComboBox<>();
        jButtonAgregar = new javax.swing.JButton();
        estilosFormulario();
        rSDateChooserFechaRealizacion.setFormatDate("dd-MM-YYYY");
        colocarPatenteAutomoviles(patentesAutomoviles);

    }

    private void estilosFormulario() {

        jLabelFechaRealizacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelFechaRealizacion.setText("<html><p>Fecha de</p> Realizacion</html>");

        jLabelCosto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCosto.setText("Costo");

        jTextFieldCosto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelPatenteAuto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPatenteAuto.setText("<html><p>Patente</p> del auto</html>");

        jLabelCantKMS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCantKMS.setText("<html><p>Cantidad</p> de kms</html>");

        jTextFieldCantKMS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        rSDateChooserFechaRealizacion.setBackground(new java.awt.Color(0, 0, 0));
        rSDateChooserFechaRealizacion.setBgColor(new java.awt.Color(0, 0, 0));
        rSDateChooserFechaRealizacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rSDateChooserFechaRealizacion.setFormatDate("d-M-YYYY");

        jComboBoxPatenteAuto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(super.getPanelFormulario());
        super.getPanelFormulario().setLayout(jPanelFormularioLayout);
        jPanelFormularioLayout.setHorizontalGroup(
                jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelPatenteAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelCosto)
                                        .addComponent(jLabelCantKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBoxPatenteAuto, javax.swing.GroupLayout.Alignment.LEADING, 0, 212, Short.MAX_VALUE)
                                        .addComponent(jTextFieldCosto, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rSDateChooserFechaRealizacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jTextFieldCantKMS))
                                .addGap(42, 42, 42))
        );
        jPanelFormularioLayout.setVerticalGroup(
                jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioLayout.createSequentialGroup()
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(rSDateChooserFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelCosto))
                                .addGap(17, 17, 17)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jComboBoxPatenteAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPatenteAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelFormularioLayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(jLabelCantKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jTextFieldCantKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jButtonAgregar.setBackground(new java.awt.Color(0, 153, 0));
        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setBorderPainted(false);
    }

    public Servicio getServicioAAgregar() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formatter.format(rSDateChooserFechaRealizacion.getDate());
        double costo = Double.parseDouble(jTextFieldCosto.getText());
        String patenteDelAuto = (String) this.jComboBoxPatenteAuto.getSelectedItem();
        int cantKms = Integer.parseInt(jTextFieldCantKMS.getText());
        return new Servicio(0, fecha, costo, patenteDelAuto, cantKms);
    }

    public void colocarPatenteAutomoviles(Collection<String> patentesAutomoviles) {
        String[] patentes = new String[patentesAutomoviles.size()];
        patentesAutomoviles.toArray(patentes);
        jComboBoxPatenteAuto.setModel(new javax.swing.DefaultComboBoxModel<>(patentes));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jPanelFormulario = new javax.swing.JPanel();
        jLabelFechaRealizacion = new javax.swing.JLabel();
        jLabelCosto = new javax.swing.JLabel();
        jTextFieldCosto = new javax.swing.JTextField();
        jLabelPatenteAuto = new javax.swing.JLabel();
        jLabelCantKMS = new javax.swing.JLabel();
        jTextFieldCantKMS = new javax.swing.JTextField();
        rSDateChooserFechaRealizacion = new newscomponents.RSDateChooser();
        jComboBoxPatenteAuto = new javax.swing.JComboBox<>();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Servicio");
        setResizable(false);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 204, 204));

        jPanelFormulario.setBackground(new java.awt.Color(255, 204, 204));
        jPanelFormulario.setPreferredSize(new java.awt.Dimension(800, 227));

        jLabelFechaRealizacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelFechaRealizacion.setText("<html><p>Fecha de</p> Realizacion</html>");

        jLabelCosto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCosto.setText("Costo");

        jTextFieldCosto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelPatenteAuto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPatenteAuto.setText("<html><p>Patente</p> del auto</html>");

        jLabelCantKMS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCantKMS.setText("<html><p>Cantidad</p> de kms</html>");

        jTextFieldCantKMS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        rSDateChooserFechaRealizacion.setBackground(new java.awt.Color(0, 0, 0));
        rSDateChooserFechaRealizacion.setBgColor(new java.awt.Color(0, 0, 0));
        rSDateChooserFechaRealizacion.setDate(null);
        rSDateChooserFechaRealizacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rSDateChooserFechaRealizacion.setFormatDate("dd-MM-YYYY");

        jComboBoxPatenteAuto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(jPanelFormulario);
        jPanelFormulario.setLayout(jPanelFormularioLayout);
        jPanelFormularioLayout.setHorizontalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPatenteAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCosto)
                    .addComponent(jLabelCantKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBoxPatenteAuto, javax.swing.GroupLayout.Alignment.LEADING, 0, 212, Short.MAX_VALUE)
                    .addComponent(jTextFieldCosto, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSDateChooserFechaRealizacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextFieldCantKMS))
                .addGap(42, 42, 42))
        );
        jPanelFormularioLayout.setVerticalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSDateChooserFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaRealizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCosto))
                .addGap(17, 17, 17)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxPatenteAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPatenteAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormularioLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabelCantKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jTextFieldCantKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelTitulo.setBackground(new java.awt.Color(0, 153, 0));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Agregar Servicio");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setOpaque(true);

        jButtonAgregar.setBackground(new java.awt.Color(0, 153, 0));
        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setBorderPainted(false);

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelFormulario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jButtonAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jButtonAgregar)
                .addContainerGap())
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
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JComboBox<String> jComboBoxPatenteAuto;
    private javax.swing.JLabel jLabelCantKMS;
    private javax.swing.JLabel jLabelCosto;
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
