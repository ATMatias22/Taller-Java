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
import taller.modelo.clases.Automovil;
import taller.modelo.clases.TipoSeccion;
import taller.modelo.clases.Cliente;

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
    
    public JFrameFormularioAgregarAutomovil(Component parent, Collection<String> dniClientes) {
        super(NOMBRE_LOGO, TITULO, TEXTO_BOTON, parent, COLOR_FONDO, COLOR_TEXTO, HEIGHT_PANEL_FORMULARIO);
        iniciar(parent, dniClientes);
    }
    
    private void iniciar(Component parent, Collection<String> dniClientes) {
        jPanelFormularioAgregarAutomovil = new javax.swing.JPanel();
        jLabelPatente = new javax.swing.JLabel();
        jTextFieldPatente = new javax.swing.JTextField();
        jLabelMarca = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jLabelModelo = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jLabelAnioFabricacion = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jTextFieldAnioFabricacion = new javax.swing.JTextField();
        jCheckBoxHabilitarCliente = new javax.swing.JCheckBox();
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
        
        tamanioVentana(HEIGHT_JFRAME_MIN, true);
        setLocationRelativeTo(parent);
        estilosFormulario();
        colocarDNIClientes(dniClientes);
        this.jCheckBoxHabilitarCliente.addActionListener(new MostrarFormularioCliente());
        
    }
    
    private void colocarDNIClientes(Collection<String> dniClientes) {
        String[] dni = new String[dniClientes.size()];
        dniClientes.toArray(dni);
        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(dni));
    }
    
    public Automovil getAutomovilAAgregar() {
        validarCamposAutomovil();
        String patente = jTextFieldPatente.getText();
        String marca = jTextFieldMarca.getText();
        String modelo = jTextFieldModelo.getText();
        int anioFabricacion = Integer.parseInt(jTextFieldAnioFabricacion.getText());
        String dniCliente = (String) this.jComboBoxCliente.getSelectedItem();
        return new Automovil(0, patente, marca, modelo, anioFabricacion, dniCliente);
    }
    
    public Automovil getAutomovilAAgregar(String dni) {
        Automovil automovil = getAutomovilAAgregar();
        automovil.setDniCliente(dni);
        return automovil;
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
    
    private void validarCamposAutomovil() {
        if (VALIDACIONES.estaVacio(jTextFieldPatente.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldPatente.getName() + "\" está vacío");
        }
        if (VALIDACIONES.estaVacio(jTextFieldMarca.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldMarca.getName() + "\" está vacío");
        }
        if (VALIDACIONES.estaVacio(jTextFieldModelo.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldModelo.getName() + "\" está vacío");
        }
        
        if (!VALIDACIONES.esNumeroEntero(jTextFieldAnioFabricacion.getText())) {
            throw new IllegalStateException("El campo \"" + jTextFieldAnioFabricacion.getName() + "\" no es un numero valido");
        }
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
    
    private void estilosFormulario() {
        jPanelFormularioAgregarAutomovil.setBackground(new java.awt.Color(255, 204, 204));
        jPanelFormularioAgregarAutomovil.setPreferredSize(new java.awt.Dimension(800, 227));
        jPanelFormularioAgregarAutomovil.setRequestFocusEnabled(false);
        
        jLabelPatente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPatente.setText("Patente");
        
        jTextFieldPatente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldPatente.setName("patente");
        
        jLabelMarca.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMarca.setText("Marca");
        
        jTextFieldMarca.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldMarca.setName("marca");
        
        jLabelModelo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelModelo.setText("Modelo");
        jLabelModelo.setToolTipText("");
        
        jTextFieldModelo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldModelo.setName("modelo");
        
        jLabelAnioFabricacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelAnioFabricacion.setText("<html><p>Año de</p> fabricacion</html>");
        
        jLabelCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCliente.setText("DNI Cliente");
        
        jComboBoxCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboBoxCliente.setName("dni");
        
        jTextFieldAnioFabricacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldAnioFabricacion.setName("año de fabricacion");
        
        jCheckBoxHabilitarCliente.setBackground(new java.awt.Color(255, 204, 204));
        jCheckBoxHabilitarCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCheckBoxHabilitarCliente.setText("En caso de no tener el dni del cliente");
        
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
                                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelMarca)
                                        .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelModelo)
                                        .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelAnioFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldAnioFabricacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCliente)
                                        .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
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
        jTextFieldTelefonoCliente.setName("telefono");
        
        jTextFieldMailCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldMailCliente.setName("mail");
        jTextFieldApellidoCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldApellidoCliente.setName("apellido");
        jTextFieldNombreCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldNombreCliente.setName("nombre");
        jTextFieldDNICliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldDNICliente.setName("dni");
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

        jPanelPrincipal = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();
        jPanelFormulario = new javax.swing.JPanel();
        jPanelFormularioAgregarAutomovil = new javax.swing.JPanel();
        jLabelPatente = new javax.swing.JLabel();
        jTextFieldPatente = new javax.swing.JTextField();
        jLabelMarca = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jLabelModelo = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jLabelAnioFabricacion = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jTextFieldAnioFabricacion = new javax.swing.JTextField();
        jCheckBoxHabilitarCliente = new javax.swing.JCheckBox();
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
        setResizable(false);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 204, 204));

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

        jPanelFormulario.setBackground(new java.awt.Color(255, 204, 204));

        jPanelFormularioAgregarAutomovil.setBackground(new java.awt.Color(255, 204, 204));
        jPanelFormularioAgregarAutomovil.setPreferredSize(new java.awt.Dimension(800, 227));
        jPanelFormularioAgregarAutomovil.setRequestFocusEnabled(false);

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
        jLabelAnioFabricacion.setText("<html><p>Año de</p> fabricacion</html>");

        jLabelCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCliente.setText("DNI Cliente");

        jComboBoxCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jTextFieldAnioFabricacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jCheckBoxHabilitarCliente.setBackground(new java.awt.Color(255, 204, 204));
        jCheckBoxHabilitarCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCheckBoxHabilitarCliente.setText("En caso de no tener el dni del cliente");

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
                        .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMarca)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModelo)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelAnioFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAnioFabricacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioAgregarAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCliente)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
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

        jTextFieldMailCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jTextFieldApellidoCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jTextFieldNombreCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jTextFieldDNICliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

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

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(jPanelFormulario);
        jPanelFormulario.setLayout(jPanelFormularioLayout);
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

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanelFormulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
    private javax.swing.JPanel jPanelFormularioAgregarAutomovil;
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
