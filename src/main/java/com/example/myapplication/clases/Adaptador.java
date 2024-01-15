package com.example.myapplication.clases;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<VistaIndividual> {

    private Context contexto;
    private List<Empresa> datos;
    private LayoutInflater inflater;
    private int seleccionado=-1;

    public Adaptador(List<Empresa> datos,Context contexto ) {
        this.inflater=LayoutInflater.from(contexto);
        this.contexto=contexto;
        this.datos = datos;
    }

    @NonNull
    @Override
    public VistaIndividual onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item,null);
        return new VistaIndividual(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull VistaIndividual holder, int position) {
        holder.bindData(datos.get(position));
        if(seleccionado==-1){
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(contexto, R.color.p1));
        }
        else{
            if(seleccionado== holder.getAbsoluteAdapterPosition()){
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(contexto, R.color.light_blue_600));
            }
            else{
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(contexto, R.color.p1));
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(contexto, R.color.light_blue_600));
                if(seleccionado!= holder.getAbsoluteAdapterPosition()){
                    notifyItemChanged(seleccionado);
                    seleccionado=holder.getAbsoluteAdapterPosition();
                }
            }
        });


    }
    public Empresa getSelected(){
        if(seleccionado!=-1){
            return datos.get(seleccionado);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
