package com.svalero.a1_6_0_1_estilosytemas.user.login;

import com.svalero.a1_6_0_1_estilosytemas.beans.User;

public interface LoginContract {
    public interface View{
        void successLogin(User user, String msg);
        void failureLogin(String err);
    }
    public interface Presenter{
        void loginAPI(User user);
    }
    public interface Model{

    }
}
