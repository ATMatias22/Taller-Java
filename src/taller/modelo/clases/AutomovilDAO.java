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
public class AutomovilDAO {
    

    public Collection<Automovil> obtenerAutomoviles() {
        try (Statement stmt = ConexionBD.getConexion().createStatement()) {
            Collection<Automovil> automoviles = new ArrayList<>();
            String query = "SELECT * FROM Automovil";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    automoviles.add(generarAutomovil(rs));
                }
                return automoviles;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudieron obtener los automoviles\n"+ ex.getMessage());
        }
    }

    public Collection<Automovil> filtrarAutomoviles(String filtro, String busqueda) {
        try (Statement stmt = ConexionBD.getConexion().createStatement()) {
            Collection<Automovil> automoviles = new ArrayList<>();
            String query = "SELECT * FROM Automovil where " + filtro + " LIKE '" + busqueda + "%'";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    automoviles.add(generarAutomovil(rs));
                }
                return automoviles;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudieron filtrar los automoviles\n" +ex.getMessage());
        }
    }

    public Automovil obtenerAutomovil(int id) {
        String query = "SELECT * FROM Automovil WHERE idAutomovil = ?";
        try (PreparedStatement ps = ConexionBD.getConexion().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                Automovil automovil = generarAutomovil(rs);
                return automovil;
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo obtener el automovil con ID " + id +"\n"+ex.getMessage());
        }

    }

    private Automovil generarAutomovil(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String patente = rs.getString(2);
        String marca = rs.getString(3);
        String modelo = rs.getString(4);
        int anioFabricacion = rs.getInt(5);
        String dniCliente = rs.getString(6);

        return new Automovil(id, patente, marca, modelo, anioFabricacion, dniCliente);
    }

    public void agregarAutomovil(Automovil au) throws SQLException {
        String query = "INSERT INTO Automovil VALUES (null,?,?,?,?,?)";
        try (PreparedStatement ps = ConexionBD.getConexion().prepareStatement(query);) {
            cargarDatosDeAutomovilEnSentencia(au, ps);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            if (sqle.getErrorCode() == Constantes.UK_ERROR) {
                throw new RuntimeException("No puede colocar la patente " + au.getPatente() + " debido a que ya esta en la base de datos");
            }
            throw new RuntimeException("No se pudieron agregar los datos \n" + sqle.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException("Error \n"+ ex.getMessage());
        }
    }

    public void agregarAutomovilConCliente(Automovil au, Cliente cl) throws SQLException {
        ConexionBD.getConexion().setAutoCommit(false);
        String queryAutomovil = "INSERT INTO Automovil VALUES (null,?,?,?,?,?)";
        String queryCliente = "INSERT INTO Cliente VALUES (null,?,?,?,?,?)";

        int numeroError = 0;
        //COLOCAMOS NUMEROS PARA DETECTAR EL ERROR DE LA CLAVE UNIQUE, COMO EL ERRORCODE ES EL 19 Y EN EL CASO QUE HAYA UN ERROR
        //EN AMBAS CLAVES UNICAS (EN EL CLIENTE EL DNI Y EN EL AUTO LA PATENTE), DISTINGAMOS QUE ERROR TIRAR YA QUE AMBOS
        //SON ERRORCODE 19 (EL 0 INDICA QUE HUBO UN ERROR EN EL DNI Y EL 1 INDICA QUE HUBO ERROR EN LA PATENTE)

        try (PreparedStatement ps = ConexionBD.getConexion().prepareStatement(queryCliente)) {
            cargarDatosDeClienteEnSentencia(cl, ps);
            ps.executeUpdate();
            try (PreparedStatement pr = ConexionBD.getConexion().prepareStatement(queryAutomovil)) {
                numeroError = 1;
                cargarDatosDeAutomovilEnSentencia(au, pr);
                pr.executeUpdate();
            }
            ConexionBD.getConexion().commit();
        } catch (SQLException sqle) {
            ConexionBD.getConexion().rollback();
            if (sqle.getErrorCode() == Constantes.UK_ERROR) {
                if (numeroError == 0) {
                    throw new RuntimeException("No puede colocar el dni " + cl.getDni() + " debido a que ya esta en la base de datos");
                } else {
                    throw new RuntimeException("No puede colocar la patente " + au.getPatente() + " debido a que ya esta en la base de datos");
                }
            }
            throw new RuntimeException("No se pudieron agregar los datos \n"+ sqle.getMessage());
        } catch (Exception ex) {
            ConexionBD.getConexion().rollback();
            throw new RuntimeException("Error \n" + ex.getMessage());
        } finally {
            ConexionBD.getConexion().setAutoCommit(true);
        }
    }

    private void cargarDatosDeClienteEnSentencia(Cliente cl, PreparedStatement ps) throws SQLException {
        ps.setString(1, cl.getDni());
        ps.setString(2, cl.getNombre());
        ps.setString(3, cl.getApellido());
        ps.setString(4, cl.getMail());
        ps.setInt(5, cl.getTelefono());
    }

    private void cargarDatosDeAutomovilEnSentencia(Automovil au, PreparedStatement ps) throws SQLException {
        ps.setString(1, au.getPatente());
        ps.setString(2, au.getMarca());
        ps.setString(3, au.getModelo());
        ps.setInt(4, au.getAnioFabricacion());
        ps.setString(5, au.getDniCliente());
    }

    public void eliminarAutomovil(int id) throws SQLException {
        String query = "DELETE FROM Automovil WHERE idAutomovil = " + id;
        try (Statement s = ConexionBD.getConexion().createStatement()) {
            s.execute(Constantes.ACTIVAR_PRAGMA_FK);
            s.executeUpdate(query);
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo borrar el automovil con id " + id +"\n"+ex.getMessage());
        }
    }

    public void editarAutomovil(Automovil au) throws SQLException {
        String campos = "patente = ?, marca = ?, modelo = ?, anioFabricacion = ?";
        campos += ", dniCliente = ?";
        String query = "UPDATE Automovil SET " + campos + " WHERE idAutomovil = " + au.getIdAutomovil();

        try (Statement s = ConexionBD.getConexion().createStatement()) {
            s.execute(Constantes.ACTIVAR_PRAGMA_FK);
            try (PreparedStatement ps = ConexionBD.getConexion().prepareStatement(query)) {
                cargarDatosDeAutomovilEnSentencia(au, ps);
                ps.executeUpdate();
            }
        }catch (SQLException sqle) {
            if (sqle.getErrorCode() == Constantes.UK_ERROR) {
                throw new RuntimeException("No puede colocar la patente " + au.getPatente() + " debido a que ya esta en la base de datos");
            }
            throw new RuntimeException("No se pudieron agregar los datos \n"+ sqle.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException("Error\n" + ex.getMessage());
        }


    }

    //----------------------------------------------------------------------------------
}
