/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodamequipo3;

/**
 *
 * @author DAM128
 */
public class Profesor {
    private String nombre,apellidos,dni,correo;
    private int id;
    private Departamento departamento;

    public Profesor(int id,String nombre,String apellidos, String dni, String correo, Departamento departamento) {
        this.id=id;
        this.nombre=nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo = correo;
        this.departamento = departamento;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    

    @Override
    public String toString() {
        return "Profesor{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", correo=" + correo + ", departamento=" + departamento + '}';
    }

    
    
}
