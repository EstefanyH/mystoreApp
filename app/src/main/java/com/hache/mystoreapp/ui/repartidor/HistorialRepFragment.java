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

import com.hache.mystoreapp.databinding.FragmentRepHistorialBinding;

public class HistorialRepFragment extends Fragment {

    private HistorialRepViewModel historialRepViewModel;
    private FragmentRepHistorialBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        historialRepViewModel =
                new ViewModelProvider(this).get(HistorialRepViewModel.class);

        binding = FragmentRepHistorialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}