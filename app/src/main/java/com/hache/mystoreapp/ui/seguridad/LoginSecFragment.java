package com.hache.mystoreapp.ui.seguridad;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hache.mystoreapp.R;
import com.hache.mystoreapp.databinding.FragmentRepPerfilBinding;
import com.hache.mystoreapp.databinding.FragmentSecLoginBinding;
import com.hache.mystoreapp.ui.repartidor.PerfilRepViewModel;


public class LoginSecFragment extends Fragment {

    private LoginSecViewModel loginSecViewModel;
    private FragmentSecLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginSecViewModel =
                new ViewModelProvider(this).get(LoginSecViewModel.class);

        binding = FragmentSecLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*
        final TextView textView = binding.textRepPerfil;
        pedidoRepViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        }); */
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}