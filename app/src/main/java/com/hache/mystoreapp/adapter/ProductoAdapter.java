package com.hache.mystoreapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hache.mystoreapp.R;
import com.hache.mystoreapp.bean.Producto;

import java.util.ArrayList;
import java.util.List;


public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    List<Producto> lista = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_cli_producto;
        TextView txt_cli_tienda;
        TextView txt_cli_detalle;
        TextView txt_cli_precio;


        public ViewHolder(View view) {
            super(view);

            txt_cli_producto = (TextView) view.findViewById(R.id.txt_cli_producto);
            txt_cli_tienda = (TextView) view.findViewById(R.id.txt_cli_tienda);
            txt_cli_detalle = (TextView) view.findViewById(R.id.txt_cli_detalle);
            txt_cli_precio = (TextView) view.findViewById(R.id.txt_cli_precio);
        }

    }

}
