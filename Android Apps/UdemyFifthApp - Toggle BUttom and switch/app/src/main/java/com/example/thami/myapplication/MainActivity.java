package com.example.thami.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    private Switch mySwitch;
    private CheckBox myCheck;
    private ToggleButton myTogle;
    private TextView resultadoseekbar;
    private TextView myresult;

    private ProgressBar progressBar;
    private ProgressBar progressBarLoading;
    private SeekBar myseekbar;
    //private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySwitch = findViewById(R.id.switch1);
        myCheck = findViewById(R.id.checkBox);
        myTogle = findViewById(R.id.toggleButton);
        myresult = findViewById(R.id.textView3);
        progressBar = findViewById(R.id.progressbar);
        progressBarLoading=findViewById(R.id.progressbarloading);
        progressBarLoading.setVisibility(View.GONE);

        resultadoseekbar = findViewById(R.id.resultadoseekbar);

        myseekbar = findViewById(R.id.seekBar);
        myseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                resultadoseekbar.setText("Progresso " + seekBar.getProgress() + "/" + seekBar.getMatrix());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) // no primeiroo movimento.
            {
                Toast.makeText(getApplicationContext(), "Alterado!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) //quando solta
            {
                Toast.makeText(getApplicationContext(), "Nao esta pressionado mais!", Toast.LENGTH_SHORT).show();

            }
        });// fica ouvindo modificacoes na seekbar





    }

    //progress bar,aula 88
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void carregarProgresso(View view)
    {
        progressBarLoading.setVisibility(view.VISIBLE);

        //this.progresso = this.progresso +10;
        //if(progresso < 100)
        //  progressBar.setProgress(progresso);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {

                for(int i =0 ;i <=100;i++)
                {
                    System.out.println(i);
                    final int progresso = i;
                    //thread nao atualiza a interface...tem que criar outra thread que faça isso (SERIOUSLY!?)
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            progressBar.setProgress(progresso);
                            if(progresso == 100)
                                progressBarLoading.setVisibility(View.GONE);
                        }
                    });
                    try
                    {
                        Thread.sleep(100);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



        //progressBarLoading.setVisibility(View.GONE);//nao aparece a progressbar loading carregando
    }
    public void enviar(View view)
    {











        /*
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //alert Dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);//this -> contexto da propria classe do main activity. Contexto local.

        dialog.setTitle("Titulo");
        dialog.setMessage("Minha mensagem");

        //configurar cancelamento
        dialog.setCancelable(false);//nao fecha a mensagem :O tem que escolher uma das opçoes

        //configura icone
        dialog.setIcon(android.R.drawable.ic_delete);


        //Java interface: é um contrato entre uma classe e um método. Basicamente funciona pra setar um comportamento diferente de um método de um objeto.
        //Se objeto A e B sao da mesma classe, A.X() pode ter um comportamento e B.X() outro comportamento. A coisa interessante nisso é que usando uma interface numa classe,
        //tu obriga ao objeto instanciado a definir o comportamento de um método definido por esta interface (que é implementada nesta mesma classe)

        //instancia uma dialog interface. INTERFACE É UM CONTRATO QUE DEFINE REGRAS ENTRE CLASSES
        //usando esta interface, é criada uma classe anonima na hjora que estiver executando o codigo, que é instanciada e se fazer override no onClick dessa interface.
        //mais detalhes na aula AlertDialog (87).

        dialog.setPositiveButton("SIM!", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                //this nao funciona pq esta sendo feito dentro de uma classe anonima [utilizaria assim, o contexto da classe anonima]. É necessario usar o contexto da aplicação.
                Toast.makeText(getApplicationContext(), "Alright!:)", Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("NUM!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(getApplicationContext(), "OH NO!:)", Toast.LENGTH_LONG).show();

            }
        });

        dialog.create();
        dialog.show();





        */
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //codigo para toast (mensagem que aparece e desliga na tela. Aula 86:)

        /*
        //Toast.makeText(getApplicationContext(), "Resultado Pressionado! :)", Toast.LENGTH_SHORT).show(); //pro getaplication,pode usar this, pq usa o contexto da aplicacao
        //ou...

        ImageView image = new ImageView((getApplicationContext()));
        image.setImageResource(android.R.drawable.star_big_off);// imagem padrao do android

        Toast mytoast = new Toast(getApplicationContext());
        mytoast.setDuration(Toast.LENGTH_LONG);
        mytoast.setView(image);
        mytoast.show();
        */



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (myTogle.isChecked())
            myresult.setText("Toggle On");
        else
            myresult.setText("Toggle Off");

        /*
        if (mySwitch.isChecked())
            myresult.setText("Switch On");
        else
            myresult.setText("Switch Off");

        if (myCheck.isChecked())
            myresult.setText("myCheck On");
        else
            myresult.setText("myCheck Off");
         */

    }

}

