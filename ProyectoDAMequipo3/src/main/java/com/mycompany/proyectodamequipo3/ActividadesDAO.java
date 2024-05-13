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
public class ActividadesDAO implements Repositorio<Actividades> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Actividades> listar() {
        List<Actividades> actividades = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT idsolicitud,tipo_actividad,titulo_actividad,departamento,previsto,medio_transporte,fechaini,horaini,fechafn,horafn,numeroalumnos,alojamiento,comentarios FROM solicitudes_actividades");) {
            while (rs.next()) {
                Actividades actividad = crearActividad(rs);
                if (!actividades.add(actividad)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return actividades;
    }

    @Override
    public Actividades porId(int id) {
        Actividades actividad = null;
        String sql = "SELECT id, nombre, apellidos FROM actividades WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    actividad = crearActividad(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return actividad;
    }

    @Override
    public void guardar(Actividades actividad) {
        String sql = "INSERT INTO actividades(nombre, apellidos, dni, correo, departamento) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, actividad.getNombre());
            stmt.setString(2, actividad.getApellidos());
            stmt.setString(3, actividad.getDni());
            stmt.setString(4, actividad.getCorreo());
            stmt.setInt(5, actividad.getDepartamento());
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
        String sql = "DELETE FROM actividades WHERE id=?";
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
    @Override
    public void modificar(Actividades t) {
       String sql = null;
       
            
            sql="update cursos set codcurso=?,desc_curso=?,etapa=?,activo=? where idcurso=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1,t.getCodcurso());
            stmt.setString(2, t.getDesc_curso());
            stmt.setString(3, t.getEtapa());
            stmt.setBoolean(4, t.isActivo());
            stmt.setInt(5,t.getId());
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha modificado un solo registro");
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Actividades crearActividad(final ResultSet rs) throws SQLException {
        return new Actividades(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("dni"), rs.getString("correo"), rs.getInt("departamento"));
    
