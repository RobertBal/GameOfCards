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
import com.sda.balys.robert.gameofcards.R;
import com.sda.balys.robert.gameofcards.Utils;

/**
 * Created by RENT on 2017-05-27.
 */

public class LoginPresenter {

    FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    public LoginPresenter() {
    }

    public void loginUser(final Activity activity, String email, String password) {
        firebaseAuth = FirebaseAuth.getInstance();


        if (TextUtils.isEmpty(email)) {
            Utils.showToast(activity, activity.getString(R.string.Enter_the_mail));
            return;
        } else if (!Utils.isEmailVavlid(email)) {
            Utils.showToast(activity, activity.getString(R.string.Enter_the_valid_mail));
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Utils.showToast(activity, activity.getString(R.string.Enter_the_password));
            return;

        }
        if (!Utils.isPasswordValid(password)) {
            Utils.showToast(activity, activity.getString(R.string.Enter_the_valid_password));
            return;
        }

        if (!Utils.checkInternetConnection(activity)) {
            Utils.showToast(activity, activity.getString(R.string.You_have_not_internet_connetction));
            return;
        }

        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(activity.getString(R.string.Login));
        progressDialog.show();


        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    Toast.makeText(activity, R.string.Welcom, Toast.LENGTH_SHORT).show();
                    activity.finish();
                    activity.startActivity(new Intent(activity, MainActivity.class));

                } else {
                    progressDialog.dismiss();
                    Toast.makeText(activity, R.string.something_went_wrong, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
