package com.hache.mystoreapp.ui.cliente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.hache.mystoreapp.R;
import com.hache.mystoreapp.util.BaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ProductoCliFragment extends BaseFragment {

    private Unbinder unbinder = null;
    private OnFragmentInteractionListener mListener = null;

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

        return view;
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