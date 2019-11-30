package com.pabloes99.commonbeats.model.pojo;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;


public class Evento implements Parcelable {

    public static final String KEY = "EVENTO";



    //Campos
    private static int idUnico = 1;
    private int idEvento;
    private String titulo;
    private Estilo estilo;
    private String fecha;
    private String hora;
    private String localizacion;
    private String descripcion;

    public Evento(){}

    //Constructores
    public Evento(String titulo, Estilo estilo, String fecha, String hora, String localizacion, String descripcion) {
        this.idEvento = idUnico++;
        this.titulo = titulo;
        this.estilo = estilo;
        this.fecha = fecha;
        this.hora = hora;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
    }

    protected Evento(Parcel in) {
        idEvento = in.readInt();
        titulo = in.readString();
        fecha = in.readString();
        hora = in.readString();
        localizacion = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<Evento> CREATOR = new Creator<Evento>() {
        @Override
        public Evento createFromParcel(Parcel in) {
            return new Evento(in);
        }

        @Override
        public Evento[] newArray(int size) {
            return new Evento[size];
        }
    };

    //Propiedades
    public int getIdEvento() {
        return idEvento;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idEvento);
        dest.writeString(titulo);
        dest.writeString(fecha);
        dest.writeString(hora);
        dest.writeString(localizacion);
        dest.writeString(descripcion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento)) return false;
        Evento evento = (Evento) o;
        return idEvento == evento.idEvento;
    }

    public static class FechaEventoComparator implements Comparator {

        public int compare(Object o1, Object o2) {
            Evento evento = (Evento)o1;
            Evento evento2 = (Evento)o2;
            return evento.getFecha().
                    compareTo(evento2.getFecha());

        }
    }

    public static class TituloEventoComparator implements Comparator {

        public int compare(Object o1, Object o2) {
            Evento evento = (Evento)o1;
            Evento evento2 = (Evento)o2;
            return evento.getTitulo().
                    compareTo(evento2.getTitulo());

        }
    }
}
