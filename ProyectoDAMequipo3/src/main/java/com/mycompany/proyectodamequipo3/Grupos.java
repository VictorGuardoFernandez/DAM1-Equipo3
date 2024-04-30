/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodamequipo3;

/**
 *
 * @author DAM128
 */
public class Grupos {
    private int idcurso,num_alumnos;
    private boolean activo;
    private String codgrupo;

    public Grupos(int idcurso, int num_alumnos, boolean activo, String codgrupo) {
        this.idcurso = idcurso;
        this.num_alumnos = num_alumnos;
        this.activo = activo;
        this.codgrupo = codgrupo;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getNum_alumnos() {
        return num_alumnos;
    }

    public void setNum_alumnos(int num_alumnos) {
        this.num_alumnos = num_alumnos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getCodgrupo() {
        return codgrupo;
    }

    public void setCodgrupo(String codgrupo) {
        this.codgrupo = codgrupo;
    }

    @Override
    public String toString() {
        return "Grupos{" + "idcurso=" + idcurso + ", num_alumnos=" + num_alumnos + ", activo=" + activo + ", codgrupo=" + codgrupo + '}';
    }
    
}
