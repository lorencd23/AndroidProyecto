package com.example.androidvinted;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.androidvinted.api.ApiClient;
import com.example.androidvinted.api.ProductoAPI;
import com.example.androidvinted.model.pojo.Products;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class addProducto extends AppCompatActivity {

    String nombre;
    String precio;
    String existencias;
    String img;
    String genero;
    String descripcion;

    EditText et_nombre;
    EditText et_precio;
    EditText et_existencias;
    EditText et_imagen;
    EditText et_descripcion;

    Button botonAdd;
    Button botonCancel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Spinner spinner = findViewById(R.id.spinner);
        List<String> opciones = Arrays.asList("Hombre", "Mujer", "Niño/a");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        et_nombre = findViewById(R.id.et_nombre);
        et_precio = findViewById(R.id.et_precio);
        et_existencias = findViewById(R.id.et_existencias);
        et_imagen = findViewById(R.id.et_link);
        et_descripcion = findViewById(R.id.et_descripcion);

        nombre = et_nombre.getText().toString();
        precio = et_precio.getText().toString();
        existencias = et_existencias.getText().toString();
        img = et_imagen.getText().toString();
        genero = spinner.getSelectedItem().toString();
        descripcion = et_descripcion.getText().toString();


        botonCancel = findViewById(R.id.buttonCancelar);
        botonAdd = findViewById(R.id.buttonAdd);

        botonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent screenChanger = new Intent(                  //Origen y destino objeto que permite pasar de una pantalla a otra
                        botonCancel.getContext(),
                        ListadoMain.class
                );

                botonCancel.getContext().startActivity(screenChanger);
            }
        });

        botonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductoAPI productoAPI = ApiClient.getClient().create(ProductoAPI.class);

                Products newProduct = new Products(0, nombre, precio, descripcion, existencias, genero, img);

                Call<Boolean> call = productoAPI.addProducto(newProduct);
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Producto agregado con éxito", Toast.LENGTH_SHORT).show();
                        } else {
                            int statusCode = response.code();
                            Log.d("TAG", "Error en la llamada: " + statusCode);
                            Toast.makeText(getApplicationContext(), "Producto agregado con éxito" + newProduct.getName() + ", " + newProduct.getPrize(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error al agregar producto2", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });





    }


}
