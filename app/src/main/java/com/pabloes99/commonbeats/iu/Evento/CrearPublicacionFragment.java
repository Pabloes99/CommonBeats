package com.pabloes99.commonbeats.iu.Evento;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.pabloes99.commonbeats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrearPublicacionFragment extends Fragment {

public static final String TAG = "CrearPublicacionFragment";

    private EditText etTituloPublicacion;
    private RadioButton rbTexto;
    private RadioButton rbImagen;
    private RadioButton rbVideo;
    LinearLayout llTexto;
    LinearLayout llImagen;
    LinearLayout llVideo;
    RadioGroup radioGroup;
    public CrearPublicacionFragment() {
        // Required empty public constructor
    }

    public static CrearPublicacionFragment crearNuevaInstancia(){
        CrearPublicacionFragment crearPublicacionFragment = new CrearPublicacionFragment();
        return crearPublicacionFragment;
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
        View view = inflater.inflate(R.layout.fragment_crear_publicacion, container, false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rbTexto = view.findViewById(R.id.rbTexto);
        rbImagen = view.findViewById(R.id.rbImagen);
        rbVideo = view.findViewById(R.id.rbVideo);
        etTituloPublicacion = view.findViewById(R.id.etTituloPublicacion);
        llTexto = view.findViewById(R.id.linearLayoutTexto);
        llImagen = view.findViewById(R.id.linearLayoutImagen);
        llVideo = view.findViewById(R.id.linearLayoutVideo);
        radioGroup = view.findViewById(R.id.radioGroup2);

        if (rbTexto.isChecked())
        {
            Toast.makeText(getContext(), "Pulado Texto", Toast.LENGTH_SHORT).show();
            llTexto.setVisibility(View.VISIBLE);
            llImagen.setVisibility(View.GONE);
            llVideo.setVisibility(View.GONE);
        }
        else if (rbImagen.isChecked()){
            Toast.makeText(getContext(), "Pulado Imagen", Toast.LENGTH_SHORT).show();
            llTexto.setVisibility(View.GONE);
            llImagen.setVisibility(View.VISIBLE);
            llVideo.setVisibility(View.GONE);
        }
        else if (rbVideo.isChecked()){
            Toast.makeText(getContext(), "Pulado Video", Toast.LENGTH_SHORT).show();
            llTexto.setVisibility(View.GONE);
            llImagen.setVisibility(View.GONE);
            llVideo.setVisibility(View.VISIBLE);
        }


    }
}
