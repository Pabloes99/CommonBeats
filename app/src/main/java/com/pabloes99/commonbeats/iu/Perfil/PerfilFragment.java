package com.pabloes99.commonbeats.iu.Perfil;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabloes99.commonbeats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    public static final String TAG = "PerfilFragment";

    public PerfilFragment() {
        // Required empty public constructor
    }

    public static PerfilFragment crearNuevaInstancia() {
        PerfilFragment perfilFragment = new PerfilFragment();
        return  perfilFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        return view;
    }

}
