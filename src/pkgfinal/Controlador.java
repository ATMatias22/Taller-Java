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
import taller.modelo.clases.Categoria;
import taller.modelo.clases.Cliente;
import taller.modelo.clases.ClienteDAO;
import taller.modelo.clases.Servicio;
import taller.modelo.clases.ServicioDAO;
import taller.vista.clases.JFrameFormularioAgregarCliente;
import taller.vista.clases.JFrameFormularioAgregarAutomovil;
import taller.vista.clases.JFrameFormularioAgregarServicio;
import taller.vista.clases.JFrameFormularioEditarAutomovil;
import taller.vista.clases.JFrameFormularioEditarCliente;
import taller.vista.clases.JFrameFormularioEditarServicio;
import taller.vista.clases.JFramePrincipal;
import taller.vista.clases.JFrameSecciones;

/**
 *
 * @author Matias
 */
public class Controlador {

    private JFramePrincipal vistaPrincipal;
    private ClienteDAO clienteDAO;
    private AutomovilDAO automovilDAO;
    private ServicioDAO servicioDAO;
    private JFrameSecciones vistaTemplate;
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
        vistaTemplate.addActionListenerBotonAgregar(new PrincipalBotonAgregarListenerCliente());
        vistaTemplate.addActionListenerBotonEliminar(new PrincipalBotonEliminarListenerCliente());
        vistaTemplate.addActionListenerBotonEditar(new PrincipalBotonEditarListenerCliente());
        vistaTemplate.addKeyListenerJTextFieldFiltrar(new FiltrarClienteKeyListener());
        vistaTemplate.addActionListenerJComboBoxFiltrar(new FiltrarClienteActionListener());
    }

    private void addAllListenersAutomovil() {
        vistaTemplate.addActionListenerBotonAgregar(new PrincipalBotonAgregarListenerAutomovil());
        vistaTemplate.addActionListenerBotonEliminar(new PrincipalBotonEliminarListenerAutomovil());
        vistaTemplate.addActionListenerBotonEditar(new PrincipalBotonEditarListenerAutomovil());
        vistaTemplate.addKeyListenerJTextFieldFiltrar(new FiltrarAutomovilKeyListener());
        vistaTemplate.addActionListenerJComboBoxFiltrar(new FiltrarAutomovilActionListener());
    }

    private void addAllListenersServicio() {
        vistaTemplate.addActionListenerBotonAgregar(new PrincipalBotonAgregarListenerServicio());
        vistaTemplate.addActionListenerBotonEliminar(new PrincipalBotonEliminarListenerServicio());
        vistaTemplate.addActionListenerBotonEditar(new PrincipalBotonEditarListenerServicio());
        vistaTemplate.addKeyListenerJTextFieldFiltrar(new FiltrarServicioKeyListener());
        vistaTemplate.addActionListenerJComboBoxFiltrar(new FiltrarServicioActionListener());
    }

    public void agregarCliente() {
        if (vistaAgregarCliente.confirmacion("Esta seguro que desea agregar a este cliente ")) {
            try {
                clienteDAO.agregarCliente(this.vistaAgregarCliente.getClienteAAgregar());
                vistaAgregarCliente.mostrarMensaje("Se agrego cliente");
                vistaTemplate.actualizarListaTabla(clienteDAO.obtenerClientes());
            } catch (Exception ex) {
                vistaAgregarCliente.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void eliminarCliente() {
        try {
            Cliente c = (Cliente) vistaTemplate.getSeccion();
            if (vistaTemplate.confirmacion("Esta seguro que desea eliminar al cliente")) {
                clienteDAO.eliminarCliente(c.getIdCliente());
                vistaTemplate.actualizarListaTabla(clienteDAO.obtenerClientes());
                vistaTemplate.mostrarMensaje("Se elimino el cliente");
            }
        } catch (Exception ex) {
            vistaTemplate.mostrarMensajeError(ex.getMessage());
        }

    }

    public void editarCliente() {
        if (vistaEditarCliente.confirmacion("Esta seguro que desea editar al cliente")) {
            try {
                clienteDAO.editarCliente(vistaEditarCliente.getClienteEditado());
                vistaEditarCliente.mostrarMensaje("Se edito el cliente");
                vistaTemplate.actualizarListaTabla(clienteDAO.obtenerClientes());
            } catch (Exception ex) {
                vistaEditarCliente.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void filtrarCliente() {
        vistaTemplate.actualizarListaTabla(clienteDAO.filtrarClientes(vistaTemplate.buscarEquivalenteDelFiltroEnBD(vistaTemplate.obtenerFiltroSeleccionado()), vistaTemplate.obtenerBusqueda()));
    }

    public void agregarAutomovil() {
        if (vistaAgregarAutomovil.confirmacion("Esta seguro que desea agregar a este automovil ")) {
            try {
                automovilDAO.agregarAutomovil(this.vistaAgregarAutomovil.getAutomovilAAgregar());
                vistaAgregarAutomovil.mostrarMensaje("Se agrego automovil");
                vistaTemplate.actualizarListaTabla(automovilDAO.obtenerAutomoviles());
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
                vistaTemplate.actualizarListaTabla(automovilDAO.obtenerAutomoviles());
            } catch (Exception ex) {
                vistaAgregarAutomovil.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void eliminarAutomovil() {
        try {
            Automovil a = (Automovil) vistaTemplate.getSeccion();
            if (vistaTemplate.confirmacion("Esta seguro que desea eliminar al automovil")) {
                automovilDAO.eliminarAutomovil(a.getIdAutomovil());
                vistaTemplate.actualizarListaTabla(automovilDAO.obtenerAutomoviles());
                vistaTemplate.mostrarMensaje("Se elimino el automovil");
            }
        } catch (Exception ex) {
            vistaTemplate.mostrarMensajeError(ex.getMessage());
        }

    }

    public void editarAutomovil() {
        if (vistaEditarAutomovil.confirmacion("Esta seguro que desea editar al automovil")) {
            try {
                automovilDAO.editarAutomovil(vistaEditarAutomovil.getAutomovilEditado());
                vistaEditarAutomovil.mostrarMensaje("Se edito el automovil");
                vistaTemplate.actualizarListaTabla(automovilDAO.obtenerAutomoviles());
            } catch (Exception ex) {
                vistaEditarAutomovil.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void filtrarAutomovil() {
        vistaTemplate.actualizarListaTabla(automovilDAO.filtrarAutomoviles(vistaTemplate.buscarEquivalenteDelFiltroEnBD(vistaTemplate.obtenerFiltroSeleccionado()), vistaTemplate.obtenerBusqueda()));
    }

    //SERVICIOS------------------------------------------------------------------
    public void agregarServicio() {
        if (vistaAgregarServicio.confirmacion("Esta seguro que desea agregar a este servicio ")) {
            try {
                servicioDAO.agregarServicio(this.vistaAgregarServicio.getServicioAAgregar());
                vistaAgregarServicio.mostrarMensaje("Se agrego servicio");
                vistaTemplate.actualizarListaTabla(servicioDAO.obtenerServicios());
            } catch (Exception ex) {
                vistaAgregarServicio.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void eliminarServicio() {
        try {
            Servicio s = (Servicio) vistaTemplate.getSeccion();
            if (vistaTemplate.confirmacion("Esta seguro que desea eliminar al servicio")) {
                servicioDAO.eliminarServicio(s.getIdServicio());
                vistaTemplate.actualizarListaTabla(servicioDAO.obtenerServicios());
                vistaTemplate.mostrarMensaje("Se elimino el servicio");
            }
        } catch (Exception ex) {
            vistaTemplate.mostrarMensajeError(ex.getMessage());
        }

    }

    public void editarServicio() {
        if (vistaEditarServicio.confirmacion("Esta seguro que desea editar al servicio")) {
            try {
                servicioDAO.editarServicio(vistaEditarServicio.getServicioEditado());
                vistaEditarServicio.mostrarMensaje("Se edito el servicio");
                vistaTemplate.actualizarListaTabla(servicioDAO.obtenerServicios());
            } catch (Exception ex) {
                vistaEditarServicio.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void filtrarServicio() {
        vistaTemplate.actualizarListaTabla(servicioDAO.filtrarServicio(vistaTemplate.buscarEquivalenteDelFiltroEnBD(vistaTemplate.obtenerFiltroSeleccionado()), vistaTemplate.obtenerBusqueda()));
    }

    //--------------------------------------------------------------------------
    private class Ventena implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (vistaPrincipal.obtenerSeccionSeleccionada().equalsIgnoreCase(Categoria.CLIENTE.toString())) {
                vistaTemplate = new JFrameSecciones<Automovil>("Clientes", Categoria.CLIENTE, vistaPrincipal, "cliente.png");
                vistaTemplate.mostrarEnTabla(clienteDAO.obtenerClientes());
                addAllListenersCliente();
            } else if (vistaPrincipal.obtenerSeccionSeleccionada().equalsIgnoreCase(Categoria.AUTOMOVIL.toString())) {
                vistaTemplate = new JFrameSecciones<Automovil>("Automovil", Categoria.AUTOMOVIL, vistaPrincipal, "automovil.png");
                vistaTemplate.mostrarEnTabla(automovilDAO.obtenerAutomoviles());
                addAllListenersAutomovil();
            } else if (vistaPrincipal.obtenerSeccionSeleccionada().equalsIgnoreCase(Categoria.SERVICIO.toString())) {
                vistaTemplate = new JFrameSecciones<Automovil>("Servicio", Categoria.SERVICIO, vistaPrincipal, "servicio.png");
                vistaTemplate.mostrarEnTabla(servicioDAO.obtenerServicios());
                addAllListenersServicio();
            }
        }
    }

    //CLASES INTERNAS DE CLIENTES
    private class PrincipalBotonAgregarListenerCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vistaAgregarCliente = new JFrameFormularioAgregarCliente(vistaTemplate);
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
            vistaEditarCliente = new JFrameFormularioEditarCliente((Cliente) vistaTemplate.getSeccion(), vistaPrincipal);
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
            vistaAgregarAutomovil = new JFrameFormularioAgregarAutomovil(vistaTemplate, (ArrayList<String>) clienteDAO.obtenerDNIClientes());
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
            vistaEditarAutomovil = new JFrameFormularioEditarAutomovil((Automovil) vistaTemplate.getSeccion(), vistaTemplate, (ArrayList<String>) clienteDAO.obtenerDNIClientes());
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
            vistaAgregarServicio = new JFrameFormularioAgregarServicio(vistaTemplate, (ArrayList<String>) servicioDAO.obtenerPatentesAutomoviles());
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
            vistaEditarServicio = new JFrameFormularioEditarServicio((Servicio) vistaTemplate.getSeccion(), vistaTemplate, (ArrayList<String>) servicioDAO.obtenerPatentesAutomoviles());
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
