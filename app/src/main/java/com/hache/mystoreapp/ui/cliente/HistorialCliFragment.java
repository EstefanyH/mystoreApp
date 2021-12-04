package com.hache.mystoreapp.ui.cliente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hache.mystoreapp.R;
import com.hache.mystoreapp.adapter.HistorialCliAdapter;
import com.hache.mystoreapp.bean.Producto;
import com.hache.mystoreapp.util.BaseFragment;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HistorialCliFragment extends BaseFragment implements HistorialCliAdapter.ItemClickListener {

    private Unbinder unbinder = null;
    private OnFragmentInteractionListener mListener = null;
    HistorialCliAdapter adapter;

    @BindView(R.id.tv_cli_hs_empty)
    TextView tv_cli_hs_empy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cli_historial, container, false);
        unbinder = ButterKnife.bind(this, view);

        setHasOptionsMenu(true);
        mListener = (OnFragmentInteractionListener) getActivity();

        if (mListener != null) {
            mListener.setActionBarTitle("Historial de Pedidos");
        }

        ArrayList<Producto> items = new ArrayList<>();
        Producto bean ;
        bean = new Producto();
        bean.setNombre("Jamonada");
        bean.setTienda("Oscar Villar");
        bean.setDetalle("500 g");
        bean.setCosto("S/. 40.00");
        bean.setFecha("18/11/2018");
        bean.setEstado("Pendiente");

        items.add(bean);

        RecyclerView recyclerView = (RecyclerView) view.findViewById (R.id.rv_cli_historial);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HistorialCliAdapter(getContext(), items);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onEmpty() {
        tv_cli_hs_empy.setVisibility(View.VISIBLE);
    }


    public interface OnFragmentInteractionListener {
        void setActionBarTitle(String title);
        void onLoadingShow();
        void onLoadingHide();
    }
}