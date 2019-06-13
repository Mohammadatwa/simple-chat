package com.example.coder_kun.simplechat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run (){
                Intent mainintent = new Intent(Splash.this, LoginActivity.class);
                startActivity(mainintent);
                finish();
            }

        },SPLASH_TIME_OUT);

    }
}
