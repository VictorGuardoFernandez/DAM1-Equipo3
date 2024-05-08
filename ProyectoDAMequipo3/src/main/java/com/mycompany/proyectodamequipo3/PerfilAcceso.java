/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodamequipo3;

/**
 *
 * @author DAM128
 */
public class PerfilAcceso {
    private Profesor idprofesor;
    public enum tiposAcceso{superusuario,administrador,equipo_directivo,profesor};
    private tiposAcceso tipo;
    private String correo,password;

    public PerfilAcceso(Profesor idprofesor, tiposAcceso tipo, String correo, String password) {
        this.idprofesor = idprofesor;
        this.tipo = tipo;
        this.correo = correo;
        this.password = password;
    }

    public Profesor getIdprofesor() {
        return idprofesor;
    }

    public String getTipo() {
        return tipo.name();
    }

    public void setIdprofesor(Profesor idprofesor) {
        this.idprofesor = idprofesor;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PerfilAcceso{" + "idprofesor=" + idprofesor + ", correo=" + correo + ", password=" + password + '}';
    }
    
}
