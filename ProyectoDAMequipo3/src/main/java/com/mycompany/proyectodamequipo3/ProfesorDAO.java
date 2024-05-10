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
public class ProfesorDAO implements Repositorio<Profesor> {

    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List listar() {
        List<Profesor> profesores = new ArrayList<>();
         try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT  FROM profesores");) {
            while (rs.next()) {
                Profesor profesor = crearProfesor(rs);
                if (!profesores.add(profesor)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            } 
            

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return profesores;
    }

    @Override
    public Profesor porId(int id) {
         Profesor profesor = null;
        String sql = "SELECT idprofesores,nombre,apellidos,dni,correo,departamento FROM profesores WHERE id=?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    profesor = crearProfesor(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return profesor;
    }

    @Override
    public void guardar(Profesor profesor) {
        String sql = null;
        sql = "INSERT INTO profesores(idprofesores,nombre,apellidos,dni,correo,departamento) VALUES (?,?,?,?,?)";
       
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellidos());
            stmt.setString(3, profesor.getDni());
            stmt.setString(4, profesor.getCorreo());
            stmt.setInt(5, profesor.getDepartamento().getId());
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
        String sql="DELETE FROM profesores WHERE id=?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
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
    
    private Profesor crearProfesor(final ResultSet rs) throws SQLException {
        DepartamentoDAO d=new DepartamentoDAO();
        return new Profesor(rs.getInt("idprofesores"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("dni"),rs.getString("correo"),DepartamentoDAO1.);
    }
}
