package com.pabloes99.commonbeats.iu.Evento;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.adapter.EventoAdapter;
import com.pabloes99.commonbeats.iu.DashBoardActivity;
import com.pabloes99.commonbeats.model.pojo.Evento;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventosFragment extends Fragment {

    private RecyclerView rvEventos;
    private EventoAdapter eventoAdapter;
    private EventoAdapter.OnUserClickListenner userClickListenner;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private EventoSeleccionadoFragment eventoSeleccionadoFragment;


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


        inicializarUserClickListenner();
        eventoAdapter.setOnUserCliclListenner(userClickListenner);

        CrearEventoFragment.pasarEventoAdapter(eventoAdapter);
        EditarEventoCreadoFragment.pasarEventoAdapterEditar(eventoAdapter);
        DashBoardActivity.pasarEventoAdapter(eventoAdapter);
    }

    private void inicializarUserClickListenner() {
        userClickListenner = new EventoAdapter.OnUserClickListenner() {
            @Override
            public void onUserClick(Evento evento) {

                Bundle bundle = new Bundle();
                bundle.putParcelable(Evento.KEY, evento);
                cargarEventoSeleccionadoFragment(bundle);
                //Toast.makeText(getContext(), "Has seleccionado el evento: " + evento.getIdEvento(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void cargarEventoSeleccionadoFragment(Bundle bundle) {

        Intent intent = new Intent(getContext(), EventoSeleccionadoActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    public static EventosFragment crearNuevaInstancia(Bundle bundle) {
        EventosFragment fragment = new EventosFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

}
