package com.example.androidvinted;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.androidvinted.interfaces.ProductoAPI;
import com.example.androidvinted.model.pojo.Products;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoMain extends AppCompatActivity {
    TextView idProducto;
    TextView name;
    TextView prize;
    TextView description;
    TextView existences;
    ImageView imagen;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        idProducto = findViewById(R.id.idProducto);
        name = findViewById(R.id.name);
        prize = findViewById(R.id.prize);
        description = findViewById(R.id.description);
        existences = findViewById(R.id.existences);
        imagen = findViewById(R.id.imagen);
        button = findViewById(R.id.buttonBuscar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                find(idProducto.getText().toString());
            }
        });
    }

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
                        String URL_IMG = "http://localhost:8080/img/"+p.getIdProducto()+".png";
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
    }

}
