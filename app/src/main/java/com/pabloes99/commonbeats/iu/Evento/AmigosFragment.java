package com.pabloes99.commonbeats.iu.Evento;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.adapter.AmigosAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AmigosFragment extends Fragment {

    private RecyclerView rvAmigos;
    private AmigosAdapter amigosAdapter;

    public AmigosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_amigos, container, false);
        return  view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvAmigos = view.findViewById(R.id.rvAmigos);

        rvAmigos.setHasFixedSize(true);

        amigosAdapter = new AmigosAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        rvAmigos.setLayoutManager(linearLayoutManager);
        rvAmigos.setAdapter(amigosAdapter);

    }
}
