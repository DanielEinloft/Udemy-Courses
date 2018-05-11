package com.example.thami.wifi_t1;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thami on 22/03/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>
{
    //array for all bluetooth devices found
    List<BluetoothData> btList = new ArrayList<>();


    public Adapter(List<BluetoothData> btList )
    {
        this.btList = btList;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        //transforms our activity2 layout (layout for items on the recycler view list) and create a view holder, using our MyViewHolder class
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main2,parent,false);

        return new MyViewHolder(itemList);
    }



    //sets  the data for it's current position and puts on the list
    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position)
    {
        BluetoothData btData = btList.get(position);

        holder.deviceName.setText(btData.getDeviceName());
        holder.deviceCode.setText(Integer.toString(btData.getBluetoothCode()));
    }

    @Override
    public int getItemCount() { return btList.size();  }





    //Defines each field of the recycler view list
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView deviceName;
        TextView deviceCode;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            deviceName = itemView.findViewById(R.id.deviceName);
            deviceCode = itemView.findViewById(R.id.deviceCode);
        }
    }


}
