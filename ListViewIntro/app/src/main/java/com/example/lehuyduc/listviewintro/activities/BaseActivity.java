package com.example.lehuyduc.listviewintro.activities;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.lehuyduc.listviewintro.R;

/**
 * Created by Le Huy Duc on 08/11/2016.
 */

public class BaseActivity extends AppCompatActivity  {

    public void changeFragment(int resId,Fragment fragment,boolean addToBackStack) {
        //3: get fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //4: Start replacing
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //5:
        fragmentTransaction.replace(resId, fragment);

        //6 (optional):
        if (addToBackStack) fragmentTransaction.addToBackStack(null);

        //7:
        fragmentTransaction.commit();
    }
}
