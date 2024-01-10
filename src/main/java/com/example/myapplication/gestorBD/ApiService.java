package com.example.myapplication.gestorBD;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {
    String post="posts";
    String juego="diverticuentos/userp";
    @GET(juego)  // Anotación para la solicitud GET y la URL del endpoint
    Call<String> getString();  // La firma del método que representa la solicitud
   //Call<List<Posts>> getPosts();
}
