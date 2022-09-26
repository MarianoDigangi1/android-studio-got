package com.got.trabajopractico.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.got.trabajopractico.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static final long tiempo_espera = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              paginacionEntreActivities(LoginActivity.class);
            }
        }, tiempo_espera);
    }

    private void paginacionEntreActivities(Class claseDestino){
        Intent intentGlobal = new Intent(SplashScreenActivity.this, claseDestino);
        startActivity(intentGlobal);
        finish();
    }
}