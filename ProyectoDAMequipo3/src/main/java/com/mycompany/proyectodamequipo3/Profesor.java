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
    private String nombre_apellidos,dni,correo;
    private int departamento;

    public Profesor(String nombre_apellidos, String dni, String correo, int departamento) {
        this.nombre_apellidos = nombre_apellidos;
        this.dni = dni;
        this.correo = correo;
        this.departamento = departamento;
    }

    public String getNombre_apellidos() {
        return nombre_apellidos;
    }

    public void setNombre_apellidos(String nombre_apellidos) {
        this.nombre_apellidos = nombre_apellidos;
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

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Profesor{" + "nombre_apellidos=" + nombre_apellidos + ", dni=" + dni + ", correo=" + correo + ", departamento=" + departamento + '}';
    }
    
}
