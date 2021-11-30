package com.hache.mystoreapp.ui.cliente;

import android.os.Bundle;
import android.util.Log;
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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.hache.mystoreapp.R;
import com.hache.mystoreapp.databinding.FragmentCliPerfilBinding;
import com.hache.mystoreapp.service.VolleyS;
import com.hache.mystoreapp.ui.repartidor.PerfilRepFragment;
import com.hache.mystoreapp.util.BaseFragment;
import com.hache.mystoreapp.util.Config;

import org.json.JSONException;
import org.json.JSONObject;

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
        try{
            mListener.onLoadingShow();
            if(valida()) {
                String url = Config.NuevoCliente;

                JSONObject json = new JSONObject();
                json.put("idCliente", 0);
                json.put("nombreCLiente", etNombre.getText().toString().trim());
                json.put("apellidoPCliente", " ");
                json.put("apellidoMCliente", " ");
                json.put("direcCliente", etDireccion.getText().toString().trim());
                json.put("dniCliente", Integer.valueOf(etUsuario.getText().toString()));
                json.put("distrito", " ");
                json.put("provincia", " ");
                json.put("departamento", " ");
                json.put("passCliente", etClave.getText().toString().trim());

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url,
                        json, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            boolean rs = Boolean.parseBoolean(response.getString("success"));

                            if (rs)
                            {
                                Toast.makeText(getActivity(),R.string.msg_exito,Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(getActivity(),R.string.msg_error,Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(getActivity(),R.string.msg_error_servidor,Toast.LENGTH_LONG).show();
                    }
                });

                addToQueue(jsonObjectRequest);
            }
        }
        catch (Exception ex){
            Log.d("ERROR :",ex.getMessage());
        }
    }


    boolean valida() {
        if(etNombre.getText().toString().isEmpty()){
            mListener.onLoadingHide();
            Toast.makeText(getActivity(), "Ingrese nombre",Toast.LENGTH_LONG).show();
            return false;
        }
        if(etTelefono.getText().toString().isEmpty()){
            mListener.onLoadingHide();
            Toast.makeText(getActivity(), "Ingrese telefono",Toast.LENGTH_LONG).show();
            return false;
        }
        if(etDireccion.getText().toString().isEmpty()){
            mListener.onLoadingHide();
            Toast.makeText(getActivity(), "Ingrese dirección",Toast.LENGTH_LONG).show();
            return false;
        }
        if(etUsuario.getText().toString().isEmpty()){
            mListener.onLoadingHide();
            Toast.makeText(getActivity(), "Ingrese usuario",Toast.LENGTH_LONG).show();
            return false;
        }
        if(etClave.getText().toString().isEmpty()){
            mListener.onLoadingHide();
            Toast.makeText(getActivity(), "Ingrese clave",Toast.LENGTH_LONG).show();
            return false;
        }
        if(etReclave.getText().toString().isEmpty()){
            mListener.onLoadingHide();
            Toast.makeText(getActivity(), "Ingrese confirmación de clave",Toast.LENGTH_LONG).show();
            return false;
        }
        if(!etClave.getText().toString().trim().equals(etReclave.getText().toString())){
            mListener.onLoadingHide();
            Toast.makeText(getActivity(), "La confirmación de clave no coincide",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}