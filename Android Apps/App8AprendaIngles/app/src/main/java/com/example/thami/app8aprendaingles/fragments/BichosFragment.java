package com.example.thami.app8aprendaingles.fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.thami.app8aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener
{

    //importante onclicklistener permite tratar todos os eventos de click num unico método.

    private ImageButton caoButton;
    private ImageButton gatoButton;
    private ImageButton ovelhaButton;
    private ImageButton vacaButton;
    private ImageButton macacoButton;
    private ImageButton leaoButton;

    private MediaPlayer mediaPlayer;

    public BichosFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bichos, container, false);
        caoButton = view.findViewById(R.id.caoButton);
        gatoButton = view.findViewById(R.id.gatoButton);
        ovelhaButton = view.findViewById(R.id.ovelhaButton);
        vacaButton = view.findViewById(R.id.vacaButton);
        macacoButton = view.findViewById(R.id.macacoButton);
        leaoButton = view.findViewById(R.id.leaoButton);

        //this -> esse metodo vai ser implementado dentro da propria classe. aplica a funcao global do click
        // para todas os botoes :) dai nao precisa fazer varias vezes
        caoButton.setOnClickListener(this);
        gatoButton.setOnClickListener(this);
        ovelhaButton.setOnClickListener(this);
        vacaButton.setOnClickListener(this);
        macacoButton.setOnClickListener(this);
        leaoButton.setOnClickListener(this);

        return view;
    }


    //on click listener é global :)D
    @Override
    public void onClick(View view)
    {
        //Log.i("Elemento clicado", "Item"+view.getId());
        switch(view.getId())
        {
            case R.id.caoButton:
                //this nao funciona aqui, pq nao é o contexto do fragmento, e sim da activity. Vai tocar na activity
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.dog);
                tocarSom();
                break;
            case R.id.gatoButton:
                //this nao funciona aqui, pq nao é o contexto do fragmento, e sim da activity. Vai tocar na activity
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cat);
                tocarSom();
                break;
            case R.id.ovelhaButton:
                //this nao funciona aqui, pq nao é o contexto do fragmento, e sim da activity. Vai tocar na activity
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.sheep);
                tocarSom();
                break;
            case R.id.vacaButton:
                //this nao funciona aqui, pq nao é o contexto do fragmento, e sim da activity. Vai tocar na activity
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cow);
                tocarSom();
                break;
            case R.id.macacoButton:
                //this nao funciona aqui, pq nao é o contexto do fragmento, e sim da activity. Vai tocar na activity
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.monkey);
                tocarSom();
                break;
            case R.id.leaoButton:
                //this nao funciona aqui, pq nao é o contexto do fragmento, e sim da activity. Vai tocar na activity
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lion);
                tocarSom();
                break;
        }
    }

    public void tocarSom()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.start();

            //quando terminar a execucao =)
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer)
                {
                 mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if(mediaPlayer !=null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}
