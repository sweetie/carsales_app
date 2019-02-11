package com.carsales.project.mvp.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import com.carsales.project.R;

public class SplashScreenActivity extends AppCompatActivity {

    private long splashDelay = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent;
               /* mainIntent = new Intent().setClass(SplashScreenActivity.this, HomeActivity.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainIntent);
                finish();*/

            }
        };

        Timer timer = new Timer();
        timer.schedule(task, splashDelay);
    }
}
