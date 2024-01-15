package com.example.myapplication.gestorBD;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.myapplication.clases.Empresa;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class PeticionHTTP {
    String url;
    DataBase db;
    public PeticionHTTP(DataBase db, String url){
        this.db=db;
        this.url=url;
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
                    db.insertEmpresas(convertirClase(respuesta));

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



    private List<Empresa>  convertirClase(String respuesta) {
        List<Empresa> empresas=new ArrayList<Empresa>();
        ObjectMapper objectMapper = new ObjectMapper();
        Empresa empresa;

        try {
            JsonNode jsonArray = objectMapper.readTree(respuesta);

            // Iterar sobre el array de objetos
            for (JsonNode jsonNode : jsonArray) {
                // Acceder a los valores de cada objeto
                String nombre = jsonNode.get("username").asText();
                String mail = jsonNode.get("email").asText();
                String activo = jsonNode.get("state").asText() + "";
                String direccion=jsonNode.get("adress").asText();

                String mision=jsonNode.get("country").asText();
                String vision=jsonNode.get("datecreation").asText();
                int codigo=jsonNode.get("id").asInt();
                int ruc=jsonNode.get("type").asInt();
                int telefono=jsonNode.get("phone").asInt();

                empresa = new Empresa(nombre, ruc, direccion, mail, telefono, activo, mision, vision, codigo);
                empresas.add(empresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("log", "Fallo criminal");
        }
        return empresas;
    }


}

