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
public class DepartamentoDAO1 implements Repositorio<Departamento> {

    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List listar() {
        List<Departamento> productos = new ArrayList<>();
         try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT id,nombre,cantidad FROM productos");) {
            while (rs.next()) {
                Departamento departamento = crearDepartamento(rs);
                if (!productos.add(departamento)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            } 
            

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return productos;
    }

    @Override
    public Departamento porId(int id) {
         Departamento departamento = null;
        String sql = "SELECT id,nombre,cantidad FROM productos WHERE id=?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    departamento = crearDepartamento(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return departamento;
    }

    @Override
    public void guardar(Departamento departamento) {
        String sql = null;
        sql = "INSERT INTO productos(nombre,apellidos,dni,correo,departamento) VALUES (?,?,?,?,?)";
       
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            
            stmt.setString(1, departamento.getCod_departamento());
            stmt.setString(2, departamento.getNom_departamento());
            stmt.setInt(3, departamento.getIdjefe());
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
    private Departamento crearDepartamento(final ResultSet rs) throws SQLException {
        return new Departamento();
    }
}
