package com.got.trabajopractico.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.got.trabajopractico.R;
import com.got.trabajopractico.db.UsuarioManager;
import com.got.trabajopractico.model.Usuario;

import java.sql.SQLException;

public class SignUpActivity extends AppCompatActivity {

    TextView textViewRegistro, textViewNombre, textViewEmail, textViewPassword;
    EditText editTextNombre, editTextEmail, editTextPassoword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        inicializarElementos();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario();

                usuario.setId((int)(Math.random()*900000+1));
                usuario.setUsername(editTextNombre.getText().toString());
                usuario.setEmail(editTextEmail.getText().toString());
                usuario.setPassword(editTextEmail.getText().toString());

                if(verificaciones(usuario)){
                    try{
                        UsuarioManager.getInstanciaUsuarioManager(SignUpActivity.this).saveUsuario(usuario);
                        Toast.makeText(SignUpActivity.this,"SE GUARDO EN LA BD", Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(SignUpActivity.this,"ERROR", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(SignUpActivity.this,"ERROR EN UNO DE LOS CAMPOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void inicializarElementos(){
        textViewRegistro = findViewById(R.id.tvRegistro);
        textViewNombre = findViewById(R.id.tvNombre);
        textViewEmail = findViewById(R.id.tvEmail);
        textViewPassword = findViewById(R.id.tvPassword);
        editTextNombre = findViewById(R.id.etNombre);
        editTextEmail = findViewById(R.id.etEmail);
        editTextPassoword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnRegistrarSingUp);
    }
    private boolean verificaciones(Usuario usuario){
        boolean flag = true;
        if(usuario.getEmail().matches("[@]+.+com$")){
            flag = false;
        }
        return flag;
    }
}

