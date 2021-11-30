package com.hache.mystoreapp.ui.bodega;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hache.mystoreapp.databinding.FragmentBodPerfilBinding;

public class PerfilBodFragment extends Fragment {

    private PerfilBodViewModel perfilBodViewModel;
    private FragmentBodPerfilBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        perfilBodViewModel =
                new ViewModelProvider(this).get(PerfilBodViewModel.class);

        binding = FragmentBodPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setHasOptionsMenu(true);
        //final TextView textView = binding.textBobPerfil;
        /*perfilBodViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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