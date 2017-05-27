package com.sda.balys.robert.gameofcards;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by RENT on 2017-05-27.
 */

public class FlashActivity extends AppCompatActivity {
    private int splashRime = 3000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        runMainScreen();
        runTotal();
    }

    private void runTotal() {

    }

    private void runMainScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToMenuScreen();
            }
        },3000);
    }

    private void navigateToMenuScreen() {
        Intent intent = new Intent(this,RegisterActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }


}
