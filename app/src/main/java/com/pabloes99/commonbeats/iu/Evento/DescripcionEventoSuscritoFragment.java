package com.pabloes99.commonbeats.iu.Evento;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.model.pojo.Evento;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescripcionEventoSuscritoFragment extends Fragment {

    Evento evento;
    private Spinner spDescripcionEventoSuscrito;
    private FloatingActionButton fabChatEvento;
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

        spDescripcionEventoSuscrito = view.findViewById(R.id.spEstiloDescripcionEventoSuscrito);
        tidTituloDescripcionEventoSuscrito = view.findViewById(R.id.tidTituloDescripcionEventoSuscrito);
        spDescripcionEventoSuscrito = view.findViewById(R.id.spEstiloDescripcionEventoSuscrito);
        tidFechaDescripcionEventoSuscrito = view.findViewById(R.id.tidFechaDescripcionEventoSuscrito);
        tidHoraDescripcionEventoSuscrito = view.findViewById(R.id.tidHoraDescripcionEventoSuscrito);
        tidLocalizacionDescripcionEventoSuscrito = view.findViewById(R.id.tidLocalizacionDescripcionEventoSuscrito);
        tidDescripcionDescripcionEventoSuscrito = view.findViewById(R.id.tidDescripcionDescripcionEventoSuscrito);
        fabChatEvento = view.findViewById(R.id.fabChatEvento);

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

        fabChatEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarChatEventoFragment();
            }
        });

    }

    private void cargarChatEventoFragment() {

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ChatFragment chatFragment = ChatFragment.crearNuevaInstancia(null);

        fragmentTransaction.replace(android.R.id.content, chatFragment, ChatFragment.TAG);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
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
