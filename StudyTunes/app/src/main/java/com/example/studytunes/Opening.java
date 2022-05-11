package com.example.studytunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class Opening extends AppCompatActivity {
    private VideoView openingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        openingView = (VideoView) findViewById(R.id.openingView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.studytunes_opening);
        openingView.setVideoURI(uri);
        openingView.start();

        openingView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {


            }


        });
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                finish();
                startActivity(new Intent(Opening.this, MainActivity.class));
            }
        };
        Timer opening = new Timer();
        opening.schedule(task, 6430);
    }
}
