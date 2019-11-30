package com.pabloes99.commonbeats.iu.Evento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.pabloes99.commonbeats.R;

public class DescripcionEventoSuscritoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_evento_suscrito);

        cargarFragmentDescripcionEventoSuscritoFragment();
    }

    private void cargarFragmentDescripcionEventoSuscritoFragment() {

        Intent intent = getIntent();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DescripcionEventoSuscritoFragment descripcionEventoSuscritoFragment = DescripcionEventoSuscritoFragment.crearNeuvaInstancia(intent.getExtras());

        fragmentTransaction.add(android.R.id.content, descripcionEventoSuscritoFragment, DescripcionEventoSuscritoFragment.TAG);

        fragmentTransaction.commit();
    }
}
