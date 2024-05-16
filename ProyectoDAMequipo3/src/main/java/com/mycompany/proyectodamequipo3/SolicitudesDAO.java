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
import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;
/**
 *
 * @author DAM128
 */
public class SolicitudesDAO implements Repositorio<Solicitudes> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Solicitudes> listar() {
        List<Solicitudes> solicitudes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT idsolicitud,tipo_actividad,titulo_actividad,departamento,previsto,medio_transporte,fechaini,horaini,fechafn,horafn,numeroalumnos,alojamiento,comentarios,estado,idprofesores_solicitante FROM solicitudes");) {
            while (rs.next()) {
                Solicitudes solicitud = crearSolicitud(rs);
                if (!solicitudes.add(solicitud)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return solicitudes;
    }

    @Override
    public Solicitudes porId(int id) {
        Solicitudes solicitud = null;
        String sql = "SELECT idsolicitud,tipo_actividad,titulo_actividad,solicitudes.departamento,cod_departamento,nom_departamento,idjefe_departamento,idprofesores_solicitante,nombre,apellidos,dni,correo,previsto,medio_transporte,fechaini,horaini,fechafn,horafn,numeroalumnos,alojamiento,comentarios,estado FROM solicitudes inner join departamentos on departamento=idDepartamentos inner join profesores on idprofesores=idprofesores_solicitante inner join profesor_participantes using(idsolicitud) inner join solicitudes_grupo using(idsolicitud) inner join solicitudes_cursos using(idsolicitud) inner join medio_transporte_has_solicitudes_actividades on idsolicitud=solicitudes_actividades_idsolicitud WHERE idsolicitud=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    solicitud = crearSolicitud(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return solicitud;
    }

    @Override
    public void guardar(Solicitudes solicitud) {
        String sql = "INSERT INTO solicitudes(tipo_actividad,titulo_actividad,departamento,previsto,medio_transporte,fechaini,horaini,fechafn,horafn,numeroalumnos,alojamiento,comentarios,estado,idprofesores_solicitante) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, solicitud.getTipo_actividad());
            stmt.setString(2, solicitud.getTitulo_actividad());
            stmt.setInt(3, solicitud.getDepartamento().getId());
            stmt.setBoolean(4, solicitud.isPrevisto());
            stmt.setBoolean(5, solicitud.isMedio_transporte());
            stmt.setDate(6, Date.valueOf(solicitud.getFechaini()));
            stmt.setTime(7, Time.valueOf(solicitud.getHoraini()));
            stmt.setDate(8, Date.valueOf(solicitud.getFechafn()));
            stmt.setTime(9, Time.valueOf(solicitud.getHorafn()));
            stmt.setString(10, solicitud.getNumeroalumnos());
            stmt.setBoolean(11, solicitud.isAlojamiento());
            stmt.setString(12, solicitud.getComentarios());
            stmt.setString(13, solicitud.getEstado().name());
            stmt.setInt(14, solicitud.getProfesor_solicitante().getId());
            
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
    public void guardarlistaprofep(LinkedList<Profesor> profes, int id){
        for (Profesor profe : profes) {
            String sql = "INSERT INTO profesor_participantes (idsolicitud,idprofesores) values(?,?)";
             try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setInt(1,id);
            stmt.setInt(2, profe.getId());
            
            
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
        
        
    }
    public void guardarlistaprofrer(LinkedList<Profesor> profes, int id){
        for (Profesor profe : profes) {
            String sql = "INSERT INTO profesor_responsable (idsolicitud,idprofesores) values(?,?)";
             try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setInt(1,id);
            stmt.setInt(2, profe.getId());
            
            
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
        
        
    }
    public void guardarlistacursos(LinkedList<Curso> cursos, int id){
        for (Curso curso : cursos) {
            String sql = "INSERT INTO solicitudes_cursos (idsolicitud,cursos_idcurso) values(?,?)";
             try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setInt(1,id);
            stmt.setInt(2, curso.getId());
            
            
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
        
        
    }
    public void guardarlistagrupos(LinkedList<Grupos> grupos, int id){
        for (Grupos grupo : grupos) {
            String sql = "INSERT INTO solicitudes_grupo (idsolicitud,grupo_idgrupo) values(?,?)";
             try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setInt(1,id);
            stmt.setInt(2, grupo.getId());
            
            
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
        
        
    }
    public void guardarlistatransporte(LinkedList<MedioTransporte> transportes, int id){
        for (MedioTransporte transporte : transportes) {
            String sql = "INSERT INTO solicitudes_cursos (medio_transporte_id,solicitudes_actividades_idsolicitud) values(?,?)";
             try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setInt(1,transporte.getId());
            stmt.setInt(2, id);
            
            
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
    }
    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM solicitudes WHERE idsolicitud=?";
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
    
    public LinkedList<Profesor> listarparticipantes(int idsoli){
        ProfesorDAO p=new ProfesorDAO();
        
        LinkedList<Profesor> profesores = new LinkedList<>();
        String sql = "SELECT id,idprofesores from profesor_participantes where idsolicitud=? ";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, idsoli);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    profesores.add(p.porId(rs.getInt("idprofesores")));
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
    public LinkedList<Profesor> listarresponsables(int idsoli){
        ProfesorDAO p=new ProfesorDAO();
        
        LinkedList<Profesor> profesores = new LinkedList<>();
        String sql = "SELECT id,idprofesores from profesor_responsable where idsolicitud=? ";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, idsoli);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    profesores.add(p.porId(rs.getInt("idprofesores")));
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
     public LinkedList<Grupos> listargrupos(int idsoli){
        GruposDAO p=new GruposDAO();
        
        LinkedList<Grupos> grupos = new LinkedList<>();
        String sql = "SELECT id,grupo_idgrupo as grupo from solicitudes_grupo where idsolicitud=? ";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, idsoli);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    grupos.add(p.porId(rs.getInt("grupo")));
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
     public LinkedList<Curso> listarcursos(int idsoli){
        CursosDAO p=new CursosDAO();
        
        LinkedList<Curso> cursos = new LinkedList<>();
        String sql = "SELECT id,cursos_idcursos as curso from solicitudes_cursos where idsolicitud=? ";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, idsoli);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    cursos.add(p.porId(rs.getInt("curso")));
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
     public LinkedList<MedioTransporte> listartransporte(int idsoli){
        MedioTransporteDAO p=new MedioTransporteDAO();
        
        LinkedList<MedioTransporte> transportes = new LinkedList<>();
        String sql = "SELECT id,medio_transporte_id from medio_transporte_has_solicitudes_actividades where solicitudes_actividades_idsolicitud=?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, idsoli);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    transportes.add(p.porId(rs.getInt("medio_transporte_id")));
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return transportes; 
    }
    
    
    private Solicitudes crearSolicitud(final ResultSet rs) throws SQLException {
        Solicitudes.estadosoli estado= Solicitudes.estadosoli.valueOf(rs.getString("estado"));
        DepartamentoDAO1 d=new DepartamentoDAO1();
        ProfesorDAO p=new ProfesorDAO();
        return new Solicitudes(rs.getInt("idsolicitud"),rs.getString("titulo_actividad"),rs.getString("tipo_actividad"),rs.getString("numeroalumnos"),rs.getString("comentarios"),rs.getBoolean("previsto"),rs.getBoolean("medio_transporte"),rs.getBoolean("alojamiento"),rs.getDate("fechaini").toLocalDate(),rs.getDate("fechafn").toLocalDate(),rs.getTime("horaini").toLocalTime(),rs.getTime("horafn").toLocalTime(),d.porId(rs.getInt("departamento")),p.porId(rs.getInt("idprofesores_solicitante")),estado,listarparticipantes(rs.getInt("idsolicitud")),listarresponsables(rs.getInt("idsolicitud")),listargrupos(rs.getInt("idsolicitud")),listarcursos(rs.getInt("idsolicitud")),listartransporte(rs.getInt("idsolicitud")));
    }

    @Override
    public void modificar(Solicitudes t) {
        
    }
}
