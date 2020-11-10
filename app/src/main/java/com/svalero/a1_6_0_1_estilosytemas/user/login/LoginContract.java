package com.svalero.a1_6_0_1_estilosytemas.user.login;

import com.svalero.a1_6_0_1_estilosytemas.beans.User;

public interface LoginContract {
    public interface View{
        void successLogin(User user, String msg);
        void failureLogin(String err);
    }
    public interface Presenter{
        void login(String email, String password);
    }
    public interface Model{
        /*DATOS Y PUNTO DE RETORNO (CALLBACK) --> SUCCESS*/
        void loginWS(User user, OnLoginListener onLoginListener);

        /*PROMESA (CALLBACK)*/
        interface OnLoginListener{
                void resolve(User usuario);
                void reject(String err);
        }
    }
}
