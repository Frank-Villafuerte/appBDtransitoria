package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.activity.ListaDatos;
import com.example.myapplication.R;


public class Datos extends Fragment {
    Button aceptar, cancelar;

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
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListaDatos) requireActivity()).cargarFragment(new Lista(),false);
                //
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListaDatos) requireActivity()).cargarFragment(new Lista(),false);
            }
        });
        return view;
    }
}