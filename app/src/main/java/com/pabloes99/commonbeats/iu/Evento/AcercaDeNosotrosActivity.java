package com.pabloes99.commonbeats.iu.Evento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.pabloes99.commonbeats.R;

public class AcercaDeNosotrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de_nosotros);

        cargarFragmentAbousUs();
    }

    private void cargarFragmentAbousUs() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        AcercaDeNosotrosFragment acercaDeNosotrosFragment = AcercaDeNosotrosFragment.crearNuevaInstancia(null);

        fragmentTransaction.add(android.R.id.content, acercaDeNosotrosFragment, AcercaDeNosotrosFragment.TAG);

        fragmentTransaction.commit();

    }
}
