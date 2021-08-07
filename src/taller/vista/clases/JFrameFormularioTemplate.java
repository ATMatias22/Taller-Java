/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Matias
 */
public abstract class JFrameFormularioTemplate extends javax.swing.JFrame {

    private final static String PATH_RECURSOS = "/taller/vista/recursos/";
    private final static int WIDTH_JFRAME = 457;
    private final static int HEIGHT_JFRAME = 210;

    public JFrameFormularioTemplate(String logo, String titulo, String textButton, Component parent, Color colorFondoButtonYTitulo, Color colorTextoButtonYTitulo, int heightPanelFormulario) {
        initComponents();
        iniciar(logo, titulo, textButton, colorFondoButtonYTitulo, colorTextoButtonYTitulo, heightPanelFormulario);
        setVisible(true);
        setLocationRelativeTo(parent);
    }

    public JPanel getPanelFormulario() {
        return jPanelFormulario;
    }
    
 
    private void iniciar(String logo, String titulo, String textButton, Color colorFondoButtonYTitulo, Color colorTextoButtonYTitulo, int heightPanelFormulario) {
        aumentarTamanioJFrameSegunElFormulario(heightPanelFormulario);
        colocarLogo(logo);
        colocarTitulos(titulo);
        colocarTextoButton(textButton);
        colocarColorFondoYTexto(colorFondoButtonYTitulo, colorTextoButtonYTitulo);
    }

    private void aumentarTamanioJFrameSegunElFormulario(int heightPanelFormulario) {
        this.setSize(WIDTH_JFRAME, heightPanelFormulario + HEIGHT_JFRAME);
    }

    private void colocarTitulos(String titulo) {
        this.setTitle(titulo);
        this.jLabelTitulo.setText(titulo);
        this.jLabelTitulo.setBackground(new Color(0, 153, 0));
    }

    private void colocarColorFondoYTexto(Color colorFondo, Color colorTexto) {
        jButtonAccion.setBackground(colorFondo);
        jLabelTitulo.setBackground(colorFondo);
        jButtonAccion.setForeground(colorTexto);
        jLabelTitulo.setForeground(colorTexto);
    }

    private void colocarLogo(String logo) {
        jLabelLogo.setIcon(getImagen(logo));
    }

    private void colocarTextoButton(String textButton) {
        jButtonAccion.setText(textButton);
    }

    private ImageIcon getImagen(String nombreImagen) {
        ImageIcon img = null;
        try {
            img = new ImageIcon(getURL(PATH_RECURSOS + nombreImagen));
        } catch (Exception e) {
            mostrarMensajeError("No se pudo cargar recurso " + nombreImagen + ": " + e.getMessage());
        }
        return img;
    }

    private URL getURL(String ruta) {
        URL u = getClass().getResource(ruta);
        if (u == null) {
            throw new RuntimeException("No se pudo cargar recurso " + ruta);
        }
        return u;
    }

    public boolean confirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje) == 0;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
        cerrar();
    }

    public void cerrar() {
        this.dispose();
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error...", JOptionPane.ERROR_MESSAGE);
    }

    public void addActionListenerAccionBoton(ActionListener al) {
        this.jButtonAccion.addActionListener(al);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jPanelFormulario = new javax.swing.JPanel();
        jButtonAccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 204, 204));

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Titulo");
        jLabelTitulo.setOpaque(true);

        jPanelFormulario.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(jPanelFormulario);
        jPanelFormulario.setLayout(jPanelFormularioLayout);
        jPanelFormularioLayout.setHorizontalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        jPanelFormularioLayout.setVerticalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButtonAccion.setBackground(new java.awt.Color(0, 153, 0));
        jButtonAccion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonAccion.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAccion.setText("Agregar Automoviles");
        jButtonAccion.setBorderPainted(false);
        jButtonAccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButtonAccion)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccion;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelFormulario;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}
