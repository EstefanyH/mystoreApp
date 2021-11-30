package com.hache.mystoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.lottie_login)
    LottieAnimationView lottie;
    @BindView(R.id.et_login_usuario)
    EditText et_usuario;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        lottie.animate().translationX(2000).setDuration(2000).setStartDelay(2500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);*/
            }
        }, 5000);
    }

    @OnClick(R.id.btn_login_ingresar)
    public void onIngresar(){
        String nomRol = et_usuario.getText().toString();
        intent = new Intent(this, MainActivity.class);
        intent.putExtra("rol",nomRol);
        startActivity(intent);
    }

    @OnClick(R.id.txt_login_registro)
    public void onRegistro(){
        intent = new Intent(this, MainActivity.class);
        intent.putExtra("rol","new");
        startActivity(intent);
    }

}
