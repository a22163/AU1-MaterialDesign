package com.svalero.a1_6_0_1_estilosytemas.movie.list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.a1_6_0_1_estilosytemas.R;
import com.svalero.a1_6_0_1_estilosytemas.beans.Film;

import java.util.ArrayList;

public class ListarPeliculasActivity
        extends AppCompatActivity
        implements ListarMoviesContract.View
{
    private static final int SCREEN=3;
    private ListarMoviesPresenter listarMoviesPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_peliculas);

        // 3º Iniciar Presenter
        listarMoviesPresenter = new ListarMoviesPresenter(this);
        //4º Inicializar componentes XML
        listarMoviesPresenter.getMovies();
    }

    @Override
    public void successListMovies(ArrayList<Film> lstMovies, String msg) {
        /*PINTAR RECYCLER-VIEW*/

        /**/
    }
    @Override
    public void failureListMovies(String err) {
    }
}