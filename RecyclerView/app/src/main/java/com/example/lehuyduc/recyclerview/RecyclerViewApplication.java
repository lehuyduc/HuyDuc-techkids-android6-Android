package com.example.lehuyduc.recyclerview;

import android.app.Application;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.lehuyduc.recyclerview.models.Note;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class RecyclerViewApplication extends Application {
    private static final String TAG = RecyclerViewApplication.class.toString();

    @Override
    public void onCreate() {
        super.onCreate();
        Note.init();

        Log.d(TAG, "initing");
    }
}
