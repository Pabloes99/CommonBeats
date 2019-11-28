package com.pabloes99.commonbeats.model.Repository;

import com.pabloes99.commonbeats.model.pojo.Estilo;
import com.pabloes99.commonbeats.model.pojo.Evento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventoRepository {

    List<Evento> eventos;

    private static EventoRepository eventoRepository;

    //Bloque estático para inicializar la única instanica de la clase
    static{
        eventoRepository = new EventoRepository();
    }

    //Constructor privado para que fuera de la clase no se pueda instanciar
    private EventoRepository(){
        inicializarListaEventos();
    }

    private void inicializarListaEventos() {
        eventos = new ArrayList<Evento>();

        /*
        eventos.add(new Evento("Actuación callejera", Estilo.Pop, "30/11/2019" , "20:00","Plaza El Romeral", "Actuación amateur de música pop"));
        eventos.add(new Evento("Batalla de gallos", Estilo.HipHop, "30/11/2019" , "20:00","Plaza El Romeral", "Actuación amateur de música pop"));
        eventos.add(new Evento("Concierto clásico", Estilo.Clasica, "30/11/2019" , "20:00","Plaza El Romeral", "Actuación amateur de música pop"));
        eventos.add(new Evento("Actuación callejera", Estilo.Country, "30/11/2019" , "20:00","Plaza El Romeral", "Actuación amateur de música pop"));
        eventos.add(new Evento("Concierto gratuito", Estilo.Jazz, "30/11/2019" , "20:00","Plaza El Romeral", "Actuación amateur de música pop"));
        eventos.add(new Evento("Quedada Rockera", Estilo.Rock, "30/11/2019" , "20:00","Plaza El Romeral", "Actuación amateur de música pop"));
        eventos.add(new Evento("Actuación pública", Estilo.Pop, "30/11/2019" , "20:00","Plaza El Romeral", "Actuación amateur de música pop"));
        eventos.add(new Evento("Quedada Rockera", Estilo.Rock, "30/11/2019" , "20:00","Plaza El Romeral", "Actuación amateur de música pop"));
        eventos.add(new Evento("Actuación pública", Estilo.Pop, "30/11/2019" , "20:00","Plaza El Romeral", "Actuación amateur de música pop"));
        */

    }


    public List<Evento> getList(){
        return eventos;
    }


    public static EventoRepository getInstance(){
        return eventoRepository;
    }

    public void annadirEventoCreados(Evento evento) {
        eventos.add(evento);
    }

    public void actualizarLista(Evento evento) {

        int posicion = eventos.indexOf(evento);
        eventos.remove(posicion);
        eventos.add(posicion, evento);
    }
}
