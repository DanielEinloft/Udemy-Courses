package com.example.thami.videoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity
{

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        // esconde a status bar e navegacao. Nos permite manipular elementos de tela.
        View decorView = getWindow().getDecorView();

        //coloca tela cheia
        int uiOpcoes  =View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOpcoes);


        //esconde action bar
        getSupportActionBar().hide();

        //executar video. Adiciona controles padroes do android
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoPath("android.resource//" + getPackageName() +"/"+ R.raw.video);
        videoView.start();

    }
}
