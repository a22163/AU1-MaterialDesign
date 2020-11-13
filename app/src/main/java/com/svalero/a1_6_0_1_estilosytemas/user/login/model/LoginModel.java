package com.svalero.a1_6_0_1_estilosytemas.user.login.model;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.svalero.a1_6_0_1_estilosytemas.R;
import com.svalero.a1_6_0_1_estilosytemas.beans.User;
import com.svalero.a1_6_0_1_estilosytemas.user.login.LoginContract;
import com.svalero.a1_6_0_1_estilosytemas.utils.Post;

import org.json.JSONArray;

import java.util.HashMap;


public class LoginModel implements LoginContract.Model {
    ///Controller?ACTION=USUARIO.LOGIN&EMAIL=samuel@gmail.com&PASS=1234
    //http://localhost:42644/2_Netflix_JavascriptParametros/
            // Controller?
            // ACTION=USUARIO.LOGIN
            // &EMAIL=samuel@gmail.com
            // &PASS=1234
    private OnLoginListener onLoginListener;
    private static final String
            URL_API =
            "http://172.20.7.36:42644/2_Netflix_JavascriptParametros/Controller";
    @Override
    public void loginWS(User user,
                        final OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
        //onLoginListener.resolve("Correcto");
        //onLoginListener.reject("Incorrecto");
        /*AJAX--> AsyncTask*/
        /*
        * Rojo => doInBackground(); "URL + DATOS"
        * Amarillo => avance de la ejecución en 2º plano = Integer
        * Verde => onPostExecute() = resolve(true) y reject(false)
        * */
        HashMap<String, String> data = new HashMap();
            data.put("ACTION", "USUARIO.LOGIN"); //Controller
            data.put("EMAIL", "samuel@gmail.com"); // UserAction
            data.put("PASS", "1234"); // UserAction
        LoginAsyncTask loginAsyncTask =
                new LoginAsyncTask(URL_API, data);
        loginAsyncTask.execute();


    }
    class LoginAsyncTask extends AsyncTask<String, Integer, Boolean>{
        /*1º) DÓNDE TENGO QUE IR*/
        private String url="";
        /*2º) PARÁMETROS*/
        private HashMap<String, String> data;
        private User user;

        /*POST, PUT, DELETE, etc. */
        public LoginAsyncTask(String url,
                              HashMap<String, String> data) {
            this.url = url;
            this.data = data;
        }
        /*GET*/
        public LoginAsyncTask(String url) {
            this.url = url;
        }
        /*SEMÁFORO = VERDE*/
        @Override
        protected void onPostExecute(Boolean resp) {
            super.onPostExecute(resp);
            /*Podemos hablar con la vista*/
            if(resp){
                onLoginListener.
                        resolve(user);
            }else{
                onLoginListener.
                        reject("Error");
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
                // $.ajax();
                // Post
                JSONArray result = post.
                        getServerDataPost(data,url);
                //lstFilms = Film.getArrayListFromJSon(result);
                user = User.toArrayFromJSON(result).get(0);
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
            }
            return true;
        }
    }
}
