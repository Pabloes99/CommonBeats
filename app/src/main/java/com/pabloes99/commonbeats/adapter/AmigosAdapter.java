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
    OnClickAmigo onClickAmigo;

    public AmigosAdapter(){
        amigos = UsuarioRepositorio.getInstance().getListaAmigos();
    }

    public interface OnClickAmigo{
        void onCliclAmigo(Usuario usuario);
    }

    public void setOnCliclAmigo(OnClickAmigo onCliclAmigo){
        this.onClickAmigo = onCliclAmigo;
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

        if (holder != null)
        {
            holder.bindCliclAmigo(onClickAmigo,position);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUsuario;
        private MaterialLetterIcon mliUsuario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsuario = itemView.findViewById(R.id.tvUsuario);
            mliUsuario = itemView.findViewById(R.id.mliUsuario);
        }

        public void bindCliclAmigo(final OnClickAmigo onClickAmigo, final int position) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickAmigo.onCliclAmigo(amigos.get(position));
                }
            });
        }
    }
}
