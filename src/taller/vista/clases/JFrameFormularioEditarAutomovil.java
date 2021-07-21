/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Color;
import java.awt.Component;
import java.util.Collection;
import taller.modelo.clases.Automovil;
import taller.modelo.clases.Marca;
import taller.modelo.clases.TipoSeccion;

/**
 *
 * @author Matias
 */
public class JFrameFormularioEditarAutomovil extends JFrameFormularioTemplate {

    private Automovil au;
    private final static String NOMBRE_LOGO = TipoSeccion.AUTOMOVIL.getNombreLogoMini();
    private final static String TITULO = "Editar Automovil";
    private final static String TEXTO_BOTON = "Editar Automovil";
    private final static Color COLOR_FONDO = new Color(255, 204, 0);
    private final static Color COLOR_TEXTO = new Color(153, 102, 0);
    private final static int HEIGHT_PANEL_FORMULARIO = 236;

//    private javax.swing.JComboBox<String> jComboBoxCliente;
//    private javax.swing.JComboBox<String> jComboBoxMarca;
//    private javax.swing.JComboBox<String> jComboBoxModelo;
//    private javax.swing.JLabel jLabelAnioFabricacion;
//    private javax.swing.JLabel jLabelCliente;
//    private javax.swing.JLabel jLabelMarca;
//    private javax.swing.JLabel jLabelModelo;
//    private javax.swing.JLabel jLabelPatente;
//    private javax.swing.JLabel jLabelTitulo;
//    private javax.swing.JTextField jTextFieldAnioFabricacion;
//    private javax.swing.JTextField jTextFieldPatente;

    public JFrameFormularioEditarAutomovil(Automovil au, Component parent, Collection<String> dniClientes) {
        super(NOMBRE_LOGO, TITULO, TEXTO_BOTON, parent, COLOR_FONDO, COLOR_TEXTO, HEIGHT_PANEL_FORMULARIO);
        this.au = au;
        iniciar(dniClientes);
    }

    private void iniciar(Collection<String> dniClientes) {
        jPanelPrincipal = new javax.swing.JPanel();
        jLabelPatente = new javax.swing.JLabel();
        jTextFieldPatente = new javax.swing.JTextField();
        jLabelMarca = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();
        jLabelAnioFabricacion = new javax.swing.JLabel();
        jTextFieldAnioFabricacion = new javax.swing.JTextField();
        jLabelCliente = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jComboBoxModelo = new javax.swing.JComboBox<>();
        estilosFormulario();
        colocarAutomovilEnFormulario(dniClientes);

    }

    private void colocarAutomovilEnFormulario(Collection<String> dniClientes) {
        jTextFieldPatente.setText(au.getPatente());
        colocarMarcasYPorDefectoLaMarcaDelAutomovilElegido();
        colocarModeloYPorDefectoElModeloDelAutomovilElegido();
        jTextFieldAnioFabricacion.setText(au.getAnioFabricacion() + "");
        colocarDNIClientesYColocarElDelClientePorDefecto(dniClientes);
    }

