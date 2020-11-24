package com.svalero.a1_6_0_1_estilosytemas.user.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.svalero.a1_6_0_1_estilosytemas.R;
import com.svalero.a1_6_0_1_estilosytemas.beans.User;
import com.svalero.a1_6_0_1_estilosytemas.movie.list.ListarPeliculasActivity;

public class LoginActivity extends AppCompatActivity
            implements LoginContract.View {
                //https://www.youtube.com/watch?v=bBJF1M5h_UU
                    //https://www.youtube.com/watch?v=bBJF1M5h_UU
    /*
    * LoginActivity = 8 Bytes;
    * AppCompatActivity = 20 Bytes;
    * LoginContract.View = 2 Bytes;
    * */

    private int RC_SIGN_IN = 1;
    private Button btnLogin;
    private EditText edtEmail;
    private EditText edtPassword; //getElementById()

    /*ANCLA CON LA SIGUIENTE CAPA*/
    private LoginPresenter loginPresenter;
    private static final String TAG = "CustomAuthActivity";

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    //private ActivityCustomBinding mBinding;
    private String mCustomToken;

    private GoogleSignInClient mGoogleSignInClient;
    private static final int SCREEN=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
// ...
// Initialize Firebase Auth
        //mAuth = FirebaseAuth.getInstance();
        //3ª: Inicializar elemento que necesite de XML
        initComponents();

        // 4º: Inicializar MVP (Presenter)
        initPresenter();

        /*GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //signIn();
                loginPresenter.login(
                            edtEmail.getText().toString(),
                        edtPassword.getText().toString());
            }
        });

        /*btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGoogleSignInClient.signOut();
                Toast.makeText(MainActivity.this,"You are Logged Out",Toast.LENGTH_SHORT).show();
                btnSignOut.setVisibility(View.INVISIBLE);
            }
        });*/
    }

    @Override
    public void successLogin(User user, String msg) {
        Toast.makeText(
                getBaseContext(),
                msg,
                Toast.LENGTH_LONG).
                show();
        Intent pantalla = new Intent(getBaseContext(),
                ListarPeliculasActivity.class);
        startActivity(pantalla);
    }
    @Override
    public void failureLogin(String err){
        Toast.makeText(
                getBaseContext(),
                err,
                Toast.LENGTH_LONG).
                show();
    }


    private void signIn(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask){
        try{
            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
            Toast.makeText(LoginActivity.this,"Signed In Successfully",Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc);
        }
        catch (ApiException e){
            Toast.makeText(LoginActivity.this,"Sign In Failed",Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }
    }
    private void FirebaseGoogleAuth(GoogleSignInAccount acct) {
        //check if the account is null
        if (acct != null) {
            AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
            mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                        FirebaseUser user = mAuth.getCurrentUser();
                        //updateUI(user);
                    } else {
                        Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        //updateUI(null);
                    }
                }
            });
        }
        else{
            Toast.makeText(LoginActivity.this, "acc failed", Toast.LENGTH_SHORT).show();
        }
    }
    private void initComponents(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
    private void initPresenter(){
        loginPresenter = new LoginPresenter((LoginContract.View)this);
    }
}