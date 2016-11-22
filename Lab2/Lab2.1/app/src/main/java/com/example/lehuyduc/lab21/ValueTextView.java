package com.example.lehuyduc.lab21;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Le Huy Duc on 21/11/2016.
 */

public class ValueTextView extends TextView {

    public ValueTextView(Context context) {
        super(context);
        initFromContext(context,null);
    }

    public ValueTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context,attrs);
    }

    public ValueTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context,attrs);
    }

    void initFromContext(Context context, AttributeSet attrs) {
        if (attrs!=null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ValueTextView);

            int value = typedArray.getInt(R.styleable.ValueTextView_value, -1);
            String label = typedArray.getString(R.styleable.ValueTextView_label);

            typedArray.recycle();

            if (value!=-1) this.setText(String.valueOf(value));
            if (label!=null) this.setText(label);
        }
    }
}
