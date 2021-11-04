package com.hache.mystoreapp.ui.cliente;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.hache.mystoreapp.MainActivity;
import com.hache.mystoreapp.R;
import com.hache.mystoreapp.databinding.FragmentCliProductoBinding;


public class ProductoCliFragment extends Fragment {

    private ProductoCliViewModel productoCliViewModel;
    private FragmentCliProductoBinding binding;

    MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        productoCliViewModel =
                new ViewModelProvider(this).get(ProductoCliViewModel.class);
        mainActivity = (MainActivity) getActivity();

        binding = FragmentCliProductoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnCliDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*NavDeepLinkRequest request = NavDeepLinkRequest.Builder
                        .fromUri(Uri.parse("android-app://androidx.navigation.app/profile"))
                        .build(); */

                //NavHostFragment.findNavController(this).navigate(request);
                mainActivity.irDetalle();
            }
        });
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
        //Intent intent = new Intent(this, DetalleCliFragment.class);
        //startActivity(intent);

        // Crea el nuevo fragmento y la transacción.
        /*Fragment nuevoFragmento = new DetalleCliFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container , nuevoFragmento);
        transaction.addToBackStack(null);

        // Commit a la transacción
        transaction.commit(); */
        Fragment nuevoFragmento = new DetalleCliFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, nuevoFragmento);
        transaction.addToBackStack(null);
        transaction.commit();
        //mainActivity.CambioNewFragment("fragment_cli_producto" , "fragment_cli_detalle");
    }
}