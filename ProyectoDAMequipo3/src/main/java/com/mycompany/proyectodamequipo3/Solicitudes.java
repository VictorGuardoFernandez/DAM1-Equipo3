/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodamequipo3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

/**
 *
 * @author DAM128
 */
public class Solicitudes {
    private String titulo_actividad,tipo_actividad,numeroalumnos,comentarios;
    private boolean previsto,medio_transporte,alojamiento;
    private LocalDate fechaini,fechafn;
    private LocalTime horaini,horafn;
    private int id;
    private Departamento departamento;
    private Profesor profesor_solicitante;
    public enum estadosoli{solicitado,aprobado,denegado,realizado};
    private estadosoli estado;
    private LinkedList<Profesor> participantes;
    private LinkedList<Grupos> grupos;
    private LinkedList<Curso> cursos;
    private LinkedList<MedioTransporte> transporte;
    private LinkedList<Profesor>responsables;

    public Solicitudes(int id,String titulo_actividad, String tipo_actividad, String numeroalumnos, String comentarios, boolean previsto, boolean medio_transporte, boolean alojamiento, LocalDate fechaini, LocalDate fechafn, LocalTime horaini, LocalTime horafn, Departamento departamento, Profesor profesor_solicitante, estadosoli estado, LinkedList<Profesor> participantes,LinkedList<Profesor> responsables, LinkedList<Grupos> grupos, LinkedList<Curso> cursos, LinkedList<MedioTransporte> transporte) {
        this.titulo_actividad = titulo_actividad;
        this.tipo_actividad = tipo_actividad;
        this.numeroalumnos = numeroalumnos;
        this.comentarios = comentarios;
        this.previsto = previsto;
        this.medio_transporte = medio_transporte;
        this.alojamiento = alojamiento;
        this.fechaini = fechaini;
        this.fechafn = fechafn;
        this.horaini = horaini;
        this.horafn = horafn;
        this.id = id;
        this.departamento = departamento;
        this.profesor_solicitante = profesor_solicitante;
        this.estado = estado;
        this.participantes = participantes;
        this.grupos = grupos;
        this.cursos = cursos;
        this.transporte = transporte;
        this.responsables=responsables;
    }

    public Solicitudes(int id,String titulo_actividad, String tipo_actividad, String numeroalumnos, String comentarios, boolean previsto, boolean medio_transporte, boolean alojamiento, LocalDate fechaini, LocalDate fechafn, LocalTime horaini, LocalTime horafn, Departamento departamento, Profesor profesor_solicitante, estadosoli estado) {
        this.titulo_actividad = titulo_actividad;
        this.tipo_actividad = tipo_actividad;
        this.numeroalumnos = numeroalumnos;
        this.comentarios = comentarios;
        this.previsto = previsto;
        this.medio_transporte = medio_transporte;
        this.alojamiento = alojamiento;
        this.fechaini = fechaini;
        this.fechafn = fechafn;
        this.horaini = horaini;
        this.horafn = horafn;
        this.id = id;
        this.departamento = departamento;
        this.profesor_solicitante = profesor_solicitante;
        this.estado = estado;
    }

    public Solicitudes(int id,String titulo_actividad, estadosoli estado) {
        this.id=id;
        this.titulo_actividad = titulo_actividad;
        this.estado = estado;
    }
    
    

    public String getTitulo_actividad() {
        return titulo_actividad;
    }

    public void setTitulo_actividad(String titulo_actividad) {
        this.titulo_actividad = titulo_actividad;
    }

    public String getTipo_actividad() {
        return tipo_actividad;
    }

    public void setTipo_actividad(String tipo_actividad) {
        this.tipo_actividad = tipo_actividad;
    }

    public String getNumeroalumnos() {
        return numeroalumnos;
    }

    public void setNumeroalumnos(String numeroalumnos) {
        this.numeroalumnos = numeroalumnos;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public boolean isPrevisto() {
        return previsto;
    }

    public int getId() {
        return id;
    }

    public void setPrevisto(boolean previsto) {
        this.previsto = previsto;
    }

    public boolean isMedio_transporte() {
        return medio_transporte;
    }

    public void setMedio_transporte(boolean medio_transporte) {
        this.medio_transporte = medio_transporte;
    }

    public boolean isAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
    }

    public LocalDate getFechaini() {
        return fechaini;
    }

    public void setFechaini(LocalDate fechaini) {
        this.fechaini = fechaini;
    }

    public LocalDate getFechafn() {
        return fechafn;
    }

    public void setFechafn(LocalDate fechafn) {
        this.fechafn = fechafn;
    }

    public LocalTime getHoraini() {
        return horaini;
    }

    public void setHoraini(LocalTime horaini) {
        this.horaini = horaini;
    }

    public LocalTime getHorafn() {
        return horafn;
    }

    public void setHorafn(LocalTime horafn) {
        this.horafn = horafn;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Profesor getProfesor_solicitante() {
        return profesor_solicitante;
    }

    public estadosoli getEstado() {
        return estado;
    }

    public LinkedList<Profesor> getParticipantes() {
        return participantes;
    }

    public LinkedList<Grupos> getGrupos() {
        return grupos;
    }

    public LinkedList<Curso> getCursos() {
        return cursos;
    }

    public LinkedList<MedioTransporte> getTransporte() {
        return transporte;
    }

    public LinkedList<Profesor> getResponsables() {
        return responsables;
    }
    
    @Override
    public String toString() {
        return "Solicitudes{" + "titulo_actividad=" + titulo_actividad + ", tipo_actividad=" + tipo_actividad + ", numeroalumnos=" + numeroalumnos + ", comentarios=" + comentarios + ", previsto=" + previsto + ", medio_transporte=" + medio_transporte + ", alojamiento=" + alojamiento + ", fechaini=" + fechaini + ", fechafn=" + fechafn + ", horaini=" + horaini + ", horafn=" + horafn + ", departamento=" + departamento + ", profesor_solicitante=" + profesor_solicitante + '}';
    }
    
    
}
