package com.pabloes99.commonbeats.data.Repository;

import com.pabloes99.commonbeats.data.pojo.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventosCreadosRepository {

    private static EventosCreadosRepository eventosCreadosRepository;
    List<Evento> eventosCreados;

    static{
        eventosCreadosRepository = new EventosCreadosRepository();
    }

    private EventosCreadosRepository(){
        inicializarEventosCreados();
    }

    private void inicializarEventosCreados() {
        eventosCreados = new ArrayList<Evento>();
    }

    public static EventosCreadosRepository getInstancia(){
        return  eventosCreadosRepository;
    }

    public  List<Evento> getListaEventosCreados(){
        return eventosCreados;
    }

    public void annadirNuevoEvento(Evento evento) {
        eventosCreados.add(evento);
    }

    public void editarEvento(Evento evento) {

        int posicion = eventosCreados.indexOf(evento);
        eventosCreados.remove(posicion);
        eventosCreados.add(posicion, evento);

        EventoRepository.getInstance().actualizarLista(evento);

        List<Evento> suscritos = EventosSuscritosRepository.getInstance().getListEventosSuscritos();

        if (suscritos.contains(evento)) {
            EventosSuscritosRepository.getInstance().actualizarListas(evento);
        }
    }
}
