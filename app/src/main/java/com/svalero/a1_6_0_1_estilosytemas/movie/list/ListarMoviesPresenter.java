package com.svalero.a1_6_0_1_estilosytemas.movie.list;

import com.svalero.a1_6_0_1_estilosytemas.beans.Film;

import java.util.ArrayList;

public class ListarMoviesPresenter
implements ListarMoviesContract.Presenter{
    private ListarMoviesContract.View vista;
    private ListarMoviesModel listarMoviesModel;

    public ListarMoviesPresenter(ListarMoviesContract.View vista) {
        this.vista = vista;
        listarMoviesModel = new ListarMoviesModel();
    }

    @Override
    public void getMovies() {
        listarMoviesModel.getListMoviesWS(
                new ListarMoviesContract.Model.OnListMoviesListener() {
                    @Override
                    public void resolve(ArrayList<Film> lstMovies) {
                        vista.successListMovies(lstMovies, "Lista correcta");
                    }

                    @Override
                    public void reject(String err) {
                        vista.failureListMovies("Error en la lista Películas.");
                    }
                }
        );
    }
}
