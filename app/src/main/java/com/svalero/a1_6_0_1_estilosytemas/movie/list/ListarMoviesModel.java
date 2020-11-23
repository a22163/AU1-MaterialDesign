package com.svalero.a1_6_0_1_estilosytemas.movie.list;

import android.os.AsyncTask;
import android.util.Log;

import com.svalero.a1_6_0_1_estilosytemas.beans.Film;
import com.svalero.a1_6_0_1_estilosytemas.beans.User;
import com.svalero.a1_6_0_1_estilosytemas.user.login.LoginModel;
import com.svalero.a1_6_0_1_estilosytemas.utils.Post;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ListarMoviesModel
    implements ListarMoviesContract.Model
{
    private ArrayList<Film> lstFilms;
    private OnListMoviesListener onListMoviesListener;
    private static final String
            URL_API =
            "https://pokeapi.co/api/v2/pokemon/";
    // https://swapi.dev/api/people/
    //https://api.themoviedb.org/3/movie/popular?api_key=d9c4177bb1cc819d43088d25fbe2474c&language=en-US&page=1
    //
    @Override
    public void getListMoviesWS(
            OnListMoviesListener onListMoviesListener) {
        this.onListMoviesListener = onListMoviesListener;

        ListarMoviesAsyncTask listarMoviesAsyncTask = new ListarMoviesAsyncTask(URL_API);
        listarMoviesAsyncTask.execute();
    }

    class ListarMoviesAsyncTask extends AsyncTask<String, Integer, Boolean> {
        /*1º) DÓNDE TENGO QUE IR*/
        private String url="";
        /*2º) PARÁMETROS*/
        private HashMap<String, String> data;
        private User user;

        /*POST, PUT, DELETE, etc. */
        public ListarMoviesAsyncTask(String url,
                              HashMap<String, String> data) {
            this.url = url;
            this.data = data;
        }
        /*GET*/
        public ListarMoviesAsyncTask(String url) {
            this.url = url;
        }
        /*SEMÁFORO = VERDE*/
        /*SUCCESS*/
        @Override
        protected void onPostExecute(Boolean resp) {
            super.onPostExecute(resp);
            /*Podemos hablar con la vista*/
            if(resp){
                onListMoviesListener.
                        resolve(lstFilms);
            }else{
                onListMoviesListener.
                        reject("Error en listar Películas");
            }

        }
        /*SEMÁFORO = AMARILLO*/
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        /*SEMÁFORO = ROJO*/
        @Override
        protected Boolean doInBackground(String... params) {
            try {
                Post post = new Post();
                /*Estaba preparada para comunicarnos con Arrays de JSON*/
                /*Necesito prepararla para recibir Objects*/
                // $.ajax();
                // Post
                JSONObject result = post.getServerDataGetObject(url);

                JSONArray lstFilmsJSON =  result.getJSONArray("results");

                lstFilms = Film.getArrayListFromJSON(lstFilmsJSON);

            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
            }
            return true;
        }
    }
}
