package com.svalero.a1_6_0_1_estilosytemas.user.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.svalero.a1_6_0_1_estilosytemas.beans.Film;
import com.svalero.a1_6_0_1_estilosytemas.R;
import com.svalero.a1_6_0_1_estilosytemas.user.login.presenter.LoginPresenter;

import org.json.JSONException;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtEmail;
    private EditText edtPassword; //getElementById()

    private LoginPresenter loginPresenter;

    private static final int SCREEN=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        //3ª: Inicializar elemento que necesite de XML
        initComponents();

        // 4º: Inicializar MVP (Presenter)
        initPresenter();

        // capturar el onclick
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //loginPresenter.login();
                try {
                    ArrayList<Film> lstFilms = Film.getArrayListFromJSON();
                    Toast.makeText(getBaseContext(),
                            lstFilms.get(0).getTitulo(), Toast.LENGTH_LONG).
                            show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
    private void initPresenter(){
        loginPresenter = new LoginPresenter();
    }
}