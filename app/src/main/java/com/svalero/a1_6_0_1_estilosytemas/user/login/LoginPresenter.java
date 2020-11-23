package com.svalero.a1_6_0_1_estilosytemas.user.login;

import com.svalero.a1_6_0_1_estilosytemas.beans.User;
import com.svalero.a1_6_0_1_estilosytemas.user.login.LoginContract;
import com.svalero.a1_6_0_1_estilosytemas.user.login.LoginModel;

public class LoginPresenter {
    private LoginContract.View view;
    private LoginModel loginModel;

    public LoginPresenter(
            LoginContract.View view) {
        this.view = view;
        loginModel = new LoginModel();
    }
    public void login(String email, String pass){
        // 1º) Validar usuario y password. [Validaciones.checkEmail()]
        User user = new User();
        user.setEmail(email);
        user.setPassword(pass);
        //2º) API
        // Llamamos al método del modelo, pero siempre debemos hacer un callback.
            // Mandarle siempre, siempre, la interfaz (o camino) de retorno.
        loginModel.loginWS(user,
                new LoginContract.Model.OnLoginListener() {
                    @Override
                    public void resolve(User user) {
                        view.successLogin(user, "Correcto");
                    }

                    @Override
                    public void reject(String err) {
                            view.failureLogin("Error");
                    }
                });
    }

}
