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
public class PerfilAccesoDAO implements Repositorio<PerfilAcceso> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<PerfilAcceso> listar() {
        List<PerfilAcceso> perfiles = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id, nombre, apellidos FROM perfiles_acceso");) {
            while (rs.next()) {
                PerfilAcceso perfil = crearPerfil(rs);
                if (!perfiles.add(perfil)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return perfiles;
    }

    @Override
    public PerfilAcceso porId(int id) {
        PerfilAcceso perfil = null;
        String sql = "SELECT idprofesor,tipo,correo,password,nombre,apellidos,dni,correo,departamento FROM perfil_acceso inner join profesores on idprofesor=idprofesores WHERE idprofesor=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    perfil = crearPerfil(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return perfil;
    }

    @Override
    public void guardar(PerfilAcceso perfil) {
        String sql = "INSERT INTO perfil_acceso(idprofesor,tipo,correo,password) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setInt(1, perfil.getIdprofesor().getId());
            stmt.setString(2, perfil.getTipo());
            stmt.setString(3, perfil.getCorreo());
            stmt.setString(4, perfil.getPassword());
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
        String sql = "DELETE FROM perfiles_acceso WHERE id=?";
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

    private PerfilAcceso crearPerfil(final ResultSet rs) throws SQLException {
        return new PerfilAcceso(Profesor profesor=new Profesor(rs.getInt("idprofesor"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("dni"),rs.getString("correo"),),rs.getString("tipo"),rs.getString(3),rs.getString(4));
    }
}
