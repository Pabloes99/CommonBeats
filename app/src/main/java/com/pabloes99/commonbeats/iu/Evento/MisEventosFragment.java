package com.pabloes99.commonbeats.iu.Evento;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.adapter.EventoAdapter;
import com.pabloes99.commonbeats.adapter.EventosSuscritosAdapter;

public class MisEventosFragment extends Fragment {

    private RecyclerView rvEventosSuscritos;
    private RecyclerView rvEventosCreados;
    private EventosSuscritosAdapter eventosSuscritosAdapter;

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

        inicializarRvEventosSuscritos();
        inicializarRvEventosCreados();
    }


    private void inicializarRvEventosSuscritos() {

        rvEventosSuscritos.setHasFixedSize(true);
        eventosSuscritosAdapter = new EventosSuscritosAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        rvEventosSuscritos.setLayoutManager(linearLayoutManager);
        rvEventosSuscritos.setAdapter(eventosSuscritosAdapter);
    }

    private void inicializarRvEventosCreados() {

        rvEventosCreados.setHasFixedSize(true);
    }


}
