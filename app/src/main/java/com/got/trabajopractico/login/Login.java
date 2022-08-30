package com.got.trabajopractico.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.got.trabajopractico.R;

public class Login extends AppCompatActivity {

    EditText etContra, etUsuario;
    Button btnIniciar, btnRegistrar;
    CheckBox etRecordarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //R es una clase que se genera al momento de la compilación. Contiene los ids
        etUsuario = findViewById(R.id.etUsuario);
        etContra = findViewById(R.id.etContra);

        btnIniciar =  findViewById(R.id.btnIniciar);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        etRecordarUsuario = findViewById(R.id.etRecordarUsuario);

        getBtnInicio(btnIniciar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_sign_up = new Intent(Login.this,SignUpActivity.class);
                startActivity(intent_sign_up);
            }
        });

    }

    private static void getBtnInicio(Button btnIniciar) {
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TODO", "Se apreto el boton iniciar sesion");
            }
        });
    }

}


/*
    setOnClickListener
    Se llama a este método cuando el usuario toca el elemento (en el modo táctil) o se centra en el
    elemento con las teclas de navegación o la bola de seguimiento y presiona la tecla "Intro" adecuada o la bola de seguimiento.
*/