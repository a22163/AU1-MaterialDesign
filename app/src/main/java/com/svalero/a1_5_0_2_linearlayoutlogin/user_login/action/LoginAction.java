package com.svalero.a1_5_0_2_linearlayoutlogin.user_login.action;

import com.svalero.a1_5_0_2_linearlayoutlogin.entities.User;
import com.svalero.a1_5_0_2_linearlayoutlogin.user_login.view.LoginActivity;

public class LoginAction {
    private LoginActivity vista;

    public LoginAction(LoginActivity vista) {
        this.vista = vista;
        // 0x251617 posición de memoria de la vista
    }
    public void login(User user){
        // Validar que el usuario y
        // la password son correctos
    }
}
