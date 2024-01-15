package com.example.myapplication.gestorBD;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;

public interface ApiService {
    @GET("diverticuentos/userp")
    Call<String> getString();


   //Call<List<Posts>> getPosts();
    //reemplazar

}
