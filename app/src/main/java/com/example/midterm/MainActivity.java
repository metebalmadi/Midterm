package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mediaPlayer1, mediaPlayer2;
    int playing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = (ImageView) findViewById(R.id.Cat);


        mediaPlayer1 = new MediaPlayer();

        mediaPlayer1 = MediaPlayer.create(this, R.raw.track1);


        playing = 0;

        Button bttnToMain = (Button) findViewById(R.id.button2);

        bttnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        Button bttnToGrid = (Button) findViewById(R.id.buttonToGrid);

        bttnToGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GridActivity.class));
            }
        });

        Button bttnToList = (Button) findViewById(R.id.buttonToList);

        bttnToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch(playing) {
                    case 0:
                        mediaPlayer1.start();
                        playing = 1;
                        break;
                    case 1:
                        mediaPlayer1.pause();
                        playing = 0;
                        break;
                }
            }
        });
    }
}