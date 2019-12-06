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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.adapter.AmigosAdapter;
import com.pabloes99.commonbeats.data.pojo.Usuario;

/**
 * A simple {@link Fragment} subclass.
 */
public class AmigosFragment extends Fragment {

    private RecyclerView rvAmigos;
    private AmigosAdapter amigosAdapter;
    private FloatingActionButton fabChat;
    AmigosAdapter.OnClickAmigo onClickAmigo;

    public AmigosFragment() {
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
        View view = inflater.inflate(R.layout.fragment_amigos, container, false);
        return  view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvAmigos = view.findViewById(R.id.rvAmigos);
        fabChat = view.findViewById(R.id.fabChat);

        rvAmigos.setHasFixedSize(true);

        amigosAdapter = new AmigosAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        rvAmigos.setLayoutManager(linearLayoutManager);
        rvAmigos.setAdapter(amigosAdapter);

        inicializarOnCliclAmigo();
        amigosAdapter.setOnCliclAmigo(onClickAmigo);

        fabChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Añadira un amigo en el futuro...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inicializarOnCliclAmigo() {
        onClickAmigo = new AmigosAdapter.OnClickAmigo() {
            @Override
            public void onCliclAmigo(Usuario usuario) {
                Intent intent = new Intent(getContext(), ChatActivity.class);
                startActivity(intent);
            }
        };
    }
}
