package com.sda.balys.robert.gameofcards.presenters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sda.balys.robert.gameofcards.MainActivity;
import com.sda.balys.robert.gameofcards.RegisterActivity;
import com.sda.balys.robert.gameofcards.Utils;

/**
 * Created by RENT on 2017-05-27.
 */

public class RegisterPresenter {

    FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;




    public RegisterPresenter(){}

    public void registerUser(final Activity activity, String email, String password){
        firebaseAuth= FirebaseAuth.getInstance();


        if(TextUtils.isEmpty(email)){
            Utils.showToast(activity,"Enter the mail");
            return;
        } else if(!Utils.isEmailVavlid(email)){
            Utils.showToast(activity,"Enter the valid mail");
            return;
        }

        if(TextUtils.isEmpty(password)){
            Utils.showToast(activity,"Enter the  password ");
            return;
        }
        if(!Utils.isPasswordValid(password)){
            Utils.showToast(activity,"Enter the valid password");
            return;
        }

        if(!Utils.checkInternetConnection(activity)){
            Utils.showToast(activity,"You have not internet connection");
            return;
        }

        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Registretion...");
        progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(activity,"Account created",Toast.LENGTH_SHORT).show();
                    activity.finish();
                    activity.startActivity(new Intent(activity, MainActivity.class));
                }else{
                    progressDialog.dismiss();
                    Toast.makeText(activity,"something went wrong",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    public void loginUser(final Activity activity, String email, String password) {

        firebaseAuth= FirebaseAuth.getInstance();


        if(TextUtils.isEmpty(email)){
            Utils.showToast(activity,"Enter the mail");
            return;
        } else if(!Utils.isEmailVavlid(email)){
            Utils.showToast(activity,"Enter the valid mail");
            return;
        }

        if(TextUtils.isEmpty(password)){
            Utils.showToast(activity,"Enter the  password ");
            return;
        }
        if(!Utils.isPasswordValid(password)){
            Utils.showToast(activity,"Enter the valid password");
            return;
        }

        if(!Utils.checkInternetConnection(activity)){
            Utils.showToast(activity,"You have not internet connection");
            return;
        }

        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Login...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(activity,"Account created",Toast.LENGTH_SHORT).show();

                }else{
                    progressDialog.dismiss();
                    Toast.makeText(activity,"something went wrong",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
