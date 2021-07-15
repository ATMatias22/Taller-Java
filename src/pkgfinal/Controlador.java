/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import taller.modelo.clases.Automovil;
import taller.modelo.clases.AutomovilDAO;
import taller.modelo.clases.Cliente;
import taller.modelo.clases.ClienteDAO;
import taller.modelo.clases.Servicio;
import taller.modelo.clases.ServicioDAO;
import taller.vista.clases.JFrameFormularioAgregarCliente;
import taller.vista.clases.JFrameAutomoviles;
import taller.vista.clases.JFrameClientes;
import taller.vista.clases.JFrameFormularioAgregarAutomovil;
import taller.vista.clases.JFrameFormularioAgregarServicio;
import taller.vista.clases.JFrameFormularioEditarAutomovil;
import taller.vista.clases.JFrameFormularioEditarCliente;
import taller.vista.clases.JFrameFormularioEditarServicio;
import taller.vista.clases.JFramePrincipal;
import taller.vista.clases.JFrameServicios;

/**
 *
 * @author Matias
 */
public class Controlador {
    private JFramePrincipal vistaPrincipal;
    private ClienteDAO clienteDAO;
    private AutomovilDAO automovilDAO;
    private ServicioDAO servicioDAO;
    private JFrameClientes vistaCliente;
    private JFrameAutomoviles vistaAutomovil;
    private JFrameServicios vistaServicio;
    private JFrameFormularioEditarCliente vistaEditarCliente;
    private JFrameFormularioEditarAutomovil vistaEditarAutomovil;
    private JFrameFormularioEditarServicio vistaEditarServicio;
    private JFrameFormularioAgregarCliente vistaAgregarCliente;
    private JFrameFormularioAgregarAutomovil vistaAgregarAutomovil;
    private JFrameFormularioAgregarServicio vistaAgregarServicio;

    public void iniciar() {
        clienteDAO = new ClienteDAO();
        automovilDAO = new AutomovilDAO();
        servicioDAO = new ServicioDAO();
        vistaPrincipal = new JFramePrincipal();
        vistaPrincipal.seleccionDeVentana(new Ventena());
    }

    private void addAllListenersCliente() {
        vistaCliente.addActionListenerBotonAgregar(new PrincipalBotonAgregarListenerCliente());
        vistaCliente.addActionListenerBotonEliminar(new PrincipalBotonEliminarListenerCliente());
        vistaCliente.addActionListenerBotonEditar(new PrincipalBotonEditarListenerCliente());
        vistaCliente.addKeyListenerJTextFieldFiltrar(new FiltrarClienteKeyListener());
        vistaCliente.addActionListenerJComboBoxFiltrar(new FiltrarClienteActionListener());
    }

    private void addAllListenersAutomovil() {
        vistaAutomovil.addActionListenerBotonAgregar(new PrincipalBotonAgregarListenerAutomovil());
        vistaAutomovil.addActionListenerBotonEliminar(new PrincipalBotonEliminarListenerAutomovil());
        vistaAutomovil.addActionListenerBotonEditar(new PrincipalBotonEditarListenerAutomovil());
        vistaAutomovil.addKeyListenerJTextFieldFiltrar(new FiltrarAutomovilKeyListener());
        vistaAutomovil.addActionListenerJComboBoxFiltrar(new FiltrarAutomovilActionListener());
    }
    
     private void addAllListenersServicio() {
        vistaServicio.addActionListenerBotonAgregar(new PrincipalBotonAgregarListenerServicio());
        vistaServicio.addActionListenerBotonEliminar(new PrincipalBotonEliminarListenerServicio());
        vistaServicio.addActionListenerBotonEditar(new PrincipalBotonEditarListenerServicio());
        vistaServicio.addKeyListenerJTextFieldFiltrar(new FiltrarServicioKeyListener());
        vistaServicio.addActionListenerJComboBoxFiltrar(new FiltrarServicioActionListener());
    }

