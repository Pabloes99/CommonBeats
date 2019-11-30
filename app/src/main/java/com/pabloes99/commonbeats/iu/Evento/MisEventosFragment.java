package com.pabloes99.commonbeats.iu.Evento;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.adapter.EventoAdapter;
import com.pabloes99.commonbeats.adapter.EventosCreadosAdapter;
import com.pabloes99.commonbeats.adapter.EventosSuscritosAdapter;
import com.pabloes99.commonbeats.model.Repository.EventosCreadosRepository;
import com.pabloes99.commonbeats.model.pojo.Evento;

public class MisEventosFragment extends Fragment{

    private RecyclerView rvEventosSuscritos;
    private RecyclerView rvEventosCreados;
    private EventosSuscritosAdapter eventosSuscritosAdapter;
    private EventosCreadosAdapter eventosCreadosAdapter;
    private FloatingActionButton fabCrearEvento;
    private EventosCreadosAdapter.OnClickEventoCreadoListener onClickEventoCreadoListener;
    private EventosSuscritosAdapter.OnClickEventoSuscritoListener onClickEventoSuscritoListener;


    public MisEventosFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mis_eventos, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvEventosSuscritos = view.findViewById(R.id.rvEventosSuscritos);
        rvEventosCreados = view.findViewById(R.id.rvEventosCreados);
        fabCrearEvento = view.findViewById(R.id.fabCrearEvento);

        fabCrearEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CrearEventoActivity.class);
                startActivity(intent);
            }
        });

        inicializarRvEventosSuscritos();
        inicializarRvEventosCreados();
    }


    private void inicializarRvEventosSuscritos() {

        rvEventosSuscritos.setHasFixedSize(true);
        eventosSuscritosAdapter = new EventosSuscritosAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        rvEventosSuscritos.setLayoutManager(linearLayoutManager);
        rvEventosSuscritos.setAdapter(eventosSuscritosAdapter);

        inicializarOnClickDescripcionEventosSuscritosListener();
        eventosSuscritosAdapter.setOnClickEventoSuscritoListener(onClickEventoSuscritoListener);

        EventoSeleccionadoFragment.pasarEventosSuscritosAdapter(eventosSuscritosAdapter);
        EditarEventoCreadoFragment.pasarEventosSuscritosAdapterEditar(eventosSuscritosAdapter);
    }

    private void inicializarOnClickDescripcionEventosSuscritosListener() {
        onClickEventoSuscritoListener = new EventosSuscritosAdapter.OnClickEventoSuscritoListener() {
            @Override
            public void onClickEventoSuscrito(Evento evento) {
                lanzarIntentDescripcionEvnetoSuscrito(evento);
            }
        };
    }

    private void lanzarIntentDescripcionEvnetoSuscrito(Evento evento) {

        Intent intent = new Intent(getContext(), DescripcionEventoSuscritoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Evento.KEY, evento);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    private void inicializarRvEventosCreados() {

        rvEventosCreados.setHasFixedSize(true);

        eventosCreadosAdapter = new EventosCreadosAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        rvEventosCreados.setLayoutManager(linearLayoutManager);
        rvEventosCreados.setAdapter(eventosCreadosAdapter);

        inicializarOnClickEventosCreadosListener();
        eventosCreadosAdapter.setOnClickEventoCreadoListener(onClickEventoCreadoListener);

        CrearEventoFragment.pasarCrearEventoAdapter(eventosCreadosAdapter);
        EditarEventoCreadoFragment.pasarEventosCreadosAdapterEditar(eventosCreadosAdapter);

    }

    private void inicializarOnClickEventosCreadosListener() {
        onClickEventoCreadoListener = new EventosCreadosAdapter.OnClickEventoCreadoListener() {
            @Override
            public void onClickEventoCreado(Evento evento) {
                //Llamo al intent
                lanzarIntentEditarEventoCreado(evento);

                Toast.makeText(getContext(), "Funciona", Toast.LENGTH_LONG).show();
            }
        };
    }

    private void lanzarIntentEditarEventoCreado(Evento evento) {
        Intent intent = new Intent(getContext(), EditarEventoCreadoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Evento.KEY,evento);
        intent.putExtras(bundle);
        startActivity(intent,bundle);
    }
}
