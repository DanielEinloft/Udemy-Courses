package com.example.thami.wifi_t1;


import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.thami.wifi_t1.Adapter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    Button scanButton;
    RecyclerView deviceList;
    List<BluetoothData> btDevices = new ArrayList<>();
    Adapter adapter;


    //GARANTIR QUE NÃO TENHA NENHUMA CONEXÃO NO INICIO PRA NÃO DAR CACA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanButton = findViewById(R.id.scanButton);
        deviceList = findViewById(R.id.deviceList);


        //adapter to manage each item
        adapter = new Adapter(btDevices);


        //setting up the RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        deviceList.setLayoutManager(layoutManager);
        deviceList.setHasFixedSize(true);
        deviceList.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        deviceList.setAdapter(adapter);


        deviceList.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), deviceList, new RecyclerItemClickListener.OnItemClickListener()
                {

                    //estas funcoes estao dentro do metodo OnItemClickListener()
                    @Override
                    public void onItemClick(View view, int position)
                    {
                        Toast.makeText(getApplicationContext(),"Item Pressionado ", Toast.LENGTH_SHORT).show();

                        //inicia a proxima activity e envia os dados do bluetooth

                        Intent intent = new Intent(getApplicationContext(),Terminal.class);
                        BluetoothData btToSend = btDevices.get(position);
                        intent.putExtra("BluetoothData", btToSend);

                        Log.i("dasdsadas",btToSend.getDeviceName() + " " + btToSend.getBluetoothCode());
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position){}

                    //nao vamos usar
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {}
                })

        );


    }




    public void ScanDevices(View view)
    {
        //im scanning for devices! yey!
        BluetoothData novo = new BluetoothData();
        novo.setBluetoothCode(2);
        novo.setDeviceName("testando222");
        btDevices.add(novo);
        adapter.notifyDataSetChanged();

        Log.i("Log", String.valueOf(adapter.getItemCount()));


    }

}
