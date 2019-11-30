package com.pabloes99.commonbeats.iu.Evento;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.model.pojo.Evento;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescripcionEventoSuscritoFragment extends Fragment {

    Evento evento;
    private TextInputLayout tilTituloDescripcionEventoSuscrito;
    private Spinner spDescripcionEventoSuscrito;
    private TextInputLayout tilFechaDescripcionEventoSuscrito;
    private TextInputLayout tilHoraDescripcionEventoSuscrito;
    private TextInputLayout tilLocalizacionDescripcionEventoSuscrito;
    private TextInputLayout tilDescripcionDescripcionEventoSuscrito;

    private TextInputEditText tidTituloDescripcionEventoSuscrito;
    private TextInputEditText tidFechaDescripcionEventoSuscrito;
    private TextInputEditText tidHoraDescripcionEventoSuscrito;
    private TextInputEditText tidLocalizacionDescripcionEventoSuscrito;
    private TextInputEditText tidDescripcionDescripcionEventoSuscrito;

    public static final String TAG = "DescripcionEventoSuscrito";

    public DescripcionEventoSuscritoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_descripcion_evento_suscrito, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tilTituloDescripcionEventoSuscrito = view.findViewById(R.id.tilTituloDescripcionEventoSuscrito);
        spDescripcionEventoSuscrito = view.findViewById(R.id.spEstiloDescripcionEventoSuscrito);
        tilFechaDescripcionEventoSuscrito = view.findViewById(R.id.tilFechaDescripcionEventoSuscrito);
        tilHoraDescripcionEventoSuscrito = view.findViewById(R.id.tilHoraDescripcionEventoSuscrito);
        tilLocalizacionDescripcionEventoSuscrito = view.findViewById(R.id.tilLocalizacionDescripcionEventoSuscrito);
        tilDescripcionDescripcionEventoSuscrito = view.findViewById(R.id.tilDescripcionDescripcionEventoSuscrito);

        tidTituloDescripcionEventoSuscrito = view.findViewById(R.id.tidTituloDescripcionEventoSuscrito);
        spDescripcionEventoSuscrito = view.findViewById(R.id.spEstiloDescripcionEventoSuscrito);
        tidFechaDescripcionEventoSuscrito = view.findViewById(R.id.tidFechaDescripcionEventoSuscrito);
        tidHoraDescripcionEventoSuscrito = view.findViewById(R.id.tidHoraDescripcionEventoSuscrito);
        tidLocalizacionDescripcionEventoSuscrito = view.findViewById(R.id.tidLocalizacionDescripcionEventoSuscrito);
        tidDescripcionDescripcionEventoSuscrito = view.findViewById(R.id.tidDescripcionDescripcionEventoSuscrito);

        Bundle bundle = getArguments();

        if (bundle != null)
        {
            evento = bundle.getParcelable(Evento.KEY);


            tidTituloDescripcionEventoSuscrito.setText(evento.getTitulo());
            tidFechaDescripcionEventoSuscrito.setText(evento.getFecha());
            tidHoraDescripcionEventoSuscrito.setText(evento.getHora());
            tidLocalizacionDescripcionEventoSuscrito.setText(evento.getLocalizacion());
            tidDescripcionDescripcionEventoSuscrito.setText(evento.getDescripcion());

        }

    }



    public static DescripcionEventoSuscritoFragment crearNeuvaInstancia(Bundle bundle){
        DescripcionEventoSuscritoFragment descripcionEventoSuscritoFragment = new DescripcionEventoSuscritoFragment();
        if (bundle != null)
        {
            descripcionEventoSuscritoFragment.setArguments(bundle);
        }
        return descripcionEventoSuscritoFragment;
    }

}
