package com.example.androidvinted.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidvinted.R;
import com.example.androidvinted.model.pojo.Products;

import org.w3c.dom.Text;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Products> products;
    private Context context;

    public ProductAdapter(List<Products> products, Context context){

    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_imagen;
        private TextView tv_idProducto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_imagen = itemView.findViewById(R.id.iv_imagen);
            tv_idProducto = itemView.findViewById(R.id.tv_idProducto);
        }
    }

}
