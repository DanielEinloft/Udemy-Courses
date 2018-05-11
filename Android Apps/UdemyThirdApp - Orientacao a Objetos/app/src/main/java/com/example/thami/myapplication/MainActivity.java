package com.example.thami.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



        public void optionSelected(String userChoice)
        {
            String[] possibleResults = {"rock", "paper", "scissor"};
            int index = new Random().nextInt(3);
            TextView result = (TextView) findViewById(R.id.result);

            String appChoice = possibleResults[index];

            ImageView appResult = (ImageView) findViewById(R.id.appResult);

            switch (index) {
                case 0:
                    appResult.setImageResource(R.drawable.pedra);
                    break;
                case 1:
                    appResult.setImageResource(R.drawable.papel);
                    break;
                case 2:
                    appResult.setImageResource(R.drawable.tesoura);
                    break;
            }


            if ((appChoice == "rock" && userChoice == "scissor") || (appChoice == "paper" && userChoice == "rock") || (appChoice == "scissor" && userChoice == "paper"))
            {
                result.setText("You Lose!");
            }
            else if ((userChoice == "rock" && appChoice == "scissor") || (userChoice == "paper" && appChoice == "rock") || (userChoice == "scissor" && appChoice == "paper"))
            {
                result.setText("You Win!");
            }
            else if((userChoice == "paper" && appChoice == "papel") || (userChoice == "rock" && appChoice == "rock") || (userChoice == "scissor" && appChoice == "scissor"))
            {
                result.setText("Draw!");

            }
        }



    public void rockSelected(View view)
    {
        this.optionSelected("rock");
    }
    public void paperSelected(View view)
    {
        this.optionSelected("paper");
    }
    public void scissorSelected(View view)
    {
        this.optionSelected("scissor");
    }


}
