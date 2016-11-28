package com.example.lehuyduc.lab3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Le Huy Duc on 27/11/2016.
 */

public class HairStyleHolder {

    HairStyle data;

    @BindView(R.id.tv_title) TextView tvTitle;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.iv_image)
    ImageView ivImage;

    public HairStyleHolder(View view) {
        ButterKnife.bind(this, view);
    }

    public void setData(HairStyle data) {
        this.data = data;
        tvTitle.setText(data.getTitle());
        tvDescription.setText(data.getDescription());
        Ion.with(ivImage).load(data.getImages());
    }
}
