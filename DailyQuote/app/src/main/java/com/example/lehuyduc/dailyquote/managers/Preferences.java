package com.example.lehuyduc.dailyquote.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Le Huy Duc on 03/12/2016.
 */


public class Preferences {

    public static final String KEY = "Quote";
    public static final String USERNAME_KEY = "Username";

    private SharedPreferences sharedPreferences;

    public Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }

    public String getUserName() {
        return sharedPreferences.getString(USERNAME_KEY, null);
    }

    public void putUserName(String username) {
        sharedPreferences.edit().putString(USERNAME_KEY, username).commit();
    }

    private static Preferences instance;

    public static Preferences getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new Preferences(context);
    }
}
