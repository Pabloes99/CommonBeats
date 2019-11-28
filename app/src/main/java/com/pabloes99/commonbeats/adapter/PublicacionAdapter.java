package com.pabloes99.commonbeats.adapter;

import android.icu.text.AlphabeticIndex;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.model.Repository.PublicacionRepositorio;
import com.pabloes99.commonbeats.model.pojo.Publicacion;

import java.util.List;

public class PublicacionAdapter extends RecyclerView.Adapter<PublicacionAdapter.ViewHolder> {

    List<Publicacion> publicaciones;

    public PublicacionAdapter(){
        publicaciones = PublicacionRepositorio.getInstance().getListaPublicaciones();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.publicacion_imagen_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTituloPublicacion.setText(publicaciones.get(position).getTitulo());
        holder.imgPublicacion.setImageResource(R.drawable.ic_twitter);
    }

    @Override
    public int getItemCount() {
        return publicaciones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTituloPublicacion;
        ImageView imgPublicacion;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTituloPublicacion = itemView.findViewById(R.id.tvTituloPublicacion);
            imgPublicacion = itemView.findViewById(R.id.imgPublicacion);
        }
    }
}
