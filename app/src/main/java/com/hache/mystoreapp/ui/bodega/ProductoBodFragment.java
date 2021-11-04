package com.hache.mystoreapp.ui.bodega;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hache.mystoreapp.databinding.FragmentBodProductoBinding;
import com.hache.mystoreapp.ui.cliente.DetalleCliFragment;


public class ProductoBodFragment extends Fragment {

    private ProductoBodViewModel productoBodViewModel;
    private FragmentBodProductoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        productoBodViewModel =
                new ViewModelProvider(this).get(ProductoBodViewModel.class);

        binding = FragmentBodProductoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public void onDetalle(View v){
    }

    public void onNewProducto(View v){

    }
}