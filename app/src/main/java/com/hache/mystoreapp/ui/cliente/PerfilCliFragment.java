package com.hache.mystoreapp.ui.cliente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hache.mystoreapp.R;
import com.hache.mystoreapp.databinding.FragmentCliPerfilBinding;
import com.hache.mystoreapp.service.VolleyS;
import com.hache.mystoreapp.ui.repartidor.PerfilRepFragment;
import com.hache.mystoreapp.util.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class PerfilCliFragment extends BaseFragment {

    private Unbinder unbinder = null;
    private PerfilRepFragment.OnFragmentInteractionListener mListener = null;
    private VolleyS volley;

    @BindView(R.id.et_cli_nom)
    EditText etNombre;

    @BindView(R.id.et_cli_telefono)
    EditText etTelefono;

    @BindView(R.id.et_cli_direccion)
    EditText etDireccion;

    @BindView(R.id.et_cli_nomUsuario)
    EditText etUsuario;

    @BindView(R.id.et_cli_clave)
    EditText etClave;

    @BindView(R.id.et_cli_reClave)
    EditText etReclave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cli_perfil, container, false);
        unbinder = ButterKnife.bind(this, view);

        setHasOptionsMenu(true);
        mListener = (PerfilRepFragment.OnFragmentInteractionListener) getActivity();

        volley = VolleyS.getInstance(getActivity().getApplicationContext());
        fRequestQueue = volley.getRequestQueue();

        if (mListener != null) {
            mListener.setActionBarTitle("Nuevo Cliente");
        }

        return view;
    }

    public interface OnFragmentInteractionListener {
        void setActionBarTitle(String title);
        void onLoadingShow();
        void onLoadingHide();
    }
    @OnClick(R.id.btn_cli_guardar)
    public void onGuardar(){
        mListener.onLoadingShow();
        if(valida()){

        }
    }


    boolean valida() {
        if(etNombre.getText().toString().isEmpty()){
            mListener.onLoadingHide();
            Toast.makeText(getActivity(), "Ingrese nombre",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}