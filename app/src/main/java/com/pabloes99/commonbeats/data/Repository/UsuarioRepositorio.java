package com.pabloes99.commonbeats.data.Repository;

import com.pabloes99.commonbeats.data.pojo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {

    List<Usuario> amigos;
    private static UsuarioRepositorio usuarioRepositorio;

    static {
        usuarioRepositorio = new UsuarioRepositorio();
    }

    private UsuarioRepositorio(){
        inicializarAmigos();
    }

    private void inicializarAmigos() {
        amigos = new ArrayList<Usuario>();

        amigos.add(new Usuario("Pabloes_99", "1234", "pabloes99@gmail.com", "this.foto", "Pablo", "Estepa Estepa", "14/04/1999", "619036122"));
    }

    public List<Usuario> getListaAmigos(){
        return amigos;
    }

    public static UsuarioRepositorio getInstance(){
        return  usuarioRepositorio;
    }

}
