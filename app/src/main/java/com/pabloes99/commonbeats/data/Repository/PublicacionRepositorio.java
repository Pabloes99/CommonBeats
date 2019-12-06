package com.pabloes99.commonbeats.data.Repository;

import com.pabloes99.commonbeats.data.pojo.Publicacion;
import com.pabloes99.commonbeats.data.pojo.TipoPublicacion;

import java.util.ArrayList;
import java.util.List;

public class PublicacionRepositorio {

    private static PublicacionRepositorio publicacionRepositorio;
    List<Publicacion> publicaciones;

    static {
        publicacionRepositorio = new PublicacionRepositorio();
    }

    private PublicacionRepositorio(){
        inicializarPublicaciones();
    }

    private void inicializarPublicaciones() {
        publicaciones = new ArrayList<Publicacion>();

        publicaciones.add(new Publicacion("Increible actuación en la Plaza del Romeral", TipoPublicacion.Foto));
    }

    public static PublicacionRepositorio getInstance(){
        return  publicacionRepositorio;
    }

    public List<Publicacion> getListaPublicaciones(){
        return  publicaciones;
    }

}
