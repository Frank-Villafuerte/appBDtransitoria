package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Lista extends Fragment {
    Button add, modify,erase,deactivate,activate, exit;
    public Lista() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_lista, container, false);
        add=view.findViewById(R.id.agregar);
        modify=view.findViewById(R.id.modificar);
        erase=view.findViewById(R.id.eliminar);
        deactivate=view.findViewById(R.id.inactivar);
        activate=view.findViewById(R.id.reactivar);
        exit=view.findViewById(R.id.salir);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método en la Activity para cambiar el Fragment
                ((ListaDatos) requireActivity()).cargarFragment(new Datos(),true);
            }
        });
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método en la Activity para cambiar el Fragment
                ((ListaDatos) requireActivity()).cargarFragment(new Datos(),true);
            }
        });
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método en la Activity para cambiar el Fragment
                ((ListaDatos) requireActivity()).cargarFragment(new Datos(),true);
            }
        });
        deactivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método en la Activity para cambiar el Fragment
                ((ListaDatos) requireActivity()).cargarFragment(new Datos(),true);
            }
        });
        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método en la Activity para cambiar el Fragment
                ((ListaDatos) requireActivity()).cargarFragment(new Datos(),true);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    getActivity().finish();
                }
            }
        });
        return view;
    }

}