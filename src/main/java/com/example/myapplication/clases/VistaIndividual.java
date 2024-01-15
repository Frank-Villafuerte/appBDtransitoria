package com.example.myapplication.clases;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.gestorBD.DataBase;
import com.example.myapplication.gestorBD.DatabaseSingleton;

public class VistaIndividual  extends RecyclerView.ViewHolder {



    public TextView elemento1;
    public TextView elemento2;
    public TextView elemento3;
    public CardView cardView;

    public VistaIndividual(@NonNull View itemView) {
        super(itemView);
        elemento1 = itemView.findViewById(R.id.elemento1);
        elemento2 = itemView.findViewById(R.id.elemento2);
        elemento3 = itemView.findViewById(R.id.elemento3);
        cardView=itemView.findViewById(R.id.cv);

    }
    void bindData(final Empresa item){

        elemento1.setText(item.getCodigo()+"");
        elemento2.setText(item.getRuc()+"");
        elemento3.setText(item.getRazon());


    }
}
