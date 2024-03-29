package com.pabloes99.commonbeats.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ivbaranov.mli.MaterialLetterIcon;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.data.Repository.EventoRepository;
import com.pabloes99.commonbeats.data.pojo.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder> {

    List<Evento> eventos;
    OnUserClickListenner userClickListenner;

    public EventoAdapter(){
        this.eventos = (ArrayList) EventoRepository.getInstance().getList();
    }

    public interface OnUserClickListenner{
        void onUserClick(Evento evento);
    }

    public void setOnUserCliclListenner(OnUserClickListenner userClickListenner){
        this.userClickListenner = userClickListenner;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evento_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvTitulo.setText(eventos.get(position).getTitulo());
        holder.mliEvento.setLetter(eventos.get(position).getTitulo());

        if (holder != null)
            holder.bindUserClickListenner(userClickListenner, position);

    }

    @Override
    public int getItemCount() {
        return  eventos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitulo;
        private MaterialLetterIcon mliEvento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitulo = itemView.findViewById(R.id.tvTituloEvento);
            mliEvento = itemView.findViewById(R.id.mliEvento);
        }

        public void bindUserClickListenner(final OnUserClickListenner userClickListenner, final int position) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userClickListenner.onUserClick(eventos.get(position));
                }
            });
        }
    }
}