    public void agregarCliente() {
        if (vistaAgregarCliente.confirmacion("Esta seguro que desea agregar a este cliente ")) {
            try {
                clienteDAO.agregarCliente(this.vistaAgregarCliente.getClienteAAgregar());
                vistaAgregarCliente.mostrarMensaje("Se agrego cliente");
                vistaCliente.actualizarListaClientes(clienteDAO.obtenerClientes());
            } catch (Exception ex) {
                vistaAgregarCliente.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void eliminarCliente() {
        try {
            Cliente c = vistaCliente.getCliente();
            if (vistaCliente.confirmacion("Esta seguro que desea eliminar al cliente")) {
                clienteDAO.eliminarCliente(c.getIdCliente());
                vistaCliente.actualizarListaClientes(clienteDAO.obtenerClientes());
                vistaCliente.mostrarMensaje("Se elimino el cliente");
            }
        } catch (Exception ex) {
            vistaCliente.mostrarMensajeError(ex.getMessage());
        }

    }

    public void editarCliente() {
        if (vistaEditarCliente.confirmacion("Esta seguro que desea editar al cliente")) {
            try {
                clienteDAO.editarCliente(vistaEditarCliente.getClienteEditado());
                vistaEditarCliente.mostrarMensaje("Se edito el cliente");
                vistaCliente.actualizarListaClientes(clienteDAO.obtenerClientes());
            } catch (Exception ex) {
                vistaEditarCliente.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void filtrarCliente() {
        vistaCliente.actualizarListaClientes(clienteDAO.filtrarClientes(vistaCliente.buscarEquivalenteDelFiltroEnBD(vistaCliente.obtenerFiltroSeleccionado()), vistaCliente.obtenerBusqueda()));
    }

    public void agregarAutomovil() {
        if (vistaAgregarAutomovil.confirmacion("Esta seguro que desea agregar a este automovil ")) {
            try {
                automovilDAO.agregarAutomovil(this.vistaAgregarAutomovil.getAutomovilAAgregar());
                vistaAgregarAutomovil.mostrarMensaje("Se agrego automovil");
                vistaAutomovil.actualizarListaAutomoviles(automovilDAO.obtenerAutomoviles());
            } catch (Exception ex) {
                vistaAgregarAutomovil.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void agregarAutomovilConCliente() {
        if (vistaAgregarAutomovil.confirmacion("Esta seguro que desea agregar este automovil con este cliente")) {
            try {
                automovilDAO.agregarAutomovilConCliente(this.vistaAgregarAutomovil.getAutomovilAAgregar(vistaAgregarAutomovil.getClienteAAgregar().getDni()), this.vistaAgregarAutomovil.getClienteAAgregar());
                vistaAgregarAutomovil.mostrarMensaje("Se agrego automovil con el cliente");
                vistaAutomovil.actualizarListaAutomoviles(automovilDAO.obtenerAutomoviles());
            } catch (Exception ex) {
                vistaAgregarAutomovil.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void eliminarAutomovil() {
        try {
            Automovil a = vistaAutomovil.getAutomovil();
            if (vistaAutomovil.confirmacion("Esta seguro que desea eliminar al automovil")) {
                automovilDAO.eliminarAutomovil(a.getIdAutomovil());
                vistaAutomovil.actualizarListaAutomoviles(automovilDAO.obtenerAutomoviles());
                vistaAutomovil.mostrarMensaje("Se elimino el automovil");
            }
        } catch (Exception ex) {
            vistaAutomovil.mostrarMensajeError(ex.getMessage());
        }

    }

    public void editarAutomovil() {
        if (vistaEditarAutomovil.confirmacion("Esta seguro que desea editar al automovil")) {
            try {
                automovilDAO.editarAutomovil(vistaEditarAutomovil.getAutomovilEditado());
                vistaEditarAutomovil.mostrarMensaje("Se edito el automovil");
                vistaAutomovil.actualizarListaAutomoviles(automovilDAO.obtenerAutomoviles());
            } catch (Exception ex) {
                vistaEditarAutomovil.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void filtrarAutomovil() {
        vistaAutomovil.actualizarListaAutomoviles(automovilDAO.filtrarAutomoviles(vistaAutomovil.buscarEquivalenteEnBD(vistaAutomovil.obtenerFiltroSeleccionado()), vistaAutomovil.obtenerBusqueda()));
    }
    
   

    //SERVICIOS------------------------------------------------------------------
    public void agregarServicio() {
        if (vistaAgregarServicio.confirmacion("Esta seguro que desea agregar a este servicio ")) {
            try {
                servicioDAO.agregarServicio(this.vistaAgregarServicio.getServicioAAgregar());
                vistaAgregarServicio.mostrarMensaje("Se agrego servicio");
                vistaServicio.actualizarListaServicio(servicioDAO.obtenerServicios());
            } catch (Exception ex) {
                vistaAgregarServicio.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void eliminarServicio() {
        try {
            Servicio s = vistaServicio.getServicio();
            if (vistaServicio.confirmacion("Esta seguro que desea eliminar al servicio")) {
                servicioDAO.eliminarServicio(s.getIdServicio());
                vistaServicio.actualizarListaServicio(servicioDAO.obtenerServicios());
                vistaServicio.mostrarMensaje("Se elimino el servicio");
            }
        } catch (Exception ex) {
            vistaServicio.mostrarMensajeError(ex.getMessage());
        }

    }

    public void editarServicio() {
        if (vistaEditarServicio.confirmacion("Esta seguro que desea editar al servicio")) {
            try {
                servicioDAO.editarServicio(vistaEditarServicio.getServicioEditado());
                vistaEditarServicio.mostrarMensaje("Se edito el servicio");
                vistaServicio.actualizarListaServicio(servicioDAO.obtenerServicios());
            } catch (Exception ex) {
                vistaEditarServicio.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void filtrarServicio() {
        vistaServicio.actualizarListaServicio(servicioDAO.filtrarServicio(vistaServicio.buscarEquivalenteEnBD(vistaServicio.obtenerFiltroSeleccionado()), vistaServicio.obtenerBusqueda()));
    }

    //--------------------------------------------------------------------------
    private class Ventena implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Clientes")) {
                vistaCliente = new JFrameClientes(vistaPrincipal);
                vistaCliente.mostrarClientes(clienteDAO.obtenerClientes());
                addAllListenersCliente();
            } else if (e.getActionCommand().equalsIgnoreCase("Automoviles")) {
                vistaAutomovil = new JFrameAutomoviles(vistaPrincipal);
                vistaAutomovil.mostrarAutomoviles(automovilDAO.obtenerAutomoviles());
                addAllListenersAutomovil();
            } else if (e.getActionCommand().equalsIgnoreCase("Servicios")) {
                vistaServicio = new JFrameServicios(vistaPrincipal);
                vistaServicio.mostrarServicios(servicioDAO.obtenerServicios());
                addAllListenersServicio();
            }
        }
    }

    //CLASES INTERNAS DE CLIENTES
    private class PrincipalBotonAgregarListenerCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vistaAgregarCliente = new JFrameFormularioAgregarCliente(vistaCliente);
            vistaAgregarCliente.addActionListenerBotonAgregar(new HandlerJFrameAgregarBotonAgregarCliente());
        }
    }

    private class HandlerJFrameAgregarBotonAgregarCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            agregarCliente();
        }
    }

    private class PrincipalBotonEditarListenerCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vistaEditarCliente = new JFrameFormularioEditarCliente(vistaCliente.getCliente(), vistaPrincipal);
            vistaEditarCliente.addActionListenerBotonEditar(new HandlerJFrameEditarBotonEditarCliente());
        }
    }

    private class HandlerJFrameEditarBotonEditarCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            editarCliente();
        }
    }

    private class PrincipalBotonEliminarListenerCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            eliminarCliente();
        }
    }

    private class FiltrarClienteKeyListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            filtrarCliente();
        }
    }

    private class FiltrarClienteActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            filtrarCliente();
        }
    }

    //CLASES INTERNAS DE AUTOMOVIL
    private class PrincipalBotonAgregarListenerAutomovil implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vistaAgregarAutomovil = new JFrameFormularioAgregarAutomovil(vistaAutomovil, (ArrayList<String>) clienteDAO.obtenerDNIClientes());
            vistaAgregarAutomovil.addActionListenerBotonAgregar(new HandlerJFrameAgregarBotonAgregarAutomovil());
        }
    }

    private class HandlerJFrameAgregarBotonAgregarAutomovil implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (vistaAgregarAutomovil.conCliente()) {
                agregarAutomovilConCliente();
            } else {
                agregarAutomovil();
            }
        }
    }

