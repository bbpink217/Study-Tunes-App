package com.example.studytunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView VideoView;

    @Override
    protected void onResume() {
        super.onResume();
        VideoView.start();
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonlofi = (Button) findViewById(R.id.btnLofi);
        Button buttonclassical = (Button) findViewById(R.id.btnClassic);
        Button buttonjazz = (Button) findViewById(R.id.btnJazz);
        Button buttonnature = (Button) findViewById(R.id.btnNature);
        Button buttonwhite = (Button) findViewById(R.id.btnWhite);



        buttonlofi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LofiHipHop.class));
            }
        });
        buttonclassical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClassicalMusic.class));
            }
        });
        buttonjazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SmoothJazz.class));
            }
        });
        buttonnature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NatureSounds.class));
            }
        });
        buttonwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WhiteNoise.class));
            }
        });


        VideoView = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.nighttimeopening);
        VideoView.setVideoURI(uri);
        VideoView.start();

        VideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);

            }


        });

    }
}
