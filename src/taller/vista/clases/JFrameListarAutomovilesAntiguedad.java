/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.vista.clases;

import java.awt.Component;
import java.util.Collection;
import javax.swing.table.DefaultTableModel;
import taller.modelo.clases.Automovil;
import taller.modelo.clases.TipoSeccion;

/**
 *
 * @author Matias
 */
public class JFrameListarAutomovilesAntiguedad extends javax.swing.JFrame {

    /**
     * Creates new form JFrameListarAutomoviles
     */
    public JFrameListarAutomovilesAntiguedad(Collection<Automovil> automoviles, Component parent) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(parent);
        insertarColumnasEnLaTabla(TipoSeccion.AUTOMOVIL.getNombreDeCategoriasParaLaTabla());
        mostrarEnTabla(automoviles);
        ocultarColumnaID() ;
    }

    private void insertarColumnasEnLaTabla(String[] columnas) {
        jTableAutomovil.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, columnas
        ) {
            boolean[] canEdit = puedeEditarColumnas(false, columnas);

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    public void mostrarEnTabla(Collection<Automovil> automoviles) {
        for (Automovil emp : automoviles) {
            agregarFila(emp);
        }
    }

    private void agregarFila(Automovil e) {
        Object[] datos = e.getArrayAtributos();
        DefaultTableModel dtm = (DefaultTableModel) jTableAutomovil.getModel();
        dtm.addRow(datos);
    }

    private boolean[] puedeEditarColumnas(boolean b, String[] columnas) {
        boolean[] arrayBooleano = new boolean[columnas.length];
        for (int i = 0; i < arrayBooleano.length; i++) {
            arrayBooleano[i] = b;
        }
        return arrayBooleano;
    }
    
    private void ocultarColumnaID() {
        this.jTableAutomovil.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        this.jTableAutomovil.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        this.jTableAutomovil.getColumnModel().getColumn(0).setMaxWidth(0);
        this.jTableAutomovil.getColumnModel().getColumn(0).setMinWidth(0);
    }
    
    public void cerrar(){
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAutomovil = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Automoviles a llamar");
        setResizable(false);

        jTableAutomovil.setBackground(new java.awt.Color(204, 255, 204));
        jTableAutomovil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableAutomovil.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jScrollPane1.setViewportView(jTableAutomovil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAutomovil;
    // End of variables declaration//GEN-END:variables
}