    private class PrincipalBotonEditarListenerAutomovil implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vistaEditarAutomovil = new JFrameFormularioEditarAutomovil(vistaAutomovil.getAutomovil(), vistaAutomovil, (ArrayList<String>) clienteDAO.obtenerDNIClientes());
            vistaEditarAutomovil.addActionListenerBotonEditar(new HandlerJFrameEditarBotonEditarAutomovil());
        }
    }

    private class HandlerJFrameEditarBotonEditarAutomovil implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            editarAutomovil();
        }
    }

    private class PrincipalBotonEliminarListenerAutomovil implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            eliminarAutomovil();
        }
    }

    private class FiltrarAutomovilKeyListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            filtrarAutomovil();
        }
    }

    private class FiltrarAutomovilActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            filtrarAutomovil();
        }
    }

    //CLASES INTERNAS DE Servicio
    private class PrincipalBotonAgregarListenerServicio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vistaAgregarServicio = new JFrameFormularioAgregarServicio(vistaServicio, (ArrayList<String>) servicioDAO.obtenerPatentesAutomoviles());
            vistaAgregarServicio.addActionListenerBotonAgregar(new HandlerJFrameAgregarBotonAgregarServicio());
        }
    }

    private class HandlerJFrameAgregarBotonAgregarServicio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            agregarServicio();
        }
    }

    private class PrincipalBotonEditarListenerServicio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vistaEditarServicio = new JFrameFormularioEditarServicio(vistaServicio.getServicio(), vistaServicio, (ArrayList<String>) servicioDAO.obtenerPatentesAutomoviles());
            vistaEditarServicio.addActionListenerBotonEditar(new HandlerJFrameEditarBotonEditarServicio());
        }
    }

    private class HandlerJFrameEditarBotonEditarServicio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            editarServicio();
        }
    }

    private class PrincipalBotonEliminarListenerServicio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            eliminarServicio();
        }
    }

    private class FiltrarServicioKeyListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            filtrarServicio();

        }
    }

    private class FiltrarServicioActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            filtrarServicio();
        }
    }

}
