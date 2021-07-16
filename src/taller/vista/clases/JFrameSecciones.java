/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Collection;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import taller.interfaces.Seccion;
import taller.modelo.clases.Automovil;
import taller.modelo.clases.Categoria;
import taller.modelo.clases.Cliente;
import taller.modelo.clases.Servicio;

/**
 *
 * @author Matias
 */
public class JFrameSecciones<T extends Seccion> extends javax.swing.JFrame {

    private T seccion;
    private Categoria c;
    private final static String PATH_RECURSOS = "/taller/vista/recursos/";

    public JFrameSecciones(String titulo, Categoria c, JFrame parent, String nombreDeImagen) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(parent);
        this.c = c;
        colocarTitulos(titulo);
        iniciar(c, nombreDeImagen);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jScrollPaneDatos = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelFiltrar = new javax.swing.JPanel();
        jComboBoxFiltrar = new javax.swing.JComboBox<>();
        jTextFieldFiltrar = new javax.swing.JTextField();
        jLabelFiltrar = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jPanelAcciones = new javax.swing.JPanel();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 204, 204));

        jScrollPaneDatos.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPaneDatos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTableDatos.setBackground(new java.awt.Color(204, 255, 204));
        jTableDatos.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDatos.setGridColor(new java.awt.Color(204, 204, 204));
        jTableDatos.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jScrollPaneDatos.setViewportView(jTableDatos);

        jLabelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Clientes");
        jLabelTitulo.setOpaque(true);

        jPanelFiltrar.setBackground(new java.awt.Color(255, 204, 204));

        jComboBoxFiltrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboBoxFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextFieldFiltrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabelFiltrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelFiltrar.setText("Filtrar por");

        javax.swing.GroupLayout jPanelFiltrarLayout = new javax.swing.GroupLayout(jPanelFiltrar);
        jPanelFiltrar.setLayout(jPanelFiltrarLayout);
        jPanelFiltrarLayout.setHorizontalGroup(
            jPanelFiltrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltrarLayout.createSequentialGroup()
                .addComponent(jLabelFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelFiltrarLayout.setVerticalGroup(
            jPanelFiltrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltrarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelFiltrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFiltrar)
                    .addComponent(jTextFieldFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelLogo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogo.setOpaque(true);

        jPanelAcciones.setBackground(new java.awt.Color(255, 204, 204));

        jButtonAgregar.setBackground(new java.awt.Color(0, 153, 51));
        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setBorderPainted(false);

        jButtonEditar.setBackground(new java.awt.Color(255, 204, 0));
        jButtonEditar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(153, 102, 0));
        jButtonEditar.setText("Editar");
        jButtonEditar.setBorderPainted(false);

        jButtonEliminar.setBackground(new java.awt.Color(255, 0, 0));
        jButtonEliminar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 102, 102));
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.setBorderPainted(false);

        javax.swing.GroupLayout jPanelAccionesLayout = new javax.swing.GroupLayout(jPanelAcciones);
        jPanelAcciones.setLayout(jPanelAccionesLayout);
        jPanelAccionesLayout.setHorizontalGroup(
            jPanelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccionesLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanelAccionesLayout.setVerticalGroup(
            jPanelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccionesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonEliminar))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jScrollPaneDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jPanelFiltrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanelAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPaneDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void iniciar(Categoria c, String nombreDeImagen) {
        insertarColumnasEnLaTabla(c.getNombreDeCategoriasParaLaTabla());
        insertarFiltrosEnElJComboBox(c.getNombreDeCategoriasParaElFiltro());
        puedeEditarColumnas(false, c.getNombreDeCategoriasParaLaTabla());
        ocultarColumnaID();
        getTabla().setRowSelectionAllowed(false);
        habilitarODeshabiliarBotones(false);
        jLabelLogo.setIcon(getImagen(nombreDeImagen));
        jTableDatos.addMouseListener(new LlenarFormularioConLaSeccionSeleccionado());
    }

    private void colocarTitulos(String titulo) {
        this.setTitle(titulo);
        this.jLabelTitulo.setText(titulo);
    }

    public T getSeccion() {
        if (seccion == null) {
            throw new RuntimeException("Debe seleccionar un " + seccion.getClass().getName());
        }
        return seccion;
    }

    public String buscarEquivalenteDelFiltroEnBD(String filtroElegido) {
        int acumulador = 0;
        boolean encontrado = false;
        String[] arrayConLosFiltros = c.getNombreDeCategoriasParaElFiltro();
        while (acumulador < arrayConLosFiltros.length && !encontrado) {
            if (arrayConLosFiltros[acumulador].equalsIgnoreCase(filtroElegido)) {
                encontrado = true;
            }
            acumulador++;
        }
        return c.buscarEquivalenteEnBD(acumulador);
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

    private void insertarColumnasEnLaTabla(String[] columnas) {

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, columnas
        ) {
            boolean[] canEdit = puedeEditarColumnas(false, columnas);

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

    }

    private boolean[] puedeEditarColumnas(boolean b, String[] columnas) {
        boolean[] arrayBooleano = new boolean[columnas.length];
        for (int i = 0; i < arrayBooleano.length; i++) {
            arrayBooleano[i] = b;
        }
        return arrayBooleano;
    }

    public void vaciar() {
        DefaultTableModel dtm = (DefaultTableModel) getTabla().getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            dtm.removeRow(i);
            i -= 1;
        }
        habilitarODeshabiliarBotones(false);
    }

    public JTable getTabla() {
        return this.jTableDatos;
    }

    public JComboBox getComboBox() {
        return this.jComboBoxFiltrar;
    }

    public void actualizarListaTabla(Collection<T> valoresDeLaSeccion) {
        vaciar();
        mostrarEnTabla(valoresDeLaSeccion);
    }

    public void mostrarEnTabla(Collection<T> valoresDeLaSeccion) {
        for (T emp : valoresDeLaSeccion) {
            agregarFila(emp);
        }
    }

    private void agregarFila(T e) {
        Object[] datos = e.getArrayAtributos();
        DefaultTableModel dtm = (DefaultTableModel) getTabla().getModel();
        dtm.addRow(datos);
    }

    public void habilitarODeshabiliarBotones(boolean b) {
        jButtonEditar.setEnabled(b);
        jButtonEliminar.setEnabled(b);
        if (b == false) {
            jButtonEditar.setBackground(Color.LIGHT_GRAY);
            jButtonEliminar.setBackground(Color.LIGHT_GRAY);
        } else {
            jButtonEditar.setBackground(new Color(255, 204, 0));
            jButtonEliminar.setBackground(new Color(255, 0, 0));
        }
    }

    public String obtenerFiltroSeleccionado() {
        return (String) this.jComboBoxFiltrar.getSelectedItem();
    }

    public String obtenerBusqueda() {
        return this.jTextFieldFiltrar.getText();
    }

    private void ocultarColumnaID() {
        this.jTableDatos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        this.jTableDatos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        this.jTableDatos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.jTableDatos.getColumnModel().getColumn(0).setMinWidth(0);
    }

    private void insertarFiltrosEnElJComboBox(String[] filtros) {
        jComboBoxFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(filtros));
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public boolean confirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje) == 0;
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error...", JOptionPane.ERROR_MESSAGE);
    }

    public void addActionListenerBotonAgregar(ActionListener al) {
        this.jButtonAgregar.addActionListener(al);
    }

    public void addActionListenerBotonEliminar(ActionListener al) {
        this.jButtonEliminar.addActionListener(al);
    }

    public void addActionListenerBotonEditar(ActionListener al) {
        this.jButtonEditar.addActionListener(al);
    }

    public void addKeyListenerJTextFieldFiltrar(KeyListener kl) {
        this.jTextFieldFiltrar.addKeyListener(kl);
    }

    public void addActionListenerJComboBoxFiltrar(ActionListener al) {
        this.jComboBoxFiltrar.addActionListener(al);
    }

    private class LlenarFormularioConLaSeccionSeleccionado extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                getTabla().setRowSelectionAllowed(true);
                int fila = getTabla().rowAtPoint(e.getPoint());
                if (c.equals(Categoria.AUTOMOVIL)) {
                    seccion = (T) new Automovil((int) getTabla().getValueAt(fila, 0), getTabla().getValueAt(fila, 1).toString(), getTabla().getValueAt(fila, 2).toString(), getTabla().getValueAt(fila, 3).toString(), (int) getTabla().getValueAt(fila, 4), getTabla().getValueAt(fila, 5).toString());
                } else if (c.equals(Categoria.CLIENTE)) {
                    seccion = (T) new Cliente((int) getTabla().getValueAt(fila, 0), getTabla().getValueAt(fila, 1).toString(), getTabla().getValueAt(fila, 2).toString(), getTabla().getValueAt(fila, 3).toString(), getTabla().getValueAt(fila, 4).toString(), (int) getTabla().getValueAt(fila, 5));
                } else if (c.equals(Categoria.SERVICIO)) {
                    seccion = (T) new Servicio((int) getTabla().getValueAt(fila, 0), getTabla().getValueAt(fila, 1).toString(), (double) getTabla().getValueAt(fila, 2), getTabla().getValueAt(fila, 3).toString(), (int) getTabla().getValueAt(fila, 4));
                }
                habilitarODeshabiliarBotones(true);

            } else if (e.getClickCount() == 1) {
                seccion = null;
                getTabla().setRowSelectionAllowed(false);
                habilitarODeshabiliarBotones(false);
            }

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JComboBox<String> jComboBoxFiltrar;
    private javax.swing.JLabel jLabelFiltrar;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelAcciones;
    private javax.swing.JPanel jPanelFiltrar;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPaneDatos;
    private javax.swing.JTable jTableDatos;
    private javax.swing.JTextField jTextFieldFiltrar;
    // End of variables declaration//GEN-END:variables
}
