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
public class GruposDAO implements Repositorio<Grupos> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    // recuperamos todos los registros de la bd
    @Override
    public List<Grupos> listar() {
        List<Grupos> grupos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT idgrupo,num_alumnos,grupo.activo as activog,codgrupo,cursos.idcurso,codcurso,desc_curso,etapa,cursos.activo as activoc FROM grupo inner join cursos using(idcurso)");) {
            while (rs.next()) {
                Grupos grupo = crearGrupo(rs);
                if (!grupos.add(grupo)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return grupos;
    }

    // recuperamos objeto por clave primaria
    @Override
    public Grupos porId(int id) {
        Grupos grupo = null;
        String sql = "SELECT idgrupo,num_alumnos,grupo.activo as activog,codgrupo,cursos.idcurso,codcurso,desc_curso,etapa,cursos.activo as activoc FROM grupo inner join cursos using(idcurso)  WHERE idgrupo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    grupo = crearGrupo(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return grupo;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    @Override
    public void guardar(Grupos grupo) {
        String sql = null;
        sql = "INSERT INTO grupo(idgrupo,idcurso,num_alumnos,activo,codgrupo) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, grupo.getId());
            stmt.setInt(2, grupo.getCurso().getId());
            stmt.setInt(3, grupo.getNum_alumnos());
            stmt.setBoolean(4, grupo.isActivo());
            stmt.setString(5, grupo.getCodgrupo());
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

        String sql = "DELETE FROM grupo WHERE idgrupo=?";
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

    private Grupos crearGrupo(final ResultSet rs) throws SQLException {
        Curso curso=new Curso(rs.getString("codcurso"),rs.getString("desc_curso"),rs.getString("etapa"),rs.getBoolean("activoc"),rs.getInt("idcurso"));
        return new Grupos(rs.getInt("idgrupo"),curso,rs.getInt("num_alumnos"),rs.getBoolean("activog"),rs.getString("codgrupo"));
    }

    @Override
    public void modificar(Grupos t) {
         String sql = null;
       
            
            sql="update grupo set idcurso=?,num_alumnos=?,activo=?,codgrupo=? where idgrupo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setInt(1,t.getCurso().getId());
            stmt.setInt(2, t.getNum_alumnos());
            stmt.setBoolean(3, t.isActivo());
            stmt.setString(4,t.getCodgrupo());
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
}
