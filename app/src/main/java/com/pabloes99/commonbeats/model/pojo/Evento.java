package com.pabloes99.commonbeats.model.pojo;


import androidx.annotation.NonNull;

import java.util.Date;


public class Evento {

    //Campos
    private String titulo;
    private Estilo estilo;
    private String fecha;
    private String hora;
    private String localizacion;
    private String descripcion;

    //Constructores
    public Evento(String titulo, Estilo estilo, String fecha, String hora, String localizacion, String descripcion) {
        this.titulo = titulo;
        this.estilo = estilo;
        this.fecha = fecha;
        this.hora = hora;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
    }

    //Propiedades
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //Métodos
    @NonNull
    @Override
    public String toString() {
        return getTitulo();
    }
}
