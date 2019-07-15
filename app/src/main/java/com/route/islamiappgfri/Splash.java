package com.route.islamiappgfri;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startSurasActivity();
            }
        },2000);
    }

    private void startSurasActivity() {
        Intent intent=new Intent(Splash.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }


}
