package com.example.lehuyduc.session12;

import android.app.Application;

import com.example.lehuyduc.session12.networking.databases.RealmContext;

/**
 * Created by Le Huy Duc on 09/12/2016.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmContext.init(this);
    }
}
