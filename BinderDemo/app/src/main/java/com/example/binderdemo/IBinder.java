package com.example.binderdemo;

import android.content.Context;
import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by lx on 2018/1/24.
 */

public class IBinder extends Binder {
    private Context context;
    public IBinder(Context context) {
        this.context=context;
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
       String s=data.readString();
        Log.i("IBinder",s);
        reply.writeString("我是IBinder");
        return true;
    }
}
