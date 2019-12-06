package com.pabloes99.commonbeats.iu.Evento;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.adapter.EventoAdapter;
import com.pabloes99.commonbeats.adapter.EventosCreadosAdapter;
import com.pabloes99.commonbeats.data.Repository.EventoRepository;
import com.pabloes99.commonbeats.data.Repository.EventosCreadosRepository;
import com.pabloes99.commonbeats.data.pojo.Evento;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrearEventoFragment extends Fragment {

    public static final String TAG = "CrearEventoFragment";
    static EventosCreadosAdapter eventosCreadosAdapter;
    static EventoAdapter eventoAdapter;
    Evento evento;
    private TextInputLayout tilTituloCrearEvento;
    private Spinner spEstiloCrearEvento;
    private TextInputLayout tilFechaCrearEvento;
    private TextInputLayout tilHoraCrearEvento;
    private TextInputLayout tilLocalizacionCrearEvento;
    private TextInputLayout tilDescripcionCrearEvento;

    private TextInputEditText tidTituloCrearEvento;
    private TextInputEditText tidFechaCrearEvento;
    private TextInputEditText tidHoraCrearEvento;
    private TextInputEditText tidLocalizacionCrearEvento;
    private TextInputEditText tidDescripcionCrearEvento;
    private FloatingActionButton fabCrearNuevoEvento;

    public CrearEventoFragment() {
        // Required empty public constructor
    }

    public static void pasarCrearEventoAdapter(EventosCreadosAdapter eventosCreadosAdapterD){
        eventosCreadosAdapter = eventosCreadosAdapterD;
    }
    public static void pasarEventoAdapter(EventoAdapter eventoAdapterD){
        eventoAdapter = eventoAdapterD;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_crear_evento, container, false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
// iframe semtic versions
        fabCrearNuevoEvento = view.findViewById(R.id.fabCrearNuevoEvento);
        spEstiloCrearEvento = view.findViewById(R.id.spEstiloCrearEvento);
        tilTituloCrearEvento = view.findViewById(R.id.tilTituloCrearEvento);
        tilFechaCrearEvento = view.findViewById(R.id.tilFechaCrearEvento);
        tilHoraCrearEvento = view.findViewById(R.id.tilHoraCrearEvento);
        tilLocalizacionCrearEvento = view.findViewById(R.id.tilLocalizacionCrearEvento);
        tilDescripcionCrearEvento = view.findViewById(R.id.tilDescripcionCrearEvento);

        tidTituloCrearEvento = view.findViewById(R.id.tidTituloCrearEvento);
        tidFechaCrearEvento = view.findViewById(R.id.tidFechaCrearEvento);
        tidHoraCrearEvento = view.findViewById(R.id.tidHoraCrearEvento);
        tidLocalizacionCrearEvento = view.findViewById(R.id.tidLocalizacionCrearEvento);
        tidDescripcionCrearEvento = view.findViewById(R.id.tidDescripcionCrearEvento);

        fabCrearNuevoEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Funciona el click",Toast.LENGTH_LONG).show();
                inicializarEvento();
                EventosCreadosRepository.getInstancia().annadirNuevoEvento(evento);
                EventoRepository.getInstance().annadirEventoCreados(evento);
                eventosCreadosAdapter.notifyDataSetChanged();
                eventoAdapter.notifyDataSetChanged();
                getActivity().onBackPressed();
            }
        });
    }

    private void inicializarEvento() {

        evento = new Evento(tidTituloCrearEvento.getText().toString(), spEstiloCrearEvento.getSelectedItem().toString() ,tidFechaCrearEvento.getText().toString(),tidHoraCrearEvento.getText().toString(),tidLocalizacionCrearEvento.getText().toString(),tidDescripcionCrearEvento.getText().toString());
    }
}
