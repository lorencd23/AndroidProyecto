package com.example.androidvinted;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidvinted.adapter.ProductAdapter;
import com.example.androidvinted.api.ApiClient;
import com.example.androidvinted.api.ProductoAPI;
import com.example.androidvinted.model.pojo.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoDescripcion extends AppCompatActivity {
    private List<Products> products;
    private ProductAdapter productAdapter;

    TextView tv_name;
    TextView prize;
    TextView description;
    TextView existences;
    ImageView img;
    AutoCompleteTextView searchEditText;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        //setContentView(R.layout.activity_listado);

        //showProducts();

        Intent intent = getIntent();
        String productId = intent.getStringExtra("productId");
        String productName = intent.getStringExtra("productName");
        String productPrice = intent.getStringExtra("productPrice");
        String productDescription = intent.getStringExtra("productDescription");
        String productExistences = intent.getStringExtra("productExistences");
        String productImagen = intent.getStringExtra("productosImg");

        tv_name = findViewById(R.id.nombreProducto);
        prize = findViewById(R.id.Precio);
        description = findViewById(R.id.Descripcion);
        existences = findViewById(R.id.Existencias);
        img = findViewById(R.id.imageDescr);
        //searchEditText = findViewById(R.id.busqueda);


        tv_name.setText(productName);
        prize.setText(productPrice);
        description.setText(productDescription);
        existences.setText(productExistences + " productos en stock");

        Glide.with(this).load(productImagen).into(img);

        //tv_name.setText();
/*
        Call<List<Products>> call = ApiClient.getClient().create(ProductoAPI.class).getProductos();
        call.enqueue(new Callback<List<Products>>() {

            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                List<Products> products  = response.body();
                products = response.body();
                for(int i=0; i<=products.size(); i++){
                    if(i == 1){
                        tv_name.setText(products.get(i).getName());
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });

*/
/*
        for (Products product : products) {
            tv_name.setText(product.getName());
        }
*/

        //String productName = searchEditText.getText().toString().trim();
/*
        for (Products product : products) {
            if (product.getName().equals(productName)) {

            }
        }
*/
    }
/*
    public void showProducts(){
        Call<List<Products>> call = ApiClient.getClient().create(ProductoAPI.class).getProductos();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                List<Products> products  = response.body();
                products = response.body();

                productAdapter = new ProductAdapter(products, getApplicationContext());
                //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, productNames);

                productAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Toast.makeText(ProductoDescripcion.this, "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        });
    }
*/

}
