package com.svalero.a1_6_0_1_estilosytemas.movie.list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.a1_6_0_1_estilosytemas.R;
import com.svalero.a1_6_0_1_estilosytemas.beans.Film;
import com.svalero.a1_6_0_1_estilosytemas.pintores.PintarListaMovies;

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

        //
        recicler = findViewById(R.id.recyclerFilms);

        // 3º Iniciar Presenter
        listarMoviesPresenter = new ListarMoviesPresenter(this);
        //4º Inicializar componentes XML
        listarMoviesPresenter.getMovies();
    }
    private RecyclerView recicler;
    @Override
    public void successListMovies(ArrayList<Film> lstMovies, String msg) {
        /*PINTAR RECYCLER-VIEW*/
        recicler.setHasFixedSize(true);

        RecyclerView.LayoutManager estilo = new LinearLayoutManager(this);
        recicler.setLayoutManager(estilo);

        PintarListaMovies adapterFilms = new PintarListaMovies(lstMovies);
        recicler.setAdapter(adapterFilms);

        /**/
    }
    @Override
    public void failureListMovies(String err) {
    }
}