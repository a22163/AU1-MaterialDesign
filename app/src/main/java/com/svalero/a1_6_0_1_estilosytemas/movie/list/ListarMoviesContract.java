package com.svalero.a1_6_0_1_estilosytemas.movie.list;

import com.svalero.a1_6_0_1_estilosytemas.beans.Film;
import com.svalero.a1_6_0_1_estilosytemas.beans.User;
import com.svalero.a1_6_0_1_estilosytemas.user.login.LoginContract;

import java.util.ArrayList;

public interface ListarMoviesContract {
    public interface View{
        void successListMovies(ArrayList<Film> lstMovies, String msg);
        void failureListMovies(String err);
    }
    public interface Presenter{
        void getMovies();
    }
    public interface Model{
        /*DATOS Y PUNTO DE RETORNO (CALLBACK) --> SUCCESS*/
        void getListMoviesWS(OnListMoviesListener onListMoviesListener);

        /*PROMESA (CALLBACK)*/
        interface OnListMoviesListener{
            void resolve(ArrayList<Film> lstMovies);
            void reject(String err);
        }
    }
}
