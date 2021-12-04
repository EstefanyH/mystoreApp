package com.hache.mystoreapp.ui.repartidor;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.hache.mystoreapp.R;
import com.hache.mystoreapp.service.VolleyS;
import com.hache.mystoreapp.util.BaseFragment;
import com.hache.mystoreapp.util.Apiconfig;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PerfilRepFragment extends BaseFragment  {
    private Unbinder unbinder = null;
    private OnFragmentInteractionListener mListener = null;
    private VolleyS volley;


    @BindView(R.id.et_rep_nom)
    EditText etNombre;
    @BindView(R.id.et_rep_telefono)
    EditText etTelefono;
    @BindView(R.id.et_rep_nomUsuario)
    EditText etUsuario;
    @BindView(R.id.et_rep_clave)
    EditText etClave;
    @BindView(R.id.et_rep_reClave)
    EditText etReClave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rep_perfil, container, false);
        unbinder = ButterKnife.bind(this, view);

        setHasOptionsMenu(true);
        mListener = (OnFragmentInteractionListener) getActivity();

        volley = VolleyS.getInstance(getActivity().getApplicationContext());
        fRequestQueue = volley.getRequestQueue();

        if (mListener != null) {
            mListener.setActionBarTitle("Nuevo Repartidor");
        }

        return view;
    }

    public interface OnFragmentInteractionListener {
        void setActionBarTitle(String title);
        void onLoadingShow();
        void onLoadingHide();
    }

    @OnClick(R.id.btn_rep_guardar)
    public void onGuardar() {
        try{
            mListener.onLoadingShow();
            if(valida()) {
                String url = Apiconfig.NuevoRepartidor;
                JSONObject json = new JSONObject();
                json.put("idRepartidor", 0);
                json.put("nombreRepartidor", etNombre.getText().toString().trim());
                json.put("apellidoPRepartidor", "rr");
                json.put("apellidoMRepartidor", "rr");
                json.put("dniRepartidor", Integer.valueOf(etUsuario.getText().toString()));
                json.put("celularRepartidor", Integer.valueOf(etTelefono.getText().toString().trim()));
                json.put("direcRepartidor", "rr");
                json.put("passRepartidor", etClave.getText().toString().trim());

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

    boolean valida(){
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
        if(etReClave.getText().toString().isEmpty()){
            mListener.onLoadingHide();
            Toast.makeText(getActivity(), "Ingrese repetir clave",Toast.LENGTH_LONG).show();
            return false;
        }
        if(!etClave.getText().toString().trim().equals(etReClave.getText().toString())){
            mListener.onLoadingHide();
            Toast.makeText(getActivity(), "La confirmación de clave no coincide",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }



}