/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.modelo.clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import taller.interfaces.Constantes;

/**
 *
 * @author Matias
 */
public class ClienteDAO {

    public Collection<Cliente> obtenerClientes() {
        try (Statement stmt = ConexionBD.getConexion().createStatement()) {
            Collection<Cliente> clientes = new ArrayList<>();
            String query = "SELECT * FROM Cliente";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    clientes.add(generarCliente(rs));
                }
                return clientes;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudieron obtener los clientes\n"+ ex.getMessage());
        }
    }

    public Collection<String> obtenerDNIClientes() {
        try (Statement stmt = ConexionBD.getConexion().createStatement()) {
            Collection<String> dniClientes = new ArrayList<>();
            String query = "SELECT dni FROM Cliente";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    dniClientes.add(rs.getString(1));
                }
                return dniClientes;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudieron obtener los dni de los clientes\n"+ ex.getMessage());
        }
    }

    public Collection<Cliente> filtrarClientes(String filtro, String busqueda) {
        try (Statement stmt = ConexionBD.getConexion().createStatement()) {
            Collection<Cliente> clientes = new ArrayList<>();
            String query = "SELECT * FROM Cliente where " + filtro + " LIKE '" + busqueda + "%'";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    clientes.add(generarCliente(rs));
                }
                return clientes;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudieron filtrar los clientes\n"+ ex.getMessage());
        }
    }

    public Cliente obtenerCliente(int id) {
        String query = "SELECT * FROM Cliente WHERE idCliente = ?";
        try (PreparedStatement ps = ConexionBD.getConexion().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                Cliente cliente = generarCliente(rs);
                return cliente;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo obtener clientes con ID " + id+"\n"+ ex.getMessage());
        }

    }

    private Cliente generarCliente(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String dni = rs.getString(2);
        String nombre = rs.getString(3);
        String apellido = rs.getString(4);
        String mail = rs.getString(5);
        int telefono = rs.getInt(6);

        return new Cliente(id, dni, nombre, apellido, mail, telefono);
    }

    public void agregarCliente(Cliente cl) throws SQLException {
        String query = "INSERT INTO Cliente VALUES (null,?,?,?,?,?)";
        try (PreparedStatement ps = ConexionBD.getConexion().prepareStatement(query);) {
            cargarDatosDeClienteEnSentencia(cl, ps);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            if (sqle.getErrorCode() == Constantes.UK_ERROR) {
                throw new RuntimeException("No puede colocar el dni " + cl.getDni() + " debido a que ya esta en la base de datos");
            }
            throw new RuntimeException("No se pudo agregar clientes\n" + sqle.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException("Error\n" + ex.getMessage());
        }
    }

    private void cargarDatosDeClienteEnSentencia(Cliente cl, PreparedStatement ps) throws SQLException {
        ps.setString(1, cl.getDni());
        ps.setString(2, cl.getNombre());
        ps.setString(3, cl.getApellido());
        ps.setString(4, cl.getMail());
        ps.setInt(5, cl.getTelefono());
    }

    public void eliminarCliente(int id) throws SQLException {
        String query = "DELETE FROM Cliente WHERE idCliente = " + id;
        try (Statement s = ConexionBD.getConexion().createStatement()) {
            s.execute(Constantes.ACTIVAR_PRAGMA_FK);
            s.executeUpdate(query);
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo borrar contacto con id " + id +"\n"+ ex.getMessage());
        }
    }

    public void editarCliente(Cliente cl) throws SQLException {
        String campos = "dni = ?, nombre = ?, apellido = ?, mail = ?";
        campos += ", telefono = ?";
        String query = "UPDATE Cliente SET " + campos + " WHERE idCliente = " + cl.getIdCliente();

        try (Statement s = ConexionBD.getConexion().createStatement()) {
            s.execute(Constantes.ACTIVAR_PRAGMA_FK);
            try (PreparedStatement ps = ConexionBD.getConexion().prepareStatement(query)) {
                cargarDatosDeClienteEnSentencia(cl, ps);
                ps.executeUpdate();
            }
        } catch (SQLException sqle) {
            if (sqle.getErrorCode() == Constantes.UK_ERROR) {
                throw new RuntimeException("No puede colocar el dni " + cl.getDni() + " debido a que ya esta en la base de datos");
            }
            throw new RuntimeException("No se pudo agregar clientes\n" + sqle.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException("Error\n" + ex.getMessage());
        }

    }

}
