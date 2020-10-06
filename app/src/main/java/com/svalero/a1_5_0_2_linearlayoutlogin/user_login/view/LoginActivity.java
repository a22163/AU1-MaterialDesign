package com.svalero.a1_5_0_2_linearlayoutlogin.user_login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.svalero.a1_5_0_2_linearlayoutlogin.R;
import com.svalero.a1_5_0_2_linearlayoutlogin.entities.User;
import com.svalero.a1_5_0_2_linearlayoutlogin.user_login.action.LoginAction;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtEmail;
    private EditText edtPassword;

    /*
    * PATRÓN SINGLETON
    * */
    private static LoginActivity padre=null;//0X154879F
    public static LoginActivity getInstance(){
        return padre;//0X154879F
    }
    /*FIN SINGLETON*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        //getInstance()
        padre = this; // //0X154879F
        final LoginAction action = new LoginAction(this);
        // edtEmail.getText().toString();
        // edtPassword.getText().toString();
        // mÃ©todos flecha
        // MainActivity = 0X154879F
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(
                        edtEmail.getText().toString(),
                        edtPassword.getText().toString()
                );
                action.login(user);
            }
        });
    }
    private void initComponents(){
        //1º
        btnLogin = findViewById(R.id.btnLogin);
        //2º
        edtEmail = findViewById(R.id.edtEmail);
        //3º
        edtPassword =findViewById(R.id.edtPassword);
    }
    public EditText getEdtEmail() {
        return edtEmail;
    }
    public EditText getEdtPassword() {
        return edtPassword;
    }

}