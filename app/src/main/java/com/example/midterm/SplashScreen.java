package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView counter = (TextView) findViewById(R.id.counter);

        for(int i = 9; i > 0; i--)
        {
            counter.setText("Timer: " + i);
        }
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                finish();


                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            }
        };
        Timer openning = new Timer();
        openning.schedule(timerTask, 9000);





    }
}