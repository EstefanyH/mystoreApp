package com.hache.mystoreapp.ui.cliente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hache.mystoreapp.R;
import com.hache.mystoreapp.bean.HistorialPedido;
import com.hache.mystoreapp.databinding.FragmentCliHistorialBinding;

import java.util.List;

//import butterknife.BindView;


public class HistorialCliFragment extends Fragment {

    private HistorialCliViewModel historialCliViewModel;
    private FragmentCliHistorialBinding binding;

    //@BindView(R.id.rv_cli_historial)
    private RecyclerView rv_lista;

    //HistorialCliAdapter mAdapter;
    List<HistorialPedido> lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        historialCliViewModel =
                new ViewModelProvider(this).get(HistorialCliViewModel.class);

        binding = FragmentCliHistorialBinding.inflate(inflater, container, false);
       View root = binding.getRoot();
/*
        lista = new ArrayList<>();

        rv_lista.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new HistorialCliAdapter(getData());
        rv_lista.setAdapter(mAdapter); */

        return root;
    }

    private List<HistorialPedido> getData(){
        HistorialPedido bean = new HistorialPedido();
        lista.add(bean);
        return lista;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}