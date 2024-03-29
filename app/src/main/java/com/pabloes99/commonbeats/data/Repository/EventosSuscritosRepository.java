package com.pabloes99.commonbeats.data.Repository;

import com.pabloes99.commonbeats.data.pojo.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventosSuscritosRepository {

    private List<Evento> eventosSuscritos;
    public static EventosSuscritosRepository eventosSuscritosRepository;

    static{
        eventosSuscritosRepository = new EventosSuscritosRepository();
    }

    private EventosSuscritosRepository(){
        inicializarEventosSuscritos();
    }

    private void inicializarEventosSuscritos() {
        eventosSuscritos = new ArrayList<Evento>();
    }

    public List<Evento> getListEventosSuscritos(){
        return eventosSuscritos;
    }


    public static EventosSuscritosRepository getInstance(){
        return eventosSuscritosRepository;
    }

    public void annadirEventoSuscrito(Evento evento) {
        eventosSuscritos.add(evento);
    }


    public void actualizarListas(Evento evento) {
        int posicion = eventosSuscritos.indexOf(evento);
        eventosSuscritos.remove(posicion);
        eventosSuscritos.add(posicion, evento);
    }
}
