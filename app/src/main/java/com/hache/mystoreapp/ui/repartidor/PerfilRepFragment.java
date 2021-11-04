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

import com.hache.mystoreapp.databinding.FragmentRepPerfilBinding;

public class PerfilRepFragment extends Fragment {

    private PerfilRepViewModel pedidoRepViewModel;
    private FragmentRepPerfilBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        pedidoRepViewModel =
                new ViewModelProvider(this).get(PerfilRepViewModel.class);

        binding = FragmentRepPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
/*
        final TextView textView = binding.textRepPerfil;
        pedidoRepViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}