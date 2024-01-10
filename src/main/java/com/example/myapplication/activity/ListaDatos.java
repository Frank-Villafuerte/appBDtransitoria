package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.fragments.Lista;

public class ListaDatos extends AppCompatActivity {

    //List<Empresa> empresaList;
    //Lista fragLista=new Lista();
    //Bundle bundle=new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_datos);
        //empresaList= new ArrayList<>();
        //iniciarDatos();
       /* bundle.putParcelableArrayList("listaEmpresas", (ArrayList<? extends Parcelable>) empresaList);
        fragLista.setArguments(bundle);*/
        cargarFragment(new Lista(),false);

    }
    public void cargarFragment(Fragment fragment, boolean volver) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmento, fragment);
        if(volver){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
   /* public void iniciarDatos(){
        empresaList.add(new Empresa("razon1",123,"dir1","mail1",456,"activo",
                "mision1","vision1",564));
        empresaList.add(new Empresa("razon2",123,"dir2","mail2",456,"activo",
                "mision2","vision2",64));
        empresaList.add(new Empresa("razon3",123,"dir3","mail3",456,"activo",
                "mision3","vision3",446));
    }*/
    /*public List<Empresa> obtenerLista(){
        return empresaList;
    }*/
}