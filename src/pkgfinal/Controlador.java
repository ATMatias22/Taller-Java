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
import taller.modelo.clases.Automovil;
import taller.modelo.clases.AutomovilDAO;
import taller.modelo.clases.TipoSeccion;
import taller.modelo.clases.Cliente;
import taller.modelo.clases.ClienteDAO;
import taller.modelo.clases.Servicio;
import taller.modelo.clases.ServicioDAO;
import taller.vista.clases.JFrameAutomovil;
import taller.vista.clases.JFrameCliente;
import taller.vista.clases.JFrameFormularioAgregarCliente;
import taller.vista.clases.JFrameFormularioAgregarAutomovil;
import taller.vista.clases.JFrameFormularioAgregarServicio;
import taller.vista.clases.JFrameFormularioEditarAutomovil;
import taller.vista.clases.JFrameFormularioEditarCliente;
import taller.vista.clases.JFrameFormularioEditarServicio;
import taller.vista.clases.JFrameListarAutomovilesAntiguedad;
import taller.vista.clases.JFramePrincipal;
import taller.vista.clases.JFrameServicio;

/**
 *
 * @author Matias
 */
public class Controlador {

    private JFramePrincipal vistaPrincipal;
    private ClienteDAO clienteDAO;
    private AutomovilDAO automovilDAO;
    private ServicioDAO servicioDAO;
    private JFrameCliente<Cliente> vistaCliente;
    private JFrameAutomovil<Automovil> vistaAutomovil;
    private JFrameServicio<Servicio> vistaServicio;
    private JFrameFormularioEditarCliente vistaEditarCliente;
    private JFrameFormularioEditarAutomovil vistaEditarAutomovil;
    private JFrameFormularioEditarServicio vistaEditarServicio;
    private JFrameFormularioAgregarCliente vistaAgregarCliente;
    private JFrameFormularioAgregarAutomovil vistaAgregarAutomovil;
    private JFrameFormularioAgregarServicio vistaAgregarServicio;
    private JFrameListarAutomovilesAntiguedad vistaListarAutomoviles;

    public void iniciar() {
        clienteDAO = new ClienteDAO();
        automovilDAO = new AutomovilDAO();
        servicioDAO = new ServicioDAO();
        vistaPrincipal = new JFramePrincipal();
        vistaPrincipal.seleccionDeVentana(new SeccionElegida());
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
        vistaServicio.addActionListenerListarAutomoviles(new PrincipalBotonListarAutomovilesAntiguedadListenerServicio());
    }

    //---------------------------------------------------CLIENTES------------------------------------------------------------------
    public void agregarCliente() {
        if (vistaAgregarCliente.confirmacion("Esta seguro que desea agregar a este cliente ")) {
            try {
                clienteDAO.agregarCliente(this.vistaAgregarCliente.getCliente());
                vistaAgregarCliente.mostrarMensaje("Se agrego cliente");
                vistaCliente.actualizarListaTabla(clienteDAO.obtenerClientes());
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
                vistaCliente.actualizarListaTabla(clienteDAO.obtenerClientes());
                vistaCliente.mostrarMensaje("Se elimino el cliente");
            }
        } catch (Exception ex) {
            vistaCliente.mostrarMensajeError(ex.getMessage());
        }

    }

    public void editarCliente() {
        if (vistaEditarCliente.confirmacion("Esta seguro que desea editar al cliente")) {
            try {
                clienteDAO.editarCliente(vistaEditarCliente.getCliente());
                vistaEditarCliente.mostrarMensaje("Se edito el cliente");
                vistaCliente.actualizarListaTabla(clienteDAO.obtenerClientes());
            } catch (Exception ex) {
                vistaEditarCliente.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void filtrarCliente() {
        vistaCliente.actualizarListaTabla(clienteDAO.filtrarClientes(vistaCliente.buscarEquivalenteDelFiltroEnBD(vistaCliente.obtenerFiltroSeleccionado()), vistaCliente.obtenerBusqueda()));
    }

    //---------------------------------------------------AUTOMOVILES------------------------------------------------------------------
    public void agregarAutomovil() {
        if (vistaAgregarAutomovil.confirmacion("Esta seguro que desea agregar a este automovil ")) {
            try {
                automovilDAO.agregarAutomovil(this.vistaAgregarAutomovil.getAutomovilAAgregar());
                vistaAgregarAutomovil.mostrarMensaje("Se agrego automovil");
                vistaAutomovil.actualizarListaTabla(automovilDAO.obtenerAutomoviles());
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
                vistaAutomovil.actualizarListaTabla(automovilDAO.obtenerAutomoviles());
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
                vistaAutomovil.actualizarListaTabla(automovilDAO.obtenerAutomoviles());
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
                vistaAutomovil.actualizarListaTabla(automovilDAO.obtenerAutomoviles());
            } catch (Exception ex) {
                vistaEditarAutomovil.mostrarMensajeError(ex.getMessage());
            }
        }
    }
    

    public void filtrarAutomovil() {
        vistaAutomovil.actualizarListaTabla(automovilDAO.filtrarAutomoviles(vistaAutomovil.buscarEquivalenteDelFiltroEnBD(vistaAutomovil.obtenerFiltroSeleccionado()), vistaAutomovil.obtenerBusqueda()));
    }

    //---------------------------------------------------SERVICIOS------------------------------------------------------------------
    public void agregarServicio() {
        if (vistaAgregarServicio.confirmacion("Esta seguro que desea agregar a este servicio ")) {
            try {
                servicioDAO.agregarServicio(this.vistaAgregarServicio.getServicio());
                vistaAgregarServicio.mostrarMensaje("Se agrego servicio");
                vistaServicio.actualizarListaTabla(servicioDAO.obtenerServicios());
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
                vistaServicio.actualizarListaTabla(servicioDAO.obtenerServicios());
                vistaServicio.mostrarMensaje("Se elimino el servicio");
            }
        } catch (Exception ex) {
            vistaServicio.mostrarMensajeError(ex.getMessage());
        }

    }

    public void editarServicio() {
        if (vistaEditarServicio.confirmacion("Esta seguro que desea editar al servicio")) {
            try {
                servicioDAO.editarServicio(vistaEditarServicio.getServicio());
                vistaEditarServicio.mostrarMensaje("Se edito el servicio");
                vistaServicio.actualizarListaTabla(servicioDAO.obtenerServicios());
            } catch (Exception ex) {
                vistaEditarServicio.mostrarMensajeError(ex.getMessage());
            }
        }
    }

    public void filtrarServicio() {
        vistaServicio.actualizarListaTabla(servicioDAO.filtrarServicio(vistaServicio.buscarEquivalenteDelFiltroEnBD(vistaServicio.obtenerFiltroSeleccionado()), vistaServicio.obtenerBusqueda()));
    }

    
    
    //---------------------------------------------------CLASES INTERNAS ------------------------------------------------------------------

    private class SeccionElegida implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TipoSeccion cat = vistaPrincipal.devolverSeccionSeleccionada();
            if (cat.equals(TipoSeccion.CLIENTE)) {
                if(vistaCliente != null){
                    vistaCliente.cerrar();
                }
                vistaCliente = new JFrameCliente(vistaPrincipal);
                vistaCliente.mostrarEnTabla(clienteDAO.obtenerClientes());
                addAllListenersCliente();
            } else if (cat.equals(TipoSeccion.AUTOMOVIL)) {
                if(vistaAutomovil != null){
                    vistaAutomovil.cerrar();
                }
                vistaAutomovil = new JFrameAutomovil(vistaPrincipal);
                vistaAutomovil.mostrarEnTabla(automovilDAO.obtenerAutomoviles());
                addAllListenersAutomovil();
            } else if (cat.equals(TipoSeccion.SERVICIO)) {
                if(vistaServicio != null){
                    vistaServicio.cerrar();
                }
                vistaServicio = new JFrameServicio(vistaPrincipal);
                vistaServicio.mostrarEnTabla(servicioDAO.obtenerServicios());
                addAllListenersServicio();
            }
        }
    }

    //---------------------------------------------------CLASES INTERNAS DE CLIENTE ------------------------------------------------------------------

    private class PrincipalBotonAgregarListenerCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (vistaAgregarCliente != null) {
                vistaAgregarCliente.cerrar();
            }
            vistaAgregarCliente = new JFrameFormularioAgregarCliente(vistaCliente);
            vistaAgregarCliente.addActionListenerAccionBoton(new HandlerJFrameAgregarBotonAgregarCliente());
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
            if (vistaEditarCliente != null) {
                vistaEditarCliente.cerrar();
            }
            vistaEditarCliente = new JFrameFormularioEditarCliente(vistaCliente.getCliente(), vistaPrincipal);
            vistaEditarCliente.addActionListenerAccionBoton(new HandlerJFrameEditarBotonEditarCliente());
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

    //---------------------------------------------------CLASES INTERNAS DE AUTOMOVIL ------------------------------------------------------------------

    private class PrincipalBotonAgregarListenerAutomovil implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (vistaAgregarAutomovil != null) {
                vistaAgregarAutomovil.cerrar();
            }
            vistaAgregarAutomovil = new JFrameFormularioAgregarAutomovil(vistaAutomovil, clienteDAO.obtenerDNIClientes());
            vistaAgregarAutomovil.addActionListenerAccionBoton(new HandlerJFrameAgregarBotonAgregarAutomovil());
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
            if (vistaEditarAutomovil != null) {
                vistaEditarAutomovil.cerrar();
            }

            vistaEditarAutomovil = new JFrameFormularioEditarAutomovil(vistaAutomovil.getAutomovil(), vistaAutomovil, clienteDAO.obtenerDNIClientes());
            vistaEditarAutomovil.addActionListenerAccionBoton(new HandlerJFrameEditarBotonEditarAutomovil());
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

    //---------------------------------------------------CLASES INTERNAS DE SERVICIO ------------------------------------------------------------------

    private class PrincipalBotonAgregarListenerServicio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (vistaAgregarServicio != null) {
                vistaAgregarServicio.cerrar();
            }
            vistaAgregarServicio = new JFrameFormularioAgregarServicio(vistaServicio, servicioDAO.obtenerPatentesAutomoviles());
            vistaAgregarServicio.addActionListenerAccionBoton(new HandlerJFrameAgregarBotonAgregarServicio());
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
            if (vistaEditarServicio != null) {
                vistaEditarServicio.cerrar();
            }
            vistaEditarServicio = new JFrameFormularioEditarServicio(vistaServicio.getServicio(), vistaServicio, servicioDAO.obtenerPatentesAutomoviles());
            vistaEditarServicio.addActionListenerAccionBoton(new HandlerJFrameEditarBotonEditarServicio());
        }
    }
    
    private class PrincipalBotonListarAutomovilesAntiguedadListenerServicio implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
             if (vistaListarAutomoviles != null) {
                vistaListarAutomoviles.cerrar();
            }
             vistaListarAutomoviles = new JFrameListarAutomovilesAntiguedad(servicioDAO.listarAutomovilesConAntiguedadYUnSoloServicio(), vistaServicio);
            
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
