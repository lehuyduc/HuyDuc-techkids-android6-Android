package com.example.lehuyduc.firstapp;

import android.opengl.EGLDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private EditText etName, etHeight, etWeight;
    private TextView tvHello;
    private Button btSayHello;
    private Button btCalculate;
    private TextView tvResult, tvAdvice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();
        addListeners();
    }

    private void addListeners() {
        btSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"btSayHello: onClick");
           }
        });

        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double height, weight, bmi;
                    height = Integer.parseInt(etHeight.getText().toString());
                    height /= 100;
                    weight = Integer.parseInt(etWeight.getText().toString());
                    bmi = weight / (height * height);
                    bmi = Math.round(bmi*100)/100;
                    tvResult.setText(String.valueOf(bmi));

                    if (bmi<15) tvAdvice.setText("RIP");
                    else if (bmi<18.5) tvAdvice.setText("Eat more");
                    else if (bmi<25) tvAdvice.setText("Normal weight");
                    else if (bmi<30) tvAdvice.setText("Eat less");
                    else tvAdvice.setText("Light bends around you");
                }
                catch (Exception e) {
                }
            }
        });
    }

    private void getReferences() {
        etName = (EditText)findViewById(R.id.et_name);
        tvHello = (TextView)findViewById(R.id.tv_hello);
        btSayHello = (Button)findViewById(R.id.bt_say_hello);
        btCalculate = (Button)findViewById(R.id.bt_calculate);
        etWeight = (EditText)findViewById(R.id.et_weight);
        etHeight = (EditText)findViewById(R.id.et_height);
        tvResult = (TextView)findViewById(R.id.tv_result);
        tvAdvice = (TextView)findViewById(R.id.tv_advice);
    }


}
