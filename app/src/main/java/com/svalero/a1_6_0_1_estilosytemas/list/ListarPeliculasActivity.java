package com.svalero.a1_6_0_1_estilosytemas.list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.a1_6_0_1_estilosytemas.R;

public class ListarPeliculasActivity extends AppCompatActivity {
    private static final int SCREEN=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_peliculas);
    }
}