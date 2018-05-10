package com.example.thami.slider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;


/*
este projeto necessita modificações do gradle para funcionar. Segue o github com instruções: https://github.com/heinrichreimer/material-intro
* */
public class MainActivity extends IntroActivity //colocar intro aqui!
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        //retira os botoes  de next e back da interface
        setButtonBackVisible(false);
        setButtonNextVisible(false);

        //fazendo o layout usando fragment
        addSlide(new FragmentSlide.Builder()
                        .background(android.R.color.holo_orange_light)
                        .fragment(R.layout.intro_1)
                        .build()
        );


        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_orange_light)
                .fragment(R.layout.intro_2)
                .build()
        );

        /*
        ////fazendo o layout na mão.




        addSlide(new SimpleSlide.Builder()
                    .title("Titulo")
                    .description("Descrição")
//                .image(R.drawable.um) //nao tem imagem no site, esperar...
                    .background(android.R.color.holo_orange_light)
                    .build()
        );

        addSlide(new SimpleSlide.Builder()
                .title("Titulo 2")
                .description("Descrição 2")
//                .image(R.drawable.dois) //nao tem imagem no site, esperar...
                .background(android.R.color.holo_orange_light)
                .build()

        );
    */
    }
}
