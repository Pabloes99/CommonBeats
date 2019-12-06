package com.pabloes99.commonbeats.iu.Perfil;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.data.Repository.UsuarioRepositorio;
import com.pabloes99.commonbeats.data.pojo.Usuario;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    public static final String TAG = "PerfilFragment";
    private TextView tvUsuario;
    private TextView tvNombre;
    private TextView tvEmail;
    private TextView tvFechaNacimiento;
    private TextView tvFechaRegistro;
    private ImageView imgPerfil;

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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvUsuario = view.findViewById(R.id.tvUsuarioPerfil);
        tvNombre = view.findViewById(R.id.tvNombrePeril);
        tvEmail = view.findViewById(R.id.tvEmailPerfil);
        tvFechaNacimiento = view.findViewById(R.id.tvFechaNachimientoPerfil);
        tvFechaRegistro = view.findViewById(R.id.tvFechaRegistroPerfil);
        imgPerfil = view.findViewById(R.id.imgPerfil);
        Usuario usuario = UsuarioRepositorio.getInstance().getListaAmigos().get(0);

        tvUsuario.setText(usuario.getUsuario());
        tvNombre.setText(usuario.getNombre() + " " + usuario.getApelldios());
        tvEmail.setText("Email: " + usuario.getEmail());
        tvFechaNacimiento.setText( "Fecha de naciemiento: " + usuario.getFechaNacimiento());
        tvFechaRegistro.setText("Fecha de registro: " +usuario.getFechaCreacion());
        imgPerfil.setImageResource(R.drawable.ic_twitter);
    }
}
