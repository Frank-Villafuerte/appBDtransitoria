package com.example.myapplication.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<VistaIndividual> {

    private Context contexto;
    private List<Empresa> datos;
    private LayoutInflater inflater;

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

    @Override
    public void onBindViewHolder(@NonNull VistaIndividual holder, int position) {
        holder.bindData(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
