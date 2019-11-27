package com.pabloes99.commonbeats.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ivbaranov.mli.MaterialLetterIcon;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.model.Repository.UsuarioRepositorio;
import com.pabloes99.commonbeats.model.pojo.Usuario;

import java.util.List;

public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.ViewHolder> {

    List<Usuario> amigos;

    public AmigosAdapter(){
        amigos = UsuarioRepositorio.getInstance().getListaAmigos();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amigo_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return amigos.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvUsuario.setText(amigos.get(position).getUsuario());
        holder.mliUsuario.setLetter(amigos.get(position).getUsuario());
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUsuario;
        private MaterialLetterIcon mliUsuario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsuario = itemView.findViewById(R.id.tvUsuario);
            mliUsuario = itemView.findViewById(R.id.mliUsuario);
        }
    }
}
