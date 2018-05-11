package com.example.thami.wifi_t1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Terminal extends AppCompatActivity {

    TextView logText;
    Button disconnectButton;
    BluetoothData btData;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminal);

        disconnectButton = findViewById(R.id.disconnectButton);
        logText = findViewById(R.id.logText);




        Bundle dados = getIntent().getExtras();
        if(dados != null)
            btData =  (BluetoothData) dados.getSerializable("BluetoothData");

    }




    public void Disconnect(View view)
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        //intent.putExtra("BluetoothData", (Serializable) btDevices.get(position));
        startActivity(intent);


        //disconnect!
    }

}
