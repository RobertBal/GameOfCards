package com.sda.balys.robert.gameofcards;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by RENT on 2017-05-27.
 */

public class Utils {

    public static boolean isEmailValid (String email){
        return email.contains("@");
    }
    public static boolean isPasswordLongCorrect(String password) {
        if (password.length() > 6) {
            return true;
        }
        return false;
    }
//    }
    public static boolean isInternetConnectionCorrect(Context context){

            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService (Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

}
