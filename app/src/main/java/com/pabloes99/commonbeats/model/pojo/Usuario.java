package com.pabloes99.commonbeats.model.pojo;

import android.text.method.DateTimeKeyListener;

import java.util.Date;

public class Usuario {

    //Campos
    static int idUnico = 1;
    private int id;
    private String usuario;
    private String contrasenna;
    private String email;
    private String foto;
    private String nombre;
    private String apelldios;
    private String fechaNacimiento;
    private String fechaCreacion;
    private String movil;

    //Constructores
    public Usuario(String usuario, String contrasenna, String email, String foto, String nombre, String apellidos, String fechaNacimiento, String movil){
        this.usuario = usuario;
        this.contrasenna = contrasenna;
        this.email = email;
        this.foto = foto;
        this.nombre = nombre;
        this.apelldios = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = String.valueOf(new Date().getDate());
        this.movil = movil;

    }

    //Propiedades
    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelldios() {
        return apelldios;
    }

    public void setApelldios(String apelldios) {
        this.apelldios = apelldios;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }


}
