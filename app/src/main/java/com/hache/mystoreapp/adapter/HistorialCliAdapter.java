package com.hache.mystoreapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hache.mystoreapp.R;
import com.hache.mystoreapp.bean.Producto;

import java.util.List;

public class HistorialCliAdapter extends RecyclerView.Adapter<HistorialCliAdapter.ViewHolder> {

    List<Producto> lista ;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public HistorialCliAdapter(Context context, List<Producto> items) {
        this.mInflater = LayoutInflater.from(context);
        this.lista = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cli_historial, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int pos) {
        holder.txt_cli_hs_producto.setText(lista.get(pos).getNombre());
        holder.txt_cli_hs_tienda.setText(lista.get(pos).getTienda());
        holder.txt_cli_hs_detalle.setText(lista.get(pos).getDetalle());
        holder.txt_cli_hs_precio.setText(lista.get(pos).getCosto());
        holder.txt_cli_hs_fecha.setText(lista.get(pos).getFecha());
        holder.txt_cli_hs_estado.setText(lista.get(pos).getEstado());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView txt_cli_hs_producto;
        TextView txt_cli_hs_tienda;
        TextView txt_cli_hs_detalle;
        TextView txt_cli_hs_precio;
        TextView txt_cli_hs_fecha;
        TextView txt_cli_hs_estado;

        public ViewHolder(View view) {
            super(view);
            txt_cli_hs_producto = (TextView) view.findViewById(R.id.txt_cli_hs_producto);
            txt_cli_hs_tienda = (TextView) view.findViewById(R.id.txt_cli_hs_tienda);
            txt_cli_hs_detalle = (TextView) view.findViewById(R.id.txt_cli_hs_detalle);
            txt_cli_hs_precio = (TextView) view.findViewById(R.id.txt_cli_hs_precio);
            txt_cli_hs_fecha = (TextView) view.findViewById(R.id.txt_cli_hs_fecha);
            txt_cli_hs_estado = (TextView) view.findViewById(R.id.txt_cli_hs_estado);
        }

        @Override
        public void onClick(View view) {

        }
    }

    Producto getItem(int id) {
        return lista.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;


        if(getItemCount()== 0){
            mClickListener.onEmpty();
        }

    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
        void onEmpty();
    }

}
