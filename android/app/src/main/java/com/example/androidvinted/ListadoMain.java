package com.example.androidvinted;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidvinted.adapter.ProductAdapter;
import com.example.androidvinted.api.ApiClient;
import com.example.androidvinted.api.ProductoAPI;
import com.example.androidvinted.model.pojo.Products;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoMain extends AppCompatActivity {

    private List<Products> products;
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<String> productNames = new ArrayList<>();


    TextView idProducto;
    TextView tv_name;
    TextView prize;
    TextView description;
    TextView existences;
    TextView iv_imagen;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        Button addMenuBoton = findViewById(R.id.addForm);

        addMenuBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent screenChanger = new Intent(                  //Origen y destino objeto que permite pasar de una pantalla a otra
                        addMenuBoton.getContext(),
                        addProducto.class
                );

                addMenuBoton.getContext().startActivity(screenChanger);

            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rv_products);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        showProducts();

    }

    public void showProducts(){
        Call<List<Products>> call = ApiClient.getClient().create(ProductoAPI.class).getProductos();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                List<Products> products  = response.body();
                products = response.body();
                productAdapter = new ProductAdapter(products, getApplicationContext());
                //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, productNames);

                recyclerView.setAdapter(productAdapter);
                productAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                    Toast.makeText(ListadoMain.this, "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
