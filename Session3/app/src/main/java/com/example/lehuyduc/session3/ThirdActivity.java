package com.example.lehuyduc.session3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.RunnableFuture;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";

    private EditText etMinuteCounter, etSecondCounter;
    private Button btStartTimer, btStopTimer;
    private static int minute, second;
    private static boolean running = false;
    static Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getReferences();
        addListener();
        updateView();



        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (minute==0 && second==0) return;
                Log.d(TAG,"" + running);
                if (!running) return;
                second--;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateView();
                    }
                });
                if (second==-1 && minute!=0) {second = 59; minute--;}
            }
        };

        timer = new Timer();
        timer.schedule(task,0,1000);
    }

    void getReferences() {
        etMinuteCounter = (EditText) findViewById(R.id.et_minute_counter);
        etSecondCounter = (EditText) findViewById(R.id.et_second_counter);
        btStartTimer = (Button) findViewById(R.id.bt_start_timer);
        btStopTimer = (Button) findViewById(R.id.bt_stop_timer);
    }

    void addListener() {
        btStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    minute = Integer.parseInt(etMinuteCounter.getText().toString());
                    second = Integer.parseInt(etSecondCounter.getText().toString());
                    running = true;
                }
                catch (Exception e) {

                }
            }
        });

        btStopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = false;
            }
        });
    }

    void updateView() {
        etMinuteCounter.setText(""+ minute);
        etSecondCounter.setText(""+ second);
    }
}
