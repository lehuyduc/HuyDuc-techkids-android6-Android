package com.example.lehuyduc.lab6;

import android.app.Application;
import android.preference.Preference;

import com.example.lehuyduc.lab6.database.Preferences;
import com.example.lehuyduc.lab6.networking.RetrofitContext;

import io.realm.Realm;
import retrofit2.Retrofit;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class LabApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitContext.init(Constants.BASE_URL);
        Realm.init(this);
        Preferences.init(this);
    }
}
