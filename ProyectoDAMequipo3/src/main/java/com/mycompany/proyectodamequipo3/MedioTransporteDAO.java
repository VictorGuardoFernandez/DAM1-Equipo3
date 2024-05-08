/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodamequipo3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DAM128
 */
public class MedioTransporteDAO implements Repositorio<MedioTransporte> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<MedioTransporte> listar() {
        List<MedioTransporte> mediosTransporte = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id, nombre, apellidos FROM medios_transporte");) {
            while (rs.next()) {
                MedioTransporte medioTransporte = crearMedioTransporte(rs);
                if (!mediosTransporte.add(medioTransporte)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mediosTransporte;
    }

    @Override
    public MedioTransporte porId(int id) {
        MedioTransporte medioTransporte = null;
        String sql = "SELECT id, nombre, apellidos FROM medios_transporte WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    medioTransporte = crearMedioTransporte(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return medioTransporte;
    }

    @Override
    public void guardar(MedioTransporte medioTransporte) {
        String sql = "INSERT INTO medios_transporte(nombre, apellidos, dni, correo, departamento) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, medioTransporte.getNombre());
            stmt.setString(2, medioTransporte.getApellidos());
            stmt.setString(3, medioTransporte.getDni());
            stmt.setString(4, medioTransporte.getCorreo());
            stmt.setInt(5, medioTransporte.getDepartamento());
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un solo registro");
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM medios_transporte WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private MedioTransporte crearMedioTransporte(final ResultSet rs) throws SQLException {
        return new MedioTransporte(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("dni"), rs.getString("correo"), rs.getInt("departamento"));
    }
}
