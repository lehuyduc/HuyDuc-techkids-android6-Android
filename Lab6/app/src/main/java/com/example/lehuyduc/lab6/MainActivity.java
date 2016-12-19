package com.example.lehuyduc.lab6;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lehuyduc.lab6.database.Preferences;
import com.example.lehuyduc.lab6.eventbus_events.LoginEvent;
import com.example.lehuyduc.lab6.fragments.LoginFragment;
import com.example.lehuyduc.lab6.eventbus_events.ToastEvent;
import com.example.lehuyduc.lab6.fragments.NoteListFragment;
import com.example.lehuyduc.lab6.networking.RetrofitContext;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        changeFragment(R.id.fl_layout, new LoginFragment(), true);
        //Preferences.getInstance().putToken(null);
        String token = Preferences.getInstance().getToken();
        if (token!=null) {
            Log.d(TAG, "found token: " + token);
            Preferences.getInstance().putToken(token);
            changeFragment(R.id.fl_layout, new NoteListFragment(), true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    void changeFragment(int resId, Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(resId, fragment);
        if (addToBackStack) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Subscribe
    public void onEvent(LoginEvent event) {
        if (event.getUser()==null || event.getToken()==null) return;
        Preferences.getInstance().putToken(event.getToken());
        changeFragment(R.id.fl_layout, new NoteListFragment(),true);
    }
}
