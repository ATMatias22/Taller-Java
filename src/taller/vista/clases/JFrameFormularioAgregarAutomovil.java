/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pkgfinal.CollectionToArray;
import taller.modelo.clases.Automovil;
import taller.modelo.clases.TipoSeccion;
import taller.modelo.clases.Cliente;
import taller.modelo.clases.Marca;

/**
 *
 * @author Matias
 */
public class JFrameFormularioAgregarAutomovil extends JFrameFormularioTemplate {

    private final static int WIDTH_JFRAME = 457;
    private final static int HEIGHT_JFRAME_MIN = 470;
    private final static int HEIGHT_JFRAME_MAX = 794;
    private final static int HEIGHT_PANEL_FORMULARIO = 470;
    private final static String NOMBRE_LOGO = TipoSeccion.AUTOMOVIL.getNombreLogoMini();
    private final static String TITULO = "Agregar Automovil";
    private final static String TEXTO_BOTON = "Agregar Automovil";
    private final static Color COLOR_FONDO = new Color(0, 153, 0);
    private final static Color COLOR_TEXTO = new Color(255, 255, 255);
    
    private JCheckBox jCheckBoxHabilitarCliente;
    private JComboBox<String> jComboBoxCliente;
    private JComboBox<String> jComboBoxMarca;
    private JComboBox<String> jComboBoxModelo;
    private JLabel jLabelAnioFabricacion;
    private JLabel jLabelApellidoCliente;
    private JLabel jLabelCliente;
    private JLabel jLabelDNICliente;
    private JLabel jLabelMailCliente;
    private JLabel jLabelMarca;
    private JLabel jLabelModelo;
    private JLabel jLabelNombreCliente;
    private JLabel jLabelPatente;
    private JLabel jLabelTelefonoCliente;
    private JLabel jLabelTituloCliente;
    private JPanel jPanelFormularioAgregarAutomovil;
    private JPanel jPanelFormularioAgregarCliente;
    private JPanel jPanelFormularioCliente;
    private JTextField jTextFieldAnioFabricacion;
    private JTextField jTextFieldApellidoCliente;
    private JTextField jTextFieldDNICliente;
    private JTextField jTextFieldMailCliente;
    private JTextField jTextFieldNombreCliente;
    private JTextField jTextFieldPatente;
    private JTextField jTextFieldTelefonoCliente;

    public JFrameFormularioAgregarAutomovil(Component parent, Collection<String> dniClientes) {
        super(NOMBRE_LOGO, TITULO, TEXTO_BOTON, parent, COLOR_FONDO, COLOR_TEXTO, HEIGHT_PANEL_FORMULARIO);
        iniciar(parent, dniClientes);
    }

    private void iniciar(Component parent, Collection<String> dniClientes) {
        jPanelFormularioAgregarAutomovil = new JPanel();
        jLabelPatente = new JLabel();
        jTextFieldPatente = new JTextField();
        jLabelMarca = new JLabel();
        jLabelModelo = new JLabel();
        jLabelAnioFabricacion = new JLabel();
        jLabelCliente = new JLabel();
        jComboBoxCliente = new JComboBox<>();
        jTextFieldAnioFabricacion = new JTextField();
        jCheckBoxHabilitarCliente = new JCheckBox();
        jComboBoxMarca = new JComboBox<>();
        jComboBoxModelo = new JComboBox<>();
        jPanelFormularioAgregarCliente = new JPanel();
        jLabelTituloCliente = new JLabel();
        jPanelFormularioCliente = new JPanel();
        jLabelDNICliente = new JLabel();
        jLabelNombreCliente = new JLabel();
        jLabelApellidoCliente = new JLabel();
        jLabelMailCliente = new JLabel();
        jLabelTelefonoCliente = new JLabel();
        jTextFieldTelefonoCliente = new JTextField();
        jTextFieldMailCliente = new JTextField();
        jTextFieldApellidoCliente = new JTextField();
        jTextFieldNombreCliente = new JTextField();
        jTextFieldDNICliente = new JTextField();

        tamanioVentana(HEIGHT_JFRAME_MIN, true);
        setLocationRelativeTo(parent);
        estilosFormulario();
        colocarDNIClientes(dniClientes);
        colocarMarcas();
        colocarModeloSegunMarca();
        this.jCheckBoxHabilitarCliente.addActionListener(new MostrarFormularioCliente());
        this.jComboBoxMarca.addActionListener(new CambiarModelosSegunMarca());

    }

