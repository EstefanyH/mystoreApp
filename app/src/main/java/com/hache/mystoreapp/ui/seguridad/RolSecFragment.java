package com.hache.mystoreapp.ui.seguridad;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.hache.mystoreapp.MainActivity;
import com.hache.mystoreapp.R;
import com.hache.mystoreapp.ui.bodega.PerfilBodFragment;
import com.hache.mystoreapp.ui.cliente.DetalleCliFragment;
import com.hache.mystoreapp.ui.cliente.PerfilCliFragment;
import com.hache.mystoreapp.ui.repartidor.PerfilRepFragment;
import com.hache.mystoreapp.util.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RolSecFragment extends BaseFragment {

    private Unbinder unbinder = null;
    private OnFragmentInteractionListener mListener = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sec_rol, container, false);
        unbinder = ButterKnife.bind(this, view);

        setHasOptionsMenu(true);
        mListener = (OnFragmentInteractionListener) getActivity();

        if (mListener != null) {
            mListener.setActionBarTitle("ELEGIR PERFIL");
        }

        return view;
    }


    public interface OnFragmentInteractionListener {
        void setActionBarTitle(String title);
        void onLoadingShow();
        void onLoadingHide();
    }

    @OnClick(R.id.lyt_repartidor)
    public void NuevoRepartidor() {
        Fragment nuevoFragmento = new PerfilRepFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, nuevoFragmento);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.lyt_bodega)
    public void NuevoBodega() {
        Fragment nuevoFragmento = new PerfilBodFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, nuevoFragmento);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.lyt_cliente)
    public void NuevoCliente() {
        Fragment nuevoFragmento = new PerfilCliFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, nuevoFragmento);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}