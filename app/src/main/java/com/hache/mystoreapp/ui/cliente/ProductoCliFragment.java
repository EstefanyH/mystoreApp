package com.hache.mystoreapp.ui.cliente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hache.mystoreapp.R;
import com.hache.mystoreapp.adapter.ProductoCliAdapter;
import com.hache.mystoreapp.bean.Producto;
import com.hache.mystoreapp.util.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ProductoCliFragment extends BaseFragment implements
        ProductoCliAdapter.ItemClickListener {

    private Unbinder unbinder = null;
    private OnFragmentInteractionListener mListener = null;
    ProductoCliAdapter adapter;

    @BindView(R.id.tv_cli_empty)
    TextView tv_empy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cli_producto, container, false);
        unbinder = ButterKnife.bind(this, view);

        setHasOptionsMenu(true);

        mListener = (OnFragmentInteractionListener) getActivity();

        if (mListener != null) {
            mListener.setActionBarTitle("Busqueda...");
        }

        ArrayList<Producto> items = new ArrayList<>();
        Producto bean ;
        bean = new Producto();
        bean.setNombre("Jamonada");
        bean.setTienda("Oscar Villar");
        bean.setDetalle("500 g");
        bean.setCosto("S/. 40.00");

        items.add(bean);

        RecyclerView recyclerView = (RecyclerView) view.findViewById (R.id.rv_cli_producto);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ProductoCliAdapter(getContext(), items);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onEmpty() {
        tv_empy.setVisibility(View.VISIBLE);
    }

    /*
    public void onDetalle(View v){
        Fragment nuevoFragmento = new DetalleCliFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, nuevoFragmento);
        transaction.addToBackStack(null);
        transaction.commit();
    }*/

    public interface OnFragmentInteractionListener {
        void setActionBarTitle(String title);
        void onLoadingShow();
        void onLoadingHide();
    }
}