package com.example.studytunes;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.VideoView;

public class ClassicalMusic extends AppCompatActivity {

    private VideoView moonView;
    ImageView playpause;
    ImageView reset;
    int play;
    MediaPlayer mpClassical;
    private Chronometer chronometer;
    long timeWhenStopped = 0;

    @Override

    protected void onResume() {
        super.onResume();
        moonView.start();

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classical_music);
        mpClassical = new MediaPlayer();
        mpClassical = MediaPlayer.create(this, R.raw.classical);
        playpause = findViewById(R.id.btnPlay);
        reset = findViewById(R.id.btnReset);
        play = 1;


        moonView = (android.widget.VideoView) findViewById(R.id.moonView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.orangewires);
        moonView.setVideoURI(uri);
        moonView.start();

        moonView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);

            }


        });


        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play == 1) {
                    chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                    chronometer.start();
                    mpClassical.start();
                    mpClassical.setLooping(true);
                    playpause.setImageResource(R.drawable.ic_pause_white_24dp);
                    play = 0;
                } else {
                    timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
                    chronometer.stop();
                    mpClassical.pause();
                    playpause.setImageResource(R.drawable.ic_play_arrow_white_24dp);
                    play = 1;
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                timeWhenStopped = 0;
            }
        });


        chronometer = findViewById(R.id.chronometer);

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                chronometer = chronometerChanged;
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mpClassical.isPlaying()) {
            mpClassical.stop(); // or mp.pause();
            mpClassical.release();
        }
    }
}
