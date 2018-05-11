package com.example.thami.wifi_t1;

import java.io.Serializable;
import java.util.List;

public class BluetoothData implements Serializable
        {
    String deviceName;
    int bluetoothCode; //change this after knowing what type of data is returned by BT functions



    BluetoothData()
    {
        this.deviceName = "";
        this.bluetoothCode = 0;

    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getBluetoothCode() {
        return bluetoothCode;
    }

    public void setBluetoothCode(int bluetoothCode) {
        this.bluetoothCode = bluetoothCode;
    }
}
