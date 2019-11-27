package com.pabloes99.commonbeats.model.Repository;

import com.pabloes99.commonbeats.model.pojo.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventosSuscritosRepository {

    List<Evento> eventosSuscritos;
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


}
