package com.svalero.a1_6_0_1_estilosytemas.user.login.presenter;

import android.os.Handler;
import android.widget.Toast;

import com.svalero.a1_6_0_1_estilosytemas.beans.Film;
import com.svalero.a1_6_0_1_estilosytemas.beans.User;
import com.svalero.a1_6_0_1_estilosytemas.user.login.LoginContract;
import com.svalero.a1_6_0_1_estilosytemas.user.login.view.LoginActivity;

import org.json.JSONException;

import java.util.ArrayList;

public class LoginPresenter {
    private LoginContract.View view;
    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }
    public void login(User user){
        // 1º) Validar usuario y password. [Validaciones.checkEmail()]
        try {
            final Handler manejador = new Handler();
            manejador.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Simulación de que nos vamos a validar el usuario/password a una
                    // API
                    boolean success = true;
                    if(success){
                        User user = new User();
                        view.successLogin(user,"Login Correcto. ");
                    }else{
                        view.failureLogin("Login Incorrecto. ");
                    }
                }
            }, 4000);
            //ArrayList<Film> lstFilms = Film.getArrayListFromJSON();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
