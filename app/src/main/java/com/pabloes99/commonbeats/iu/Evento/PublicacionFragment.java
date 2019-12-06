package com.pabloes99.commonbeats.iu.Evento;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.adapter.PublicacionAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublicacionFragment extends Fragment {

    private RecyclerView rvPublicacion;
    PublicacionAdapter publicacionAdapter;
    private FloatingActionButton fabAnnadirPublicacion;

    public PublicacionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_publicacion, container, false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fabAnnadirPublicacion = view.findViewById(R.id.fabAnnadirPublicacion);
        rvPublicacion = view.findViewById(R.id.rvPublicacion);
        rvPublicacion.setHasFixedSize(true);

        publicacionAdapter = new PublicacionAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);

        rvPublicacion.setLayoutManager(linearLayoutManager);
        rvPublicacion.setAdapter(publicacionAdapter);


        fabAnnadirPublicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),CrearPublicacionActivity.class);
                startActivity(intent);
            }
        });
    }
}
