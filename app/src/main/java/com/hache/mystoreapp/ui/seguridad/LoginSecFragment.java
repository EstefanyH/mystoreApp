package com.hache.mystoreapp.ui.seguridad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hache.mystoreapp.databinding.FragmentSecLoginBinding;


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


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}