package com.example.thami.atmconsultoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

public class activity_sobre extends AppCompatActivity
{

    //nem usa o xml padrao :)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sobre);

        String descricao = "BLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLA";
        View aboutPage = new AboutPage(this)
                .setImage(R.drawable.logo)
                .addGroup("Fale conosco")
                .setDescription(descricao)
                .addGroup("Redes sociais")
                .addEmail("atmconsultoria@gmail.com","Envie um email")
                .addWebsite("http://google.com.br","Acesse nosso site")
                .addFacebook("https://www.facebook.com/daniel.einloft", "perfil facebook")
                .create();

        setContentView(aboutPage);
    }
}
