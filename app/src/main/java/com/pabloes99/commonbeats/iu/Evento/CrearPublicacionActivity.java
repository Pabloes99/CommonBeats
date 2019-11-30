package com.pabloes99.commonbeats.iu.Evento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.pabloes99.commonbeats.R;

public class CrearPublicacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_publicacion);

        cargarCrearPublicacionFragment();
    }

    private void cargarCrearPublicacionFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        CrearPublicacionFragment crearPublicacionFragment = CrearPublicacionFragment.crearNuevaInstancia();

        fragmentTransaction.add(android.R.id.content, crearPublicacionFragment, CrearPublicacionFragment.TAG);

        fragmentTransaction.commit();
    }
}
