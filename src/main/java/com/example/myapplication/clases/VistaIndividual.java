package com.example.myapplication.clases;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class VistaIndividual  extends RecyclerView.ViewHolder {
    public TextView elemento1;
    public TextView elemento2;
    public TextView elemento3;

    public VistaIndividual(@NonNull View itemView) {
        super(itemView);
        elemento1 = itemView.findViewById(R.id.elemento1);
        elemento2 = itemView.findViewById(R.id.elemento2);
        elemento3 = itemView.findViewById(R.id.elemento3);

    }
    void bindData(final Empresa item){

        elemento1.setText(item.getCodigo()+"");
        elemento2.setText(item.getRuc()+"");
        elemento3.setText(item.getRazon());
    }
}
