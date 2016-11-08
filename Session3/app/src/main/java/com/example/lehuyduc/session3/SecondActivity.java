package com.example.lehuyduc.session3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.toString();

    private TextView tvCreate, tvStart, tvRestart, tvResume, tvPause, tvStop, tvDestroy;
    private static int nCreate, nStart, nRestart, nResume, nPause, nStop, nDestroy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        if (savedInstanceState!=null) {

        }

        getReference();
        addListener();
        initView();

        Log.d(TAG,"onCreate");
        nCreate++;
        tvCreate.setText("onCreate: " + nCreate);
    }

    private void getReference() {
        tvCreate = (TextView) findViewById(R.id.tv_create2);
        tvStart = (TextView) findViewById(R.id.tv_start2);
        tvRestart = (TextView) findViewById(R.id.tv_restart2);
        tvResume = (TextView) findViewById(R.id.tv_resume2);
        tvPause = (TextView) findViewById(R.id.tv_pause2);
        tvStop = (TextView) findViewById(R.id.tv_stop2);
        tvDestroy = (TextView) findViewById(R.id.tv_destroy2);
    }

    private void addListener() {

    }

    private void initView() {
        tvCreate.setText("onCreate: " + nCreate);
        tvStart.setText("onStart: " + nStart);
        tvRestart.setText("onRestart: " + nRestart);
        tvResume.setText("onResume: " + nResume);
        tvPause.setText("onPause: " + nPause);
        tvStop.setText("onStop: " + nStop);
        tvDestroy.setText("onDestroy: " + nDestroy);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
        nStart++;
        tvStart.setText("onStart" + nStart);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
        nRestart++;
        tvRestart.setText("onRestart: " + nRestart);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
        nResume++;
        tvResume.setText("onResume: " + nResume);
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"onPause");
        nPause++;
        tvPause.setText("onPause: " + nPause);
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"onStop");
        nStop++;
        tvStop.setText("onStop: " + nStop);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy");
        nDestroy++;
        tvDestroy.setText("onDestroy: " + nDestroy);
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        Log.d(TAG,"Saving");
        super.onSaveInstanceState(outState);
    }

}
