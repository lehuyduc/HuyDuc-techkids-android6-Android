package com.example.lehuyduc.lab6.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.lehuyduc.lab6.models.User;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class Preferences {

    public static final String KEY = "KEY_preferences";
    public static final String KEY_TOKEN = "KEY_TOKEN";

    private SharedPreferences sharedPreferences;

    private Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }

    public void clear() {

    }

    public String getToken() {
        return sharedPreferences.getString(KEY_TOKEN, null);
    }

    public void putToken(String token) {
        sharedPreferences.edit().putString(KEY_TOKEN, token).commit();
    }

    private static Preferences instance;

    public static void init(Context context) {
        instance = new Preferences(context);
    }

    public static Preferences getInstance() {
        return instance;
    }
}
