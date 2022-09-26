package com.got.trabajopractico.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.got.trabajopractico.R;
import com.got.trabajopractico.db.UsuarioManager;
import com.got.trabajopractico.helpers.HelperConstants;


public class LoginActivity extends AppCompatActivity {

    EditText etContra, etUsuario;
    Button btnIniciar, btnRegistrar;
    CheckBox etRecordarUsuario;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializarElementos();
        configurarSharedPreferenced();

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paginacionEntreActivitis(SignUpActivity.class);
            }
        });
    }

    private void inicializarElementos() {
        etUsuario = findViewById(R.id.etUsuario);
        etContra = findViewById(R.id.etContra);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        etRecordarUsuario = findViewById(R.id.etRecordarUsuario);
    }

    private void configurarSharedPreferenced(){
        preferences = getApplicationContext().getSharedPreferences(HelperConstants.SP_CREDENCIALES, MODE_PRIVATE);
        String usuarioGuardado = preferences.getString(HelperConstants.USUARIO, null);
        String passwordGuardada = preferences.getString(HelperConstants.PASSWORD, null);

        if (usuarioGuardado != null && passwordGuardada != null) {
            paginacionEntreActivitis(HomeActivity.class);
        }
    }

    private void recordarUsuario(String usuario, String password) {
        if (etRecordarUsuario.isChecked()) {
            SharedPreferences prefs = getApplicationContext().getSharedPreferences(HelperConstants.SP_CREDENCIALES, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(HelperConstants.USUARIO, usuario);
            editor.putString(HelperConstants.PASSWORD, password);
            editor.apply();
        }
        paginacionEntreActivitis(HomeActivity.class);
    }

    private void paginacionEntreActivitis(Class claseDestino) {
        Intent intentGlobal = new Intent(LoginActivity.this, claseDestino);
        startActivity(intentGlobal);
        //finish();
    }

}