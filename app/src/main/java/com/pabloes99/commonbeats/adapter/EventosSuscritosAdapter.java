package com.pabloes99.commonbeats.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ivbaranov.mli.MaterialLetterIcon;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.model.Repository.EventosSuscritosRepository;
import com.pabloes99.commonbeats.model.pojo.Evento;

import java.util.List;

public class EventosSuscritosAdapter extends RecyclerView.Adapter<EventosSuscritosAdapter.ViewHolder> {


    List<Evento> eventosSuscritos;

    public EventosSuscritosAdapter(){
        eventosSuscritos = EventosSuscritosRepository.getInstance().getListEventosSuscritos();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evento_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvTitulo.setText(eventosSuscritos.get(position).getTitulo());
        holder.mliEvento.setLetter(eventosSuscritos.get(position).getTitulo());
    }

    @Override
    public int getItemCount() {
        return eventosSuscritos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitulo;
        private MaterialLetterIcon mliEvento;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitulo = itemView.findViewById(R.id.tvTituloEvento);
            mliEvento = itemView.findViewById(R.id.mliEvento);
        }
    }
}
