package com.svalero.a1_6_0_1_estilosytemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtEmail;
    private EditText edtPassword; //getElementById()

    private static final int SCREEN=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        //3ª: Inicializar elemento que necesite de XML
        initComponents();

        // capturar el onclick
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Write whatever to want to do after delay specified (1 sec)
                        Intent pantalla = new Intent(getBaseContext(),
                                ListarPeliculasActivity.class);
                        startActivity(pantalla);
                        // Threads--> Clase
                        // Runnable-->Interfaz
                    }
                }, 4000);
                /*Intent pantalla = new Intent(getBaseContext(),
                        ListarPeliculasActivity.class);
                startActivity(pantalla);*/

            }
        });
    }
    private void initComponents(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
}