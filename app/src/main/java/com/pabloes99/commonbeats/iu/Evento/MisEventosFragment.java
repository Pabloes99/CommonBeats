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
public class MisEventosFragment extends Fragment {


    public MisEventosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mis_eventos, container, false);
        return view;
    }

}
