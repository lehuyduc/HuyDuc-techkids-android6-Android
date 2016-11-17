package com.example.lehuyduc.dictionary;

import android.app.Application;
import android.util.Log;

import com.example.lehuyduc.dictionary.managers.DbHelper;
import com.example.lehuyduc.dictionary.models.Word;

/**
 * Created by Le Huy Duc on 17/11/2016.
 */

public class DictionaryApplication extends Application {
    public static final String TAG = DictionaryApplication.class.toString();

    @Override
    public void onCreate() {
        Log.d(TAG,"onCreate");
        super.onCreate();
        DbHelper.init(this);
        Word.list = DbHelper.getInstance().selectAllWords();
    }
}
