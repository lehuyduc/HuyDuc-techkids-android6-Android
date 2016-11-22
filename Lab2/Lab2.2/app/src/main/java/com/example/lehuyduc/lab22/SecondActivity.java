package com.example.lehuyduc.lab22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.dsb_bar)
    DiscreteSeekBar dsbBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);

        dsbBar.setTrackColor(R.color.colorAccent);
        dsbBar.setRippleColor(R.color.colorPrimaryDark);
        dsbBar.setProgress(5000);
    }
}
