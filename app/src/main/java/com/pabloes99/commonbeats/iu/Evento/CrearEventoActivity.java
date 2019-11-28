package com.pabloes99.commonbeats.iu.Evento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.pabloes99.commonbeats.R;

public class CrearEventoActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    CrearEventoFragment crearEventoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evento);

        cargarCrearEventoFragment();
    }

    private void cargarCrearEventoFragment() {

        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();

        crearEventoFragment = new CrearEventoFragment();

        fragmentTransaction.add(R.id.crearEventoFragment,crearEventoFragment, CrearEventoFragment.TAG);

        fragmentTransaction.commit();
    }
}
