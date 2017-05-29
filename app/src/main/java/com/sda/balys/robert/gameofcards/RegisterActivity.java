package com.sda.balys.robert.gameofcards;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sda.balys.robert.gameofcards.presenters.LoginPresenter;
import com.sda.balys.robert.gameofcards.presenters.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by RENT on 2017-05-27.
 */

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.registerInfoText)
    TextView infoText;
    @BindView(R.id.editTextMail)
    EditText textEmail;
    @BindView(R.id.editTextPassword)
    EditText textPassword;
    @BindView(R.id.buttonRegister)
    Button buttonRgister;

    FirebaseAuth firebaseAuth;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        if (registerPresenter == null) {
            registerPresenter = new RegisterPresenter();
        }
    }

    @OnClick(R.id.buttonRegister)
    public void createUser() {
        String email = textEmail.getText().toString().trim().toLowerCase();
        String password = textPassword.getText().toString().trim();
        registerPresenter.registerUser(this, email, password);
    }

    @OnClick(R.id.textViewSignin)
    public void loginUser() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();


    }


}
