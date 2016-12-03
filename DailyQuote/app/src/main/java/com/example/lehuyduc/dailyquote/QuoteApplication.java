package com.example.lehuyduc.dailyquote;

import android.app.Application;
import android.preference.Preference;
import android.util.Log;

import com.example.lehuyduc.dailyquote.managers.Preferences;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Le Huy Duc on 03/12/2016.
 */

public class QuoteApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Preferences.init(this);
        initImageLoader();

        Log.d("Application", "Init");
    }

    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }

}
