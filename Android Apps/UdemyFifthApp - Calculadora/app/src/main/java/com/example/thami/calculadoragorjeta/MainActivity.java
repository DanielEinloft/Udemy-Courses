package com.example.thami.calculadoragorjeta;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView editvalor;
    private TextView total;
    private TextView gorjeta;
    private TextView porcentagem;
    private SeekBar seekBar;

    private double valor = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editvalor = findViewById(R.id.editvalor);
        total = findViewById(R.id.total);
        gorjeta = findViewById(R.id.gorjeta);
        porcentagem = findViewById(R.id.porcentagem);
        seekBar = findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                valor = seekBar.getProgress();
                porcentagem.setText(valor + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

    }

    public void calcular()
    {
        String xx = editvalor.getText().toString();
        double valorDigitado = Double.parseDouble(xx);
        double gorj =  valorDigitado*valor/100;
        double valortotal =  gorj + valorDigitado;
        gorjeta.setText("R$ " + gorj);
        total.setText("R$ " + valortotal);


    }

}
