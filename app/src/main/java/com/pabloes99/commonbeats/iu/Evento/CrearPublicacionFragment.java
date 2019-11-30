package com.pabloes99.commonbeats.iu.Evento;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabloes99.commonbeats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrearPublicacionFragment extends Fragment {

public static final String TAG = "CrearPublicacionFragment";

    public CrearPublicacionFragment() {
        // Required empty public constructor
    }

    public static CrearPublicacionFragment crearNuevaInstancia(){
        CrearPublicacionFragment crearPublicacionFragment = new CrearPublicacionFragment();
        return crearPublicacionFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_crear_publicacion, container, false);
        return  view;
    }

}
