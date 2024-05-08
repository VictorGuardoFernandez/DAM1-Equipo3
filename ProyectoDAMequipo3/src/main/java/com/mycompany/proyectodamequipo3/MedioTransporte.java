/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodamequipo3;

/**
 *
 * @author DAM128
 */
public class MedioTransporte {
    private int id;
    public enum tipostransporte{andando,bici,bus,taxi,barco,tren,avion};
    private tipostransporte tipo;

    public MedioTransporte(int id, tipostransporte tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    
}

