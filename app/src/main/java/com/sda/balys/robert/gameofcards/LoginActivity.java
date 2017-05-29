package com.sda.balys.robert.gameofcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.sda.balys.robert.gameofcards.presenters.LoginPresenter;
import com.sda.balys.robert.gameofcards.presenters.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.buttonLogin)
    Button buttonLogin;
    @BindView(R.id.editMailLogin)
    EditText emailT;
    @BindView(R.id.editPasswordLogin)
    EditText passwordT;

    FirebaseAuth firebaseAuth;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.buttonLogin)
    public void loginUser() {
        String email = emailT.getText().toString().trim().toLowerCase();
        String password = passwordT.getText().toString().trim();
        loginPresenter.loginUser(this, email, password);
    }
}
