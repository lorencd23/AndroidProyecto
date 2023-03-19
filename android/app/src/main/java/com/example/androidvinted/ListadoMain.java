package com.example.androidvinted;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
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

    private EditText mEditText;
    private ArrayAdapter<String> mAdapter;

    private List<Products> products;
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<String> productNames = new ArrayList<>();

    private List<Products> filteredProducts = new ArrayList<>();


    TextView idProducto;
    TextView tv_name;
    TextView prize;
    TextView description;
    TextView existences;
    TextView iv_imagen;
    Button button;

    EditText et_busqueda;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        et_busqueda = findViewById(R.id.busqueda);
        String text = et_busqueda.getText().toString();



        Button addMenuBoton = findViewById(R.id.addForm);
        Button buscar = findViewById(R.id.buscar);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = et_busqueda.getText().toString();
                showProducts(text);
            }
        });

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

    }

    public void showProducts(String palabra){
        Call<List<Products>> call = ApiClient.getClient().create(ProductoAPI.class).getProductosPorPalabra(palabra);
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                response.toString();

                List<Products> products  = response.body();
                products = response.body();
                productAdapter = new ProductAdapter(products, getApplicationContext());

                //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, productNames);

                recyclerView.setAdapter(productAdapter);
                productAdapter.notifyDataSetChanged();
                // En lugar de notificar cambios, se llama a filtrarProductos para mostrar todos los productos
                //filtrarProductos("");

            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                    Toast.makeText(ListadoMain.this, "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void filtrarProductos(String palabra) {
        ProductoAPI productoAPI = ApiClient.getClient().create(ProductoAPI.class);
        Call<List<Products>> call = productoAPI.getProductosPorPalabra(palabra);
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                if (response.isSuccessful()) {
                    List<Products> filteredProducts = response.body();

                    // Aquí se actualiza la lista de productos filtrados y se establece en el adaptador del RecyclerView
                    ListadoMain.this.filteredProducts = filteredProducts;
                    productAdapter.setProducts(filteredProducts);
                    productAdapter.notifyDataSetChanged();
                } else {
                    Log.d("TAG", "Error en la llamada: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Log.d("TAG", "Error al obtener productos", t);
            }
        });
    }


}
