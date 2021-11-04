package com.hache.mystoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

public class LoginActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;


    private EditText et_usuario;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_usuario = (EditText) findViewById(R.id.et_login_usuario);
    }


    public void onIngresar(View v){
        String nomRol = et_usuario.getText().toString();
        /*
        if(nomRol.equals("cliente")){
            intent = new Intent(this, ClienteActivity.class);
        }
        if(nomRol.equals("repartidor")){
            intent = new Intent(this, RepartidorActivity.class);
        }
        if(nomRol.equals("bodega")){
            intent = new Intent(this, BodegaActivity.class);
        }*/

        intent = new Intent(this, MainActivity.class);
        intent.putExtra("rol",nomRol);
        startActivity(intent);
    }

}
