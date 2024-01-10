package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.clases.Adaptador;
import com.example.myapplication.clases.Empresa;
import com.example.myapplication.activity.ListaDatos;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Lista extends Fragment {
    Button add, modify,erase,deactivate,activate, exit;
    //Bundle argumentos;
    List<Empresa> empresas;
    private RecyclerView recyclerView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private Adaptador adaptador;

    public Lista() {

    }
    public static Lista newInstance(String param1, String param2) {
        Lista fragment = new Lista();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
        init(view);


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



    public void init(View view){
        empresas=new ArrayList<>();
        empresas.add(new Empresa("razon1", 123, "direccion1", "mail1", 91, "activo", "mision1", "vision1", 1234));
        empresas.add(new Empresa("razon2", 123, "direccion2", "mail2", 91, "activo", "mision2", "vision2", 1234));
        empresas.add(new Empresa("razon3", 123, "direccion3", "mail3", 91, "activo", "mision3", "vision3", 1234));
        empresas.add(new Empresa("razon4", 123, "direccion4", "mail4", 91, "activo", "mision4", "vision4", 1234));
        empresas.add(new Empresa("razon5", 123, "direccion5", "mail5", 91, "activo", "mision5", "vision5", 1234));

        Adaptador adaptador=new Adaptador(empresas,getActivity());
        RecyclerView recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adaptador);

    }
}