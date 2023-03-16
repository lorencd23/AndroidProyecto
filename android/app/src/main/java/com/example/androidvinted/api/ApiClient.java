package com.example.androidvinted.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit;
    public static Retrofit getClient(){
         retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.138:8080/") //ip de clase 192.168.56.1 y la de casa 192.168.1.138
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         return retrofit;
    }

}
