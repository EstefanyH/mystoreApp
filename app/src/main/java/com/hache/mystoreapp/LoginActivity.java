package com.hache.mystoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.hache.mystoreapp.service.VolleyS;
import com.hache.mystoreapp.ui.cliente.PerfilCliFragment;
import com.hache.mystoreapp.util.Apiconfig;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_login_usuario)
    EditText et_usuario;

    @BindView(R.id.et_login_clave)
    EditText et_clave;

    Intent intent;
    private VolleyS volley;
    protected RequestQueue fRequestQueue;
    private LoadingDialog loadingDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        volley = VolleyS.getInstance(getApplicationContext().getApplicationContext());
        fRequestQueue = volley.getRequestQueue();
        loadingDialog = new LoadingDialog(LoginActivity.this);
    }

    @OnClick(R.id.btn_login_ingresar)
    public void onIngresar(){
        onLoadingShow();
        try{
            if(valida())
            {
                String url = Apiconfig.Login;
                JSONObject json = new JSONObject();
                json.put("perfil", "cliente");
                json.put("numeroDocumento", et_usuario.getText().toString().trim());
                json.put("password", et_clave.getText().toString().trim());

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url,
                        json, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            boolean rs = Boolean.parseBoolean(response.getString("success"));

                            if (rs)
                            {
                                intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                onLoadingHide();
                            } else{
                                Toast.makeText(getApplicationContext(),R.string.msg_error,Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(getApplicationContext(),R.string.msg_error_servidor,Toast.LENGTH_LONG).show();
                    }
                });

                addToQueue(jsonObjectRequest);

            }
        }catch (Exception ex ){
            
        }

    }

    @OnClick(R.id.txt_login_registro)
    public void onRegistro(){
        intent = new Intent(this, MainActivity.class);
        intent.putExtra("rol","new");
        startActivity(intent);
    }

    boolean valida() {

        if(et_usuario.getText().toString().isEmpty()){
            onLoadingHide();
            Toast.makeText(getApplicationContext(), "Ingrese usuario", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(et_clave.getText().toString().isEmpty()){
            onLoadingHide();
            Toast.makeText(getApplicationContext(), "Ingrese clave", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void addToQueue(Request request) {
        if (request != null) {
            request.setTag(this);
            if (fRequestQueue == null)
                fRequestQueue = volley.getRequestQueue();
            request.setRetryPolicy(new DefaultRetryPolicy(
                    60000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            ));
            onPreStartConnection();
            fRequestQueue.add(request);
        }
    }

    public void onPreStartConnection() {
        //getActivity().setProgressBarIndeterminateVisibility(true);
    }

    public void onLoadingShow() {
        loadingDialog.startLoadingDialog();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismissDialog();
            }
        },5000);
    }

    public void onLoadingHide() {
        loadingDialog.dismissDialog();
    }
}
