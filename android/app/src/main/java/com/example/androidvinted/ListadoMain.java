package com.example.androidvinted;

import android.os.Bundle;
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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoMain extends AppCompatActivity {

    private List<Products> products;
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

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

        recyclerView = (RecyclerView) findViewById(R.id.rv_products);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        showProducts();

        /*
        idProducto = findViewById(R.id.idProducto);
        name = findViewById(R.id.name);
        prize = findViewById(R.id.prize);
        description = findViewById(R.id.description);
        existences = findViewById(R.id.existences);
        imagen = findViewById(R.id.imagen);
        button = findViewById(R.id.buttonBuscar);
        */
    }

    public void showProducts(){
        Call<List<Products>> call = ApiClient.getClient().create(ProductoAPI.class).getProductos();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                List<Products> products  = response.body();
                products = response.body();
                productAdapter = new ProductAdapter(products, getApplicationContext());
                recyclerView.setAdapter(productAdapter);
                productAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                    Toast.makeText(ListadoMain.this, "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*
    private void find(String idProducto){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ProductoAPI productoAPI = retrofit.create(ProductoAPI.class);
        Call<Products> call = productoAPI.find(idProducto);
        call.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                try{
                    if(response.isSuccessful()){
                        Products p = response.body();
                        String URL_IMG = "http://localhost:8080/VintedAPI/webresources/"+p.getIdProducto()+".png";
                        name.setText(p.getName());
                        //prize.setText(p.getPrize());
                        description.setText(p.getDescription());
                        //existences.setText(p.getExistences().toString());
                        Glide.with(getApplication()).load(URL_IMG).into(imagen);

                    }
                }catch (Exception ex){
                    Toast.makeText(ListadoMain.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                Toast.makeText(ListadoMain.this, "Error de conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

}
