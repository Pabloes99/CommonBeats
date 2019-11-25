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

/**
 * A simple {@link Fragment} subclass.
 */
public class EventosFragment extends Fragment {

    private RecyclerView rvEventos;
    private EventoAdapter eventoAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_eventos, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        rvEventos = view.findViewById(R.id.rvEventos);
        rvEventos.setHasFixedSize(true);

        eventoAdapter = new EventoAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        rvEventos.setLayoutManager(linearLayoutManager);
        rvEventos.setAdapter(eventoAdapter);

    }

/*
    public static EventosFragment crearNuevaInstancia(Bundle bundle) {
        EventosFragment fragment = new EventosFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }
    */

}
