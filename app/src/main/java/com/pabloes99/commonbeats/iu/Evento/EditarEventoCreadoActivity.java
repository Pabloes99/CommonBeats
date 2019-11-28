package com.pabloes99.commonbeats.iu.Evento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.pabloes99.commonbeats.R;

public class EditarEventoCreadoActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    EditarEventoCreadoFragment editarEventoCreadoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_evento_creado);

        cargarEditarEventoCreadoFragment();
    }

    private void cargarEditarEventoCreadoFragment() {

        Intent intent = getIntent();

        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();

        editarEventoCreadoFragment = EditarEventoCreadoFragment.crearNuevaInstancia(intent.getExtras());

        fragmentTransaction.add(android.R.id.content, editarEventoCreadoFragment, EditarEventoCreadoFragment.TAG);

        fragmentTransaction.commit();
    }
}
