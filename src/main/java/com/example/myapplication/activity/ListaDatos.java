package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.clases.Empresa;
import com.example.myapplication.fragments.Lista;
import com.example.myapplication.gestorBD.ApiService;
import com.example.myapplication.gestorBD.RecibirDatos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ListaDatos extends AppCompatActivity {

    private List<Empresa> empresaList;
    private String url = "http://134.122.125.35/";
    String datos;
    Lista fragLista;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_datos);
        fragLista=new Lista();
        bundle=new Bundle();
        getPost();
        Log.d("log","bundle vaciopre "+bundle.isEmpty());

        Log.d("log","bundle vacio"+bundle.isEmpty());


    }
    public void  getPost(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this.url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ApiService apiService=retrofit.create(ApiService.class);
        //Call<List<Posts>> call=apiService.getPosts();
        Call<String> call=apiService.getString();
        call.enqueue(new Callback<String>() {
            public String respuesta="";
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()){
                    respuesta= response.body();
                    respuesta=respuesta.substring(respuesta.indexOf("["),respuesta.lastIndexOf("]")+1);
                    respuesta=respuesta.replace("null","0");
                    respuesta=respuesta.replace("\"\"","\"vacio\"");
                    bundle.putString("info",respuesta);
                    fragLista.setArguments(bundle);
                    cargarFragment(fragLista, false);
                    Log.d("NetworkTask","Exito: " +respuesta);
                    Log.d("log","tamanio on response: : " +respuesta.length());

                }
                else{
                    Log.d("NetworkTask","Fallo");

                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("NetworkTask","Fallo total "+t.getMessage());
            }
        });



    }
    public void cargarFragment(Fragment fragment, boolean volver) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmento, fragment);
        if (volver) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }



       /* for (int i = 0; i < jsonArray.length(); i++) {
            // Obtener el objeto JSON actual
            String razon, direccion, mail, estado, mision, vision;
            int ruc, telefono, codigo;
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            // Acceder a los valores del objeto JSON
            razon=jsonObject.getString("username")+" ";
            direccion=jsonObject.getString("adress")+" ";
            mail=jsonObject.getString("email")+"";
            estado=jsonObject.getString("state")+" ";
            mision=jsonObject.getString("country")+" ";
            vision=jsonObject.getString("datecreation")+" ";
            ruc=jsonObject.getInt("type")+0;
            telefono=jsonObject.getInt("phone")+0;
            codigo=jsonObject.getInt("id")+0;
            empresa=new Empresa(razon,ruc,direccion,mail,telefono,estado,mision,vision,codigo);
            empresaList.add(empresa);

        }
*/



        /*empresaList.ad*d(new Empresa("razon1",123,"dir1","mail1",456,"activo",
                "mision1","vision1",564));
        empresaList.add(new Empresa("razon2",123,"dir2","mail2",456,"activo",
                "mision2","vision2",64));
        empresaList.add(new Empresa("razon3",123,"dir3","mail3",456,"activo",
                "mision3","vision3",446));*/

    /*public List<Empresa> obtenerLista(){
        return empresaList;
    }
    }
     */

}
