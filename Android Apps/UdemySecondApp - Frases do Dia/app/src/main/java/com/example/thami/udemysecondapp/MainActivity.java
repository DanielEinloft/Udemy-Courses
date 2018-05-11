package com.example.thami.udemysecondapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createPhrase(View view)
    {
        TextView phrase = (TextView) findViewById(R.id.todaysPhrase);
        String[] phrases = {"Justice came from above!", "It's high noon", "Die Die Die Die", "Embrace tranquility!", "Cheer up boys, the cavalry is here!"};
        int randomIndex = new Random().nextInt(phrases.length);

        phrase.setText(phrases[randomIndex]);

    }




}
