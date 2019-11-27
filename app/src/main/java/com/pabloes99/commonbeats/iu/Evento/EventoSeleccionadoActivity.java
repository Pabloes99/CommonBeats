package com.pabloes99.commonbeats.iu.Evento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.model.pojo.Evento;

public class EventoSeleccionadoActivity extends AppCompatActivity {

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

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private EventoSeleccionadoFragment eventoSeleccionadoFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_seleccionado);

        cargarEventoSeleccionadoFragment();
    }

    private void cargarEventoSeleccionadoFragment() {
        Intent intent = getIntent();

        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();

        eventoSeleccionadoFragment = EventoSeleccionadoFragment.crearNuevaInstancia(intent.getExtras());

        fragmentTransaction.replace(android.R.id.content, eventoSeleccionadoFragment, EventoSeleccionadoFragment.TAG);

        fragmentTransaction.commit();
    }


}
