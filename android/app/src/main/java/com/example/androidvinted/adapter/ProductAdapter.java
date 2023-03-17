package com.example.androidvinted.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidvinted.ListadoMain;
import com.example.androidvinted.ProductoDescripcion;
import com.example.androidvinted.R;
import com.example.androidvinted.model.pojo.Products;
import com.example.androidvinted.view.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Products> products;

    private Context context;
    //private String url = "http://192.168.1.138:8080/productos/img/";

    public ProductAdapter(List<Products> products, Context context){
        this.products = products;
        this.context = context;

    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_products, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(products.get(position).getName());
        holder.tv_prize.setText(products.get(position).getPrize());

        Glide.with(holder.itemView.getContext())
                .load(products.get(position).getImg())
                .into(holder.iv_imagen);

        holder.tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenChanger = new Intent(                  //Origen y destino objeto que permite pasar de una pantalla a otra
                        holder.tarjeta.getContext(),
                        ProductoDescripcion.class
                );

                screenChanger.putExtra("productId", products.get(position).getIdProducto());
                screenChanger.putExtra("productName", products.get(position).getName());
                screenChanger.putExtra("productPrice", products.get(position).getPrize());
                screenChanger.putExtra("productDescription", products.get(position).getDescription());
                screenChanger.putExtra("productExistences", products.get(position).getExistences());
                screenChanger.putExtra("productosImg", products.get(position).getImg());

                holder.tarjeta.getContext().startActivity(screenChanger);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_imagen;
        private TextView tv_name;
        private TextView tv_prize;
        private CardView tarjeta;
        //private LinearLayout ly_linearID;
        //private TextView tv_description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_imagen = itemView.findViewById(R.id.imageView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_prize = itemView.findViewById(R.id.tv_prize);
            tarjeta = itemView.findViewById(R.id.tarjeta);
            //ly_linearID = itemView.findViewById(R.id.linearID);
        }
    }

}
