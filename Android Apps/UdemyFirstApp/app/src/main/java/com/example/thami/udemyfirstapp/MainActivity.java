package com.example.thami.udemyfirstapp;

import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButtom(View view)
    {
        TextView text = (TextView) findViewById(R.id.randomNumerAnswer);
        int randomNumber = new Random().nextInt(11);
        text.setText("Kawabanga - "+ randomNumber);
    }


}
