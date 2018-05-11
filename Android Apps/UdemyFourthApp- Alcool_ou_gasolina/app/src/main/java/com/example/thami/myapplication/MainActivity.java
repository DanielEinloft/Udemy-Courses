package com.example.thami.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    private EditText precoAlcool;
    private EditText precoGasolina;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.editPrecoAlcool);
        precoGasolina = findViewById(R.id.editPrecoGasolina);
        result = findViewById(R.id.resultado);
    }

    public boolean validateString(String myString)
    {
        if(myString == null || myString.equals(""))
            return false;
        return true;
    }


    public void calcularPreco(View view)
    {
        String gasol = precoGasolina.getText().toString();
        String alcool = precoAlcool.getText().toString();

        if(validateString(gasol)&& validateString(alcool))
            calcularMelhorPreco(alcool,gasol);
        else
            result.setText("Preencha os preços primeiro.");

    }
    public void calcularMelhorPreco(String alcool,String gasolina)
    {
        double alcoolInt = Double.parseDouble(alcool);
        double gasolinaInt = Double.parseDouble(gasolina);

        if(alcoolInt/gasolinaInt >= 0.7)
            result.setText("Gasolina");
        else
            result.setText("Alcool");


    }


}
