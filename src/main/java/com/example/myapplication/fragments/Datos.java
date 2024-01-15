package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.activity.ListaDatos;
import com.example.myapplication.R;
import com.example.myapplication.clases.Empresa;


public class Datos extends Fragment {
    Button aceptar, cancelar;
    Bundle recibir;
    Empresa empresa;
    TextView razon, ruc, direccion, mail, telefono, mision, vision;
    public Datos() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_datos, container, false);
        aceptar = view.findViewById(R.id.aceptar);
        cancelar=view.findViewById(R.id.cancelar);

        razon=view.findViewById(R.id.nombre);
        ruc=view.findViewById(R.id.ruc);
        direccion=view.findViewById(R.id.direccion);
        mail=view.findViewById(R.id.mail);
        telefono=view.findViewById(R.id.telefono);
        mision=view.findViewById(R.id.misionC);
        vision=view.findViewById(R.id.visionC);

        recibir=getArguments();
        if (recibir != null) {
            empresa = (Empresa) recibir.getSerializable("empresa");
            razon.setText(empresa.getRazon());
            ruc.setText(empresa.getRuc()+"");
            direccion.setText(empresa.getDireccion());
            mail.setText(empresa.getMail());
            telefono.setText(empresa.getTelefono()+"");
            mision.setText(empresa.getMision());
            vision.setText(empresa.getVision());
        }

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListaDatos) requireActivity()).onBackPressed();
                //
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListaDatos) requireActivity()).onBackPressed();
            }
        });
        return view;
    }

}