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
import com.pabloes99.commonbeats.model.Repository.EventosCreadosRepository;
import com.pabloes99.commonbeats.model.pojo.Evento;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditarEventoCreadoFragment extends Fragment {

    Evento evento;
    private TextInputLayout tilTituloEditarEventoCreado;
    private Spinner spEstiloEditarEventoCreado;
    private TextInputLayout tilFechaEditarEventoCreado;
    private TextInputLayout tilHoraEditarEventoCreado;
    private TextInputLayout tilLocalizacionEditarEventoCreado;
    private TextInputLayout tilDescripcionEditarEventoCreado;

    private TextInputEditText tidTituloEditarEventoCreado;
    private TextInputEditText tidFechaEditarEventoCreado;
    private TextInputEditText tidHoraEditarEventoCreado;
    private TextInputEditText tidLocalizacionEditarEventoCreado;
    private TextInputEditText tidDescripcionEditarEventoCreado;
    private FloatingActionButton fabEditarEventoCreado;

    public static final String TAG = "EditarEventoCreado";

    public EditarEventoCreadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_editar_evento_creado, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tilTituloEditarEventoCreado = view.findViewById(R.id.tilTituloEditarEventoCreado);
        tilFechaEditarEventoCreado = view.findViewById(R.id.tilFechaEditarEventoCreado);
        tilHoraEditarEventoCreado = view.findViewById(R.id.tilHoraEditarEventoCreado);
        tilLocalizacionEditarEventoCreado = view.findViewById(R.id.tilLocalizacionEditarEventoCreado);
        tilDescripcionEditarEventoCreado = view.findViewById(R.id.tilDescripcionEditarEventoCreado);

        tidTituloEditarEventoCreado = view.findViewById(R.id.tidTituloEditarEventoCreado);
        tidFechaEditarEventoCreado = view.findViewById(R.id.tidFechaEditarEventoCreado);
        tidHoraEditarEventoCreado = view.findViewById(R.id.tidHoraEditarEventoCreado);
        tidLocalizacionEditarEventoCreado = view.findViewById(R.id.tidLocalizacionEditarEventoCreado);
        tidDescripcionEditarEventoCreado = view.findViewById(R.id.tidDescripcionEditarEventoCreado);

        fabEditarEventoCreado = view.findViewById(R.id.fabEditarEventoCreado);


        iniciarElementoSeleccionado();
        inicializarFabEditarEventoCreado();
    }


    public static EditarEventoCreadoFragment crearNuevaInstancia(Bundle bundle) {
        EditarEventoCreadoFragment editarEventoCreadoFragment = new EditarEventoCreadoFragment();

        if (bundle != null) {
            editarEventoCreadoFragment.setArguments(bundle);
        }

        return editarEventoCreadoFragment;
    }

    private void inicializarFabEditarEventoCreado() {
        fabEditarEventoCreado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Funciona de verdad", Toast.LENGTH_LONG).show();

                //Obtengo los nuevos datos del evento en un  nuevo evento y añado este nuevo evento
                obtenerEventoEditado();
                EventosCreadosRepository.getInstancia().editarEvento(evento);
            }
        });
    }


    private void iniciarElementoSeleccionado() {

        Bundle bundle = getArguments();

        if (bundle != null) {
            evento = bundle.getParcelable(Evento.KEY);

            tidTituloEditarEventoCreado.setText(evento.getTitulo());
            //spinner
            tidFechaEditarEventoCreado.setText(evento.getFecha());
            tidHoraEditarEventoCreado.setText(evento.getHora());
            tidLocalizacionEditarEventoCreado.setText(evento.getLocalizacion());
            tidDescripcionEditarEventoCreado.setText(evento.getDescripcion());
        }
    }

    private void obtenerEventoEditado() {

        evento.setTitulo(tilTituloEditarEventoCreado.getEditText().getText().toString());
        evento.setFecha(tilFechaEditarEventoCreado.getEditText().getText().toString());
        evento.setHora(tilHoraEditarEventoCreado.getEditText().getText().toString());
        evento.setLocalizacion(tilLocalizacionEditarEventoCreado.getEditText().getText().toString());
        evento.setDescripcion(tilDescripcionEditarEventoCreado.getEditText().getText().toString());

    }


}