    private void colocarDNIClientes(Collection<String> dniClientes) {
        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(CollectionToArray.conversionCollectionString(dniClientes)));
    }

    public Automovil getAutomovilAAgregar() {
        validarCamposAutomovilConDni();
        String patente = jTextFieldPatente.getText();
        String marca = (String) jComboBoxMarca.getSelectedItem();
        String modelo = (String) jComboBoxModelo.getSelectedItem();
        int anioFabricacion = Integer.parseInt(jTextFieldAnioFabricacion.getText());
        String dniCliente = (String) this.jComboBoxCliente.getSelectedItem();
        return new Automovil(0, patente, marca, modelo, anioFabricacion, dniCliente);
    }

    public Automovil getAutomovilAAgregar(String dni) {
        validarCamposAutomovilSinDni();
        String patente = jTextFieldPatente.getText();
        String marca = (String) jComboBoxMarca.getSelectedItem();
        String modelo = (String) jComboBoxModelo.getSelectedItem();
        int anioFabricacion = Integer.parseInt(jTextFieldAnioFabricacion.getText());
        String dniCliente = dni;
        return new Automovil(0, patente, marca, modelo, anioFabricacion, dniCliente);

    }

    public Cliente getClienteAAgregar() {
        validarCamposCliente();
        String dni = jTextFieldDNICliente.getText();
        String nombre = jTextFieldNombreCliente.getText();
        String apellido = jTextFieldApellidoCliente.getText();
        String mail = jTextFieldMailCliente.getText();
        int telefono = Integer.parseInt(jTextFieldTelefonoCliente.getText());
        return new Cliente(0, dni, nombre, apellido, mail, telefono);
    }

    private void validarCamposCliente() {
        if (VALIDACIONES.estaVacio(jTextFieldDNICliente.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldDNICliente.getName() + "\" está vacío");
        }
        if (VALIDACIONES.estaVacio(jTextFieldNombreCliente.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldNombreCliente.getName() + "\" está vacío");
        }
        if (VALIDACIONES.estaVacio(jTextFieldApellidoCliente.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldApellidoCliente.getName() + "\" está vacío");
        }

        if (!VALIDACIONES.esMailValido(jTextFieldMailCliente.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldMailCliente.getName() + "\" no es un mail valido");
        }
        if (!VALIDACIONES.esNumeroEntero(jTextFieldTelefonoCliente.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldTelefonoCliente.getName() + "\" no es un numero");
        }
    }

    private void validarCamposAutomovilSinDni() {
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
    }

    private void validarCamposAutomovilConDni() {
        validarCamposAutomovilSinDni();
        if (VALIDACIONES.estaVacio((String) jComboBoxCliente.getSelectedItem())) {
            throw new IllegalStateException("El campo \"" + jComboBoxCliente.getName() + "\" esta vacio");
        }

    }

    public boolean conCliente() {
        return jCheckBoxHabilitarCliente.isSelected();
    }

    private void tamanioVentana(int height, boolean b) {
        jPanelFormularioAgregarCliente.setVisible(!b);
        this.setSize(WIDTH_JFRAME, height);
        jLabelCliente.setVisible(b);
        jComboBoxCliente.setVisible(b);
    }

    private void colocarMarcas() {
        Marca[] categorias = Marca.values();
        String[] categoriasAColocar = new String[categorias.length];

        for (int i = 0; i < categoriasAColocar.length; i++) {
            categoriasAColocar[i] = categorias[i].name();
        }

        jComboBoxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(categoriasAColocar));
    }

    private void colocarModeloSegunMarca() {
        String marcaElegida = (String) jComboBoxMarca.getSelectedItem();
        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(Marca.valueOf(marcaElegida).getNombreModelos()));
    }

    private void estilosFormulario() {
        jPanelFormularioAgregarAutomovil.setBackground(new java.awt.Color(255, 204, 204));
        jPanelFormularioAgregarAutomovil.setPreferredSize(new java.awt.Dimension(800, 227));
        jPanelFormularioAgregarAutomovil.setRequestFocusEnabled(false);

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

        jLabelCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCliente.setText("DNI Cliente");

        jComboBoxCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboBoxCliente.setName("DNI cliente"); // NOI18N

        jTextFieldAnioFabricacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldAnioFabricacion.setName("año de fabricacion"); // NOI18N

        jCheckBoxHabilitarCliente.setBackground(new java.awt.Color(255, 204, 204));
        jCheckBoxHabilitarCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCheckBoxHabilitarCliente.setText("En caso de no tener el dni del cliente");

        jComboBoxMarca.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboBoxMarca.setToolTipText("");
        jComboBoxMarca.setName("marca"); // NOI18N

        jComboBoxModelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBoxModelo.setToolTipText("");
        jComboBoxModelo.setName("modelo"); // NOI18N

        javax.swing.GroupLayout jPanelFormularioAgregarAutomovilLayout = new javax.swing.GroupLayout(jPanelFormularioAgregarAutomovil);
        jPanelFormularioAgregarAutomovil.setLayout(jPanelFormularioAgregarAutomovilLayout);
        jPanelFormularioAgregarAutomovilLayout.setHorizontalGroup(
                jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioAgregarAutomovilLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelFormularioAgregarAutomovilLayout.createSequentialGroup()
                                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabelAnioFabricacion))
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldAnioFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanelFormularioAgregarAutomovilLayout.createSequentialGroup()
                                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabelModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabelPatente, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                                        .addComponent(jLabelMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldPatente, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                                        .addComponent(jComboBoxMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jComboBoxModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(46, Short.MAX_VALUE))
                        .addGroup(jPanelFormularioAgregarAutomovilLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jCheckBoxHabilitarCliente)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFormularioAgregarAutomovilLayout.setVerticalGroup(
                jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioAgregarAutomovilLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPatente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelMarca)
                                        .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelModelo)
                                        .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelAnioFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldAnioFabricacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCliente)
                                        .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxHabilitarCliente))
        );

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
        jTextFieldTelefonoCliente.setName("telefono"); // NOI18N

        jTextFieldMailCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldMailCliente.setName("mail"); // NOI18N

        jTextFieldApellidoCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldApellidoCliente.setName("apellido"); // NOI18N

        jTextFieldNombreCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldNombreCliente.setName("nombre"); // NOI18N

        jTextFieldDNICliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldDNICliente.setName("DNI"); // NOI18N

        javax.swing.GroupLayout jPanelFormularioClienteLayout = new javax.swing.GroupLayout(jPanelFormularioCliente);
        jPanelFormularioCliente.setLayout(jPanelFormularioClienteLayout);
        jPanelFormularioClienteLayout.setHorizontalGroup(
                jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioClienteLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelFormularioClienteLayout.createSequentialGroup()
                                                .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelMailCliente)
                                                        .addComponent(jLabelTelefonoCliente))
                                                .addGap(57, 57, 57)
                                                .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldMailCliente)
                                                        .addComponent(jTextFieldTelefonoCliente)))
                                        .addGroup(jPanelFormularioClienteLayout.createSequentialGroup()
                                                .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabelNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabelApellidoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabelDNICliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextFieldDNICliente, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextFieldApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(42, 42, 42))
        );
        jPanelFormularioClienteLayout.setVerticalGroup(
                jPanelFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioClienteLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
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
                        .addComponent(jPanelFormularioCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTituloCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelFormularioAgregarClienteLayout.setVerticalGroup(
                jPanelFormularioAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioAgregarClienteLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabelTituloCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelFormularioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(super.getPanelFormulario());
        super.getPanelFormulario().setLayout(jPanelFormularioLayout);
        jPanelFormularioLayout.setHorizontalGroup(
                jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanelFormularioAgregarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanelFormularioAgregarAutomovil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelFormularioLayout.setVerticalGroup(
                jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanelFormularioAgregarAutomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanelFormularioAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Automovil");
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private class MostrarFormularioCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean conCliente = conCliente();
            if (conCliente) {
                tamanioVentana(HEIGHT_JFRAME_MAX, !conCliente);
            } else {
                tamanioVentana(HEIGHT_JFRAME_MIN, !conCliente);
            }
        }
    }

    private class CambiarModelosSegunMarca implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            colocarModeloSegunMarca();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
