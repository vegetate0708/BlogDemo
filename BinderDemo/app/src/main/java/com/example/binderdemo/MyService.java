package com.example.binderdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    private IBinder iBinder=null;
    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        iBinder=new com.example.binderdemo.IBinder(getApplicationContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return   iBinder;
    }
}
