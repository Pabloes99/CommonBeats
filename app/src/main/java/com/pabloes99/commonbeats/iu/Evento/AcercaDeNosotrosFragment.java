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
public class AcercaDeNosotrosFragment extends Fragment {

    public static final String TAG = "AcercaDeNosotrosFragment";

    public AcercaDeNosotrosFragment() {
        // Required empty public constructor
    }

    public static AcercaDeNosotrosFragment crearNuevaInstancia(Bundle bundle){
        AcercaDeNosotrosFragment acercaDeNosotrosFragment = new AcercaDeNosotrosFragment();

        if (bundle != null){
            acercaDeNosotrosFragment.setArguments(bundle);
        }
        return acercaDeNosotrosFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_acerca_de_nosotros, container, false);
        return  view;
    }

}
