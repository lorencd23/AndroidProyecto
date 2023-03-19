package com.example.androidvinted.api;

import com.example.androidvinted.model.pojo.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductoAPI {
    @GET("VintedAPI/webresources/productos")
    Call<List<Products>> getProductos();

    @POST("VintedAPI/webresources/productos/add")
    Call<Boolean> addProducto(@Body Products product);

    @GET("VintedAPI/webresources/productos/{filtro}")
    Call<List<Products>> getProductosPorPalabra(@Path("filtro") String filtro);


    /*
    @GET("api/producto/{id}")
    public Call<Products> find(@Path("id") String id);
    */
}
