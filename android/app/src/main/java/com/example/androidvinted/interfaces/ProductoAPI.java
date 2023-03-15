package com.example.androidvinted.interfaces;

import com.example.androidvinted.model.pojo.Products;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductoAPI {
    @GET("api/producto/{id}")
    public Call<Products> find(@Path("id") String id);
}
