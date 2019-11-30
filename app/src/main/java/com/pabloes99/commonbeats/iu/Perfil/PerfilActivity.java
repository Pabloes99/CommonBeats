package com.pabloes99.commonbeats.iu.Perfil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

import com.pabloes99.commonbeats.R;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        cargarPerfilFragment();
    }

    private void cargarPerfilFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PerfilFragment chatFragment = PerfilFragment.crearNuevaInstancia();

        fragmentTransaction.add(android.R.id.content, chatFragment, PerfilFragment.TAG);

        fragmentTransaction.commit();

    }
}
