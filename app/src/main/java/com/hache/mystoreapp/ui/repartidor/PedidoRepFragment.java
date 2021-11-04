package com.hache.mystoreapp.ui.repartidor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hache.mystoreapp.databinding.FragmentRepPedidoBinding;

public class PedidoRepFragment extends Fragment {

    private PedidoRepViewModel pedidoRepViewModel;
    private FragmentRepPedidoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        pedidoRepViewModel =
                new ViewModelProvider(this).get(PedidoRepViewModel.class);

        binding = FragmentRepPedidoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}