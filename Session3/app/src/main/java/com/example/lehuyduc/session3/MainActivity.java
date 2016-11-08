package com.example.lehuyduc.session3;

import android.content.Intent;
import android.opengl.Matrix;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private Button btGoto2nd, btGoto3rd;
    private Button btFinished;
    private Button btTapMe;
    private TextView tvCreate, tvStart, tvRestart, tvResume, tvPause, tvStop, tvDestroy;
    private static int nCreate, nStart, nRestart, nResume, nPause = 0, nStop, nDestroy;

    private int numberOfTaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState!=null) {
            numberOfTaps = savedInstanceState.getInt("numberOfTaps",0);
        }

        getReference();
        addListener();
        initView();

        Log.d(TAG,"onCreate");
        nCreate++;
        tvCreate.setText("onCreate: " + nCreate);
    }

    private void getReference() {
        btGoto2nd = (Button) findViewById(R.id.bt_goto2);
        btGoto3rd = (Button) findViewById(R.id.bt_goto3);
        tvCreate = (TextView) findViewById(R.id.tv_create);
        tvStart = (TextView) findViewById(R.id.tv_start);
        tvRestart = (TextView) findViewById(R.id.tv_restart);
        tvResume = (TextView) findViewById(R.id.tv_resume);
        tvPause = (TextView) findViewById(R.id.tv_pause);
        tvStop = (TextView) findViewById(R.id.tv_stop);
        tvDestroy = (TextView) findViewById(R.id.tv_destroy);
    }

    private void addListener() {
        btGoto2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(intent);
            }
        });

        btGoto3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);

                startActivity(intent);
            }
        });
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
        outState.putInt("numberOfTaps", numberOfTaps);
        Log.d(TAG,"Saving");
        super.onSaveInstanceState(outState);
    }
}
