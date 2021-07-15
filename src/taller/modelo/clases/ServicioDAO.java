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
import java.util.Date;

/**
 *
 * @author Matias
 */
public class ServicioDAO {
    public Collection<Servicio> obtenerServicios() {
        try (Statement stmt = ConexionBD.getConexion().createStatement()) {
            Collection<Servicio> servicios = new ArrayList<>();
            String query = "SELECT * FROM Servicio";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    servicios.add(generarServicio(rs));
                }
                return servicios;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudieron obtener los servicios", ex);
        }
    }
    
     public Collection<String> obtenerPatentesAutomoviles() {
        try (Statement stmt = ConexionBD.getConexion().createStatement()) {
            Collection<String> patenteAutomoviles = new ArrayList<>();
            String query = "SELECT patente FROM Automovil";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    patenteAutomoviles.add(rs.getString(1));
                }
                return patenteAutomoviles;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudieron obtener las patentes de los automoviles", ex);
        }
    }


    public Collection<Servicio> filtrarServicio(String filtro, String busqueda) {
        try (Statement stmt = ConexionBD.getConexion().createStatement()) {
            Collection<Servicio> servicios = new ArrayList<>();
            String query = "SELECT * FROM Servicio where "+filtro+ " LIKE '"+ busqueda+ "%'";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    servicios.add(generarServicio(rs));
                }
                return servicios;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudieron filtrar los servicios", ex);
        }
    }

    public Servicio obtenerServicio(int id) {
        String query = "SELECT * FROM Servicio WHERE idServicio = ?";
        try (PreparedStatement ps = ConexionBD.getConexion().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                Servicio servicio = generarServicio(rs);
                return servicio;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo obtener el servicio con ID " + id, ex);
        }

    }

    private Servicio generarServicio(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        Date fechaRealizacion = rs.getDate(2);
        double costo = rs.getDouble(3);
        String patenteAutomovil = rs.getString(4);
        int cantKMS = rs.getInt(5);

        return new Servicio(id, fechaRealizacion, costo, patenteAutomovil, cantKMS);
    }

    public void agregarServicio(Servicio se) throws SQLException {
        String query = "INSERT INTO Servicio VALUES (null,?,?,?,?)";
        try (PreparedStatement ps = ConexionBD.getConexion().prepareStatement(query);) {
            cargarDatosDeServicioEnSentencia(se, ps);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo agregar servicio\n" + se +" "+ ex.getMessage());
        }
    }
    
    

    private void cargarDatosDeServicioEnSentencia(Servicio se, PreparedStatement ps) throws SQLException {
        ps.setObject(1,se.getFechaDeRealizacion());
        ps.setDouble(2, se.getCosto());
        ps.setString(3, se.getPatenteDelAutomovil());
        ps.setInt(4, se.getCantKms());
    }

    public void eliminarServicio(int id) throws SQLException {
        String query = "DELETE FROM Servicio WHERE idServicio = ?";
        try (PreparedStatement ps = ConexionBD.getConexion().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo borrar el servicio con id " + id, ex);
        }
    }

    public void editarServicio(Servicio se) throws SQLException {
        String campos = "fechaDeRealizacion = ?, costo = ?, patenteDelAutomovil = ?, cantKms = ?";
        String query = "UPDATE Servicio SET " + campos + " WHERE idServicio = " + se.getIdServicio();
        try (PreparedStatement ps = ConexionBD.getConexion().prepareStatement(query)) {
            cargarDatosDeServicioEnSentencia(se, ps);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo actualizar el servicio\n" + se, ex);
        }
    }
}
