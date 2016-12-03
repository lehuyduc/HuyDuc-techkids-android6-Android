package com.example.lehuyduc.dailyquote;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lehuyduc.dailyquote.constants.Constants;
import com.example.lehuyduc.dailyquote.fragments.LoginFragment;
import com.example.lehuyduc.dailyquote.fragments.QuoteFragment;
import com.example.lehuyduc.dailyquote.managers.Preferences;
import com.example.lehuyduc.dailyquote.models.Quote;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @BindView(R.id.fl_quote_fragment)
    FrameLayout flQuoteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        Log.d(TAG, ""+ Preferences.getInstance());
        if (Preferences.getInstance().getUserName()==null)
            changeFragment(new LoginFragment(), false);
        else changeFragment(new QuoteFragment(), false);
    }

    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent) {
        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackStack());
        Log.d(TAG, "onEvent");
    }

    void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fl_quote_fragment, fragment);

        fragmentTransaction.commit();
    }



}
