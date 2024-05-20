package com.example.practice11;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.playButton);
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("https://rus.hitmotop.com/get/music/20231025/Jamie_Duffy_-_Solas_76886686.mp3");
            mediaPlayer.prepare(); // Можно использовать prepareAsync() для сетевых потоков
        } catch (IOException e) {
            e.printStackTrace();
        }
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                } else {
                    mediaPlayer.pause();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
