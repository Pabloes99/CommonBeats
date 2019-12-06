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
import com.pabloes99.commonbeats.adapter.EventosSuscritosAdapter;
import com.pabloes99.commonbeats.data.Repository.EventosSuscritosRepository;
import com.pabloes99.commonbeats.data.pojo.Evento;


public class EventoSeleccionadoFragment extends Fragment {

    public static final String TAG = "EventoSeleccionadoFragment";
    Evento evento;
    static EventosSuscritosAdapter eventosSuscritosAdapter;
    private TextInputLayout tilTitulo;
    private Spinner spEstilo;
    private TextInputLayout tilFecha;
    private TextInputLayout tilHora;
    private TextInputLayout tilLocalizacion;
    private TextInputLayout tilDescripcion;

    private TextInputEditText tidTitulo;
    private TextInputEditText tidFecha;
    private TextInputEditText tidHora;
    private TextInputEditText tidLocalizacion;
    private TextInputEditText tidDescripcion;
    private FloatingActionButton fabSuscribir;

    public EventoSeleccionadoFragment() {

    }

    public static void pasarEventosSuscritosAdapter(EventosSuscritosAdapter eventosSuscritosAdapterD){
        eventosSuscritosAdapter = eventosSuscritosAdapterD;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_evento_seleccionado, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tilTitulo = view.findViewById(R.id.tilTitulo);
        tilFecha = view.findViewById(R.id.tilFecha);
        tilHora = view.findViewById(R.id.tilHora);
        tilLocalizacion = view.findViewById(R.id.tilLocalizacion);
        tilDescripcion = view.findViewById(R.id.tilDescripcion);

        tidTitulo = view.findViewById(R.id.tidTitulo);
        tidFecha = view.findViewById(R.id.tidFecha);
        tidHora = view.findViewById(R.id.tidHora);
        tidLocalizacion = view.findViewById(R.id.tidLocalizacion);
        tidDescripcion = view.findViewById(R.id.tidDescripcion);
        
        fabSuscribir = view.findViewById(R.id.fabSuscribir);

        iniciarElementoSeleccionado();
        onClickFabSuscribir();
    }

    private void onClickFabSuscribir() {
        fabSuscribir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Se ejecuta", Toast.LENGTH_SHORT).show();
                EventosSuscritosRepository.getInstance().annadirEventoSuscrito(evento);
                eventosSuscritosAdapter.notifyDataSetChanged();
                getActivity().onBackPressed();
            }
        });
    }

    public static EventoSeleccionadoFragment crearNuevaInstancia(Bundle bundle) {
        EventoSeleccionadoFragment fragment = new EventoSeleccionadoFragment();
        if (bundle != null)
            fragment.setArguments(bundle);

        return fragment;
    }


    private void iniciarElementoSeleccionado() {

        Bundle bundle = new Bundle();

        bundle = getArguments();

        if (bundle != null) {
            evento = bundle.getParcelable(Evento.KEY);

            tidTitulo.setText(evento.getTitulo());

            tidFecha.setText(evento.getFecha());
            tidHora.setText(evento.getHora());
            tidLocalizacion.setText(evento.getLocalizacion());
            tidDescripcion.setText(evento.getDescripcion());
        }
    }

}
