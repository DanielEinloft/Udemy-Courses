package com.example.thami.udemyappinterface;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private TextInputEditText myProductName;
    private TextView myResult;
    private CheckBox myWhiteBox,myGreenBox,myRedBox;
    List<String> checkList = new ArrayList<String>(); //pior forma de fazer isso... -.-
    private RadioGroup myRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myProductName = findViewById(R.id.editTextProductName);
        myResult = findViewById(R.id.testViewResult);
        myWhiteBox = findViewById(R.id.whiteBox);
        myGreenBox = findViewById(R.id.greenBox);
        myRedBox = findViewById(R.id.redBox);
        myRadioGroup = findViewById(R.id.radioButtons);
        checkRadioButton();
    }



    public void checkTheBox(View view)
    {
        checkList.clear();
        if(myGreenBox.isChecked())
            checkList.add(myGreenBox.getText().toString());
        if(myWhiteBox.isChecked())
            checkList.add(myWhiteBox.getText().toString());
        if(myRedBox.isChecked())
            checkList.add(myRedBox.getText().toString());

        myResult.setText((checkList.toString()));

    }


    public void checkRadioButton()
    {
        //ADICIONA um EVENTO que verifica se um dos itens foi selecionado. É chamado toda vez que a lista for modificada. Verifica de forma automatica:)
        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            //verifica qual botao foi selecionado. int i é o id do objeto selecionado.
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                if(i ==R.id.rbEstoque)
                    myResult.setText("Sim");
                else
                    myResult.setText("Não");
            }
        });
    }
    public void clickSend(View view)
    {
        checkTheBox(view);
        //String productName = myProductName.getText().toString();
        //myResult.setText(productName);
    }

}
