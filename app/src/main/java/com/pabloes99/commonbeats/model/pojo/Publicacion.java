package com.pabloes99.commonbeats.model.pojo;

import java.util.Date;

public class Publicacion {

    //Campos
    private String titulo;
    private  TipoPublicacion tipo;
    private String fechaCreacion;

    //Constructor
    public Publicacion(String titulo, TipoPublicacion tipo)
    {
        this.titulo = titulo;
        this.tipo = tipo;
        fechaCreacion = String.valueOf(new Date().getDate());
    }

    //Propiedades
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoPublicacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoPublicacion tipo) {
        this.tipo = tipo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }
}
