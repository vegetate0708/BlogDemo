package com.example.binderdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private android.os.IBinder ib=null;
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ib= service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService(new Intent(this,MyService.class),connection,BIND_AUTO_CREATE);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parcel pc=Parcel.obtain();
                Parcel pc_get=Parcel.obtain();
                pc.writeString("activity");
                try {
                    ib.transact(1,pc,pc_get,0);
                    tv.setText(pc_get.readString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
