package com.mycompany.proyectodamequipo3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DAM128
 */
public class Curso {
    private int id;
    private String codcurso,desc_curso,etapa;
    private boolean activo;

    public Curso(String codcurso, String desc_curso, String etapa, boolean activo,int id) {
        this.codcurso = codcurso;
        this.desc_curso = desc_curso;
        this.etapa = etapa;
        this.activo = activo;
        this.id=id;
    }

    public String getCodcurso() {
        return codcurso;
    }

    public void setCodcurso(String codcurso) {
        this.codcurso = codcurso;
    }

    public String getDesc_curso() {
        return desc_curso;
    }

    public void setDesc_curso(String desc_curso) {
        this.desc_curso = desc_curso;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Curso{" + "codcurso=" + codcurso + ", desc_curso=" + desc_curso + ", etapa=" + etapa + ", activo=" + activo + '}';
    }
    
}
