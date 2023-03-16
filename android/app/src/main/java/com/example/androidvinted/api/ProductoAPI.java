package com.example.androidvinted.api;

import com.example.androidvinted.model.pojo.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductoAPI {
    @GET("VintedAPI/webresources/productos")
    Call<List<Products>> getProductos();
    /*
    @GET("api/producto/{id}")
    public Call<Products> find(@Path("id") String id);
    */
}
