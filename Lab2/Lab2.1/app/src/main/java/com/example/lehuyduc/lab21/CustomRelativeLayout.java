package com.example.lehuyduc.lab21;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Le Huy Duc on 21/11/2016.
 */

public class CustomRelativeLayout extends RelativeLayout {
    public CustomRelativeLayout(Context context) {
        super(context);
        initFromContext(context,null);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context,attrs);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context,attrs);
    }

    void initFromContext(Context context,AttributeSet attrs) {
        View view = inflate(context, R.layout.custom_relative_layout, this);
    }

}
