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
    private int num_alumnos,id;
    private boolean activo;
    private String codgrupo;
    private Curso curso;

    public Grupos(Curso idcurso, int num_alumnos, boolean activo, String codgrupo) {
        this.curso = idcurso;
        this.num_alumnos = num_alumnos;
        this.activo = activo;
        this.codgrupo = codgrupo;
    }

    public int getId() {
        return id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        return "Grupos{" + "num_alumnos=" + num_alumnos + ", id=" + id + ", activo=" + activo + ", codgrupo=" + codgrupo + ", curso=" + curso + '}';
    }
   
    
}
