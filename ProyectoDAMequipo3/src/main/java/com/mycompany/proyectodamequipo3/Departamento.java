/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodamequipo3;

/**
 *
 * @author DAM128
 */
public class Departamento {
    private String cod_departamento,nom_departamento;
    private int idjefe;

    public Departamento(String cod_departamento, String nom_departamento, int idjefe) {
        this.cod_departamento = cod_departamento;
        this.nom_departamento = nom_departamento;
        this.idjefe = idjefe;
    }

    public String getCod_departamento() {
        return cod_departamento;
    }

    public void setCod_departamento(String cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public String getNom_departamento() {
        return nom_departamento;
    }

    public void setNom_departamento(String nom_departamento) {
        this.nom_departamento = nom_departamento;
    }

    public int getIdjefe() {
        return idjefe;
    }

    public void setIdjefe(int idjefe) {
        this.idjefe = idjefe;
    }

    @Override
    public String toString() {
        return "Departamento{" + "cod_departamento=" + cod_departamento + ", nom_departamento=" + nom_departamento + ", idjefe=" + idjefe + '}';
    }
    
}