    private void colocarDNIClientesYColocarElDelClientePorDefecto(Collection<String> dniClientes) {
        String[] dni = new String[dniClientes.size()];
        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(dniClientes.toArray(dni)));
        jComboBoxCliente.setSelectedItem(au.getDniCliente());

    }

    public Automovil getAutomovilEditado() {
        validarCamposAutomovil();
        int id = au.getIdAutomovil();
        String patente = jTextFieldPatente.getText();
        String marca = (String) jComboBoxMarca.getSelectedItem();
        String modelo = (String) jComboBoxModelo.getSelectedItem();
        int anioFabricacion = Integer.parseInt(jTextFieldAnioFabricacion.getText());
        String cliente = (String) this.jComboBoxCliente.getSelectedItem();
        return new Automovil(id, patente, marca, modelo, anioFabricacion, cliente);
    }

    private void validarCamposAutomovil() {
        if (VALIDACIONES.estaVacio(jTextFieldPatente.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldPatente.getName() + "\" está vacío");
        }
        if (VALIDACIONES.estaVacio((String) jComboBoxMarca.getSelectedItem())) {
            throw new IllegalStateException("El campo \"" + jComboBoxMarca.getName() + "\" está vacío");
        }
        if (VALIDACIONES.estaVacio((String) jComboBoxModelo.getSelectedItem())) {
            throw new IllegalStateException("El campo \"" + jComboBoxModelo.getName() + "\" está vacío");
        }

        if (!VALIDACIONES.esNumeroEntero(jTextFieldAnioFabricacion.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldAnioFabricacion.getName() + "\" no es un numero valido");
        }
        if (VALIDACIONES.estaVacio((String) jComboBoxCliente.getSelectedItem())) {
            throw new IllegalStateException("El campo \"" + jComboBoxCliente.getName() + "\" esta vacio");
        }
    }

   

    private void colocarMarcasYPorDefectoLaMarcaDelAutomovilElegido() {
        Marca[] marcas = Marca.values();
        String[] categoriasAColocar = new String[marcas.length];
        for (int i = 0; i < categoriasAColocar.length; i++) {
            categoriasAColocar[i] = marcas[i].name();
        }
        jComboBoxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(categoriasAColocar));
        jComboBoxMarca.setSelectedItem(au.getMarca());
    }


    private void colocarModeloYPorDefectoElModeloDelAutomovilElegido() {
        String[] modelos = Marca.valueOf((String) jComboBoxMarca.getSelectedItem()).getNombreModelos();
        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(modelos));
        jComboBoxModelo.setSelectedItem(au.getModelo());
    }
 

    private void estilosFormulario() {

        jLabelPatente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPatente.setText("Patente");

        jTextFieldPatente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldPatente.setName("patente"); // NOI18N

        jLabelMarca.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMarca.setText("Marca");

        jLabelModelo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelModelo.setText("Modelo");
        jLabelModelo.setToolTipText("");

        jLabelAnioFabricacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelAnioFabricacion.setText("<html><p>Año de</p> fabricacion</html>");

        jTextFieldAnioFabricacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldAnioFabricacion.setName("año de fabricacion"); // NOI18N

        jLabelCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCliente.setText("DNI Cliente");

        jComboBoxCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboBoxCliente.setName("DNI cliente"); // NOI18N

        jComboBoxMarca.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboBoxMarca.setName("marca"); // NOI18N

        jComboBoxModelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBoxModelo.setName("modelo"); // NOI18N

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(super.getPanelFormulario());
        super.getPanelFormulario().setLayout(jPanelFormularioLayout);
        jPanelFormularioLayout.setHorizontalGroup(
                jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelCliente)
                                                        .addComponent(jLabelAnioFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabelModelo))
                                        .addComponent(jLabelPatente)
                                        .addComponent(jLabelMarca))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxCliente, 0, 212, Short.MAX_VALUE)
                                        .addComponent(jTextFieldAnioFabricacion, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                        .addComponent(jTextFieldPatente, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                        .addComponent(jComboBoxMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(73, 73, 73))
        );
        jPanelFormularioLayout.setVerticalGroup(
                jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPatente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelMarca)
                                        .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelModelo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelAnioFabricacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldAnioFabricacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCliente)
                                        .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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
        jLabelModelo = new javax.swing.JLabel();
        jLabelAnioFabricacion = new javax.swing.JLabel();
        jTextFieldAnioFabricacion = new javax.swing.JTextField();
        jLabelCliente = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jComboBoxModelo = new javax.swing.JComboBox<>();

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
        jTextFieldPatente.setName("patente"); // NOI18N

        jLabelMarca.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMarca.setText("Marca");

        jLabelModelo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelModelo.setText("Modelo");
        jLabelModelo.setToolTipText("");

        jLabelAnioFabricacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelAnioFabricacion.setText("<html><p>Año de</p> fabricacion</html>");

        jTextFieldAnioFabricacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldAnioFabricacion.setName("año de fabricacion"); // NOI18N

        jLabelCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCliente.setText("DNI Cliente");

        jComboBoxCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboBoxCliente.setName("DNI cliente"); // NOI18N

        jComboBoxMarca.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboBoxMarca.setName("marca"); // NOI18N

        jComboBoxModelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBoxModelo.setName("modelo"); // NOI18N

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(jPanelFormulario);
        jPanelFormulario.setLayout(jPanelFormularioLayout);
        jPanelFormularioLayout.setHorizontalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCliente)
                            .addComponent(jLabelAnioFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelModelo))
                    .addComponent(jLabelPatente)
                    .addComponent(jLabelMarca))
                .addGap(18, 18, 18)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxCliente, 0, 212, Short.MAX_VALUE)
                    .addComponent(jTextFieldAnioFabricacion, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(jTextFieldPatente, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(jComboBoxMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73))
        );
        jPanelFormularioLayout.setVerticalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPatente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelMarca)
                    .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAnioFabricacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAnioFabricacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCliente)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxMarca;
    private javax.swing.JComboBox<String> jComboBoxModelo;
    private javax.swing.JLabel jLabelAnioFabricacion;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelPatente;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelFormulario;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JTextField jTextFieldAnioFabricacion;
    private javax.swing.JTextField jTextFieldPatente;
    // End of variables declaration//GEN-END:variables
}
