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
public class CursosDAO implements Repositorio<Curso> {
     // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    // recuperamos todos los registros de la bd
    @Override
    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,nombre,cantidad FROM cursos");) {
            while (rs.next()) {
                Curso curso = crearCurso(rs);
                if (!cursos.add(curso)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cursos;
    }

    // recuperamos objeto por clave primaria
    @Override
    public Curso porId(int id) {
        Curso curso = null;
        String sql = "SELECT id,nombre,cantidad FROM cursos WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    curso = crearCurso(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return curso;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    @Override
    public void guardar(Curso curso) {
        String sql = null;
       
            sql = "INSERT INTO cursos(nombre,cantidad) VALUES (?,?)";
       
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, curso.getNombre());
            stmt.setInt(2, curso.getCantidad());
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

    // borrar en la base de datos por clave primaria
    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM cursos WHERE id=?";
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

    private Curso crearCurso(final ResultSet rs) throws SQLException {
        return new Curso(rs.getInt("id"), rs.getString("nombre"), rs.getInt("cantidad"));
    }
}

