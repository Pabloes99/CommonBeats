package com.pabloes99.commonbeats.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ivbaranov.mli.MaterialLetterIcon;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.model.Repository.EventosCreadosRepository;
import com.pabloes99.commonbeats.model.pojo.Evento;

import java.util.List;

public class EventosCreadosAdapter extends RecyclerView.Adapter<EventosCreadosAdapter.ViewHolder> {

    List<Evento> eventosCreados;
    private OnClickEventoCreadoListener onClickEventoCreadoListener;


    public EventosCreadosAdapter(){
        eventosCreados = EventosCreadosRepository.getInstancia().getListaEventosCreados();
    }


    public interface OnClickEventoCreadoListener{
        void onClickEventoCreado(Evento evento);
    }

    public void setOnClickEventoCreadoListener(OnClickEventoCreadoListener onClickEventoCreadoListener){
        this.onClickEventoCreadoListener = onClickEventoCreadoListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evento_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitulo.setText(eventosCreados.get(position).getTitulo());
        holder.mliEvento.setLetter(eventosCreados.get(position).getTitulo());

        if (holder != null)
            holder.bindEventoCreado(onClickEventoCreadoListener, position);
    }

    @Override
    public int getItemCount() {
        return eventosCreados.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitulo;
        MaterialLetterIcon mliEvento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitulo = itemView.findViewById(R.id.tvTituloEvento);
            mliEvento = itemView.findViewById(R.id.mliEvento);
        }

        public void bindEventoCreado(final OnClickEventoCreadoListener onClickEventoCreadoListener, final int position) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickEventoCreadoListener.onClickEventoCreado(eventosCreados.get(position));
                }
            });
        }
    }
}
