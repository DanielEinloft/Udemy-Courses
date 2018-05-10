package com.example.thami.midiaplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity
{

    private SeekBar seekBar;

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.bach);
        inicializarSeekBar();
    }


    private void inicializarSeekBar()
    {
        seekBar = findViewById(R.id.seekBar);

        //configurar o audio manager
        //servicos => serviço de audio.
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //recupera valores de volume maximo e atual
        int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC); //pega volume max pra musica
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC); //volume atual.

        //configura valores maximos pra seekbar
        seekBar.setMax(volumeMax);
        seekBar.setProgress(volumeAtual);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i, AudioManager.FLAG_SHOW_UI);
                //flag == 0  nao aparece nada :P nao aparece em cima o volume. 

            }


            //nao utulizado.
            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            //nao utulizado.
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });


    }
    public void executarSom(View view)
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.start();
        }
    }
    public void pausarSom(View view)
    {
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
    }

    public void stopSom(View view)
    {
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            //eh necessario carregar de novo, neste caso, pq o stop tira a musica do mediaplayer.
            mediaPlayer = MediaPlayer.create(this,R.raw.bach);

        }
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if(mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release();//libera recursos de midia :)
            mediaPlayer = null; //nao ocupa memória :)
        }

    }

    //pausa a musica quando sai do app :)
    @Override
    protected void onStop()
    {
        super.onStop();
        //nao pode usar a funcao pq o metodo ta sendo usado pelo botao.
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
    }
}
