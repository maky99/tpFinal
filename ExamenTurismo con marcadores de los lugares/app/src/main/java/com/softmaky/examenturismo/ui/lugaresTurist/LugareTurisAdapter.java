package com.softmaky.examenturismo.ui.lugaresTurist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.softmaky.examenturismo.Lugares.Lugar;
import com.softmaky.examenturismo.R;


import java.nio.Buffer;
import java.util.List;

public class LugareTurisAdapter extends RecyclerView.Adapter<LugareTurisAdapter.ViewHolder> {

    private List<Lugar> listaDeLugares;
    private Context context;
    private LayoutInflater li;
    private int card;

    public LugareTurisAdapter(@NonNull Context context,int card,@NonNull List<Lugar>listaDeLugares,LayoutInflater li) {
        this.listaDeLugares = listaDeLugares;
        this.context = context;
        this.li = li;
        this.card=card;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=li.inflate(R.layout.card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lugar lugar=listaDeLugares.get(position);
        holder.tvNombre.setText(lugar.getNombre());
        holder.tvDescripcion.setText(lugar.getDescripcion());
        holder.ivImagen.setImageResource(lugar.getFoto());
        holder.btMasInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                bundle.putSerializable("recuperadolugar",lugar);
                Navigation.findNavController((Activity) context,R.id.nav_host_fragment_content_main).navigate(R.id.detallesFragment,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDeLugares.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombre;
        private TextView tvDescripcion;
        private ImageView ivImagen;
        private Button btMasInfo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre=itemView.findViewById(R.id.tvNombre);
            tvDescripcion=itemView.findViewById(R.id.tvDescripcion);
            ivImagen=itemView.findViewById(R.id.ivImagen);
            btMasInfo=itemView.findViewById(R.id.btMasInfo);

        }
    }
}
