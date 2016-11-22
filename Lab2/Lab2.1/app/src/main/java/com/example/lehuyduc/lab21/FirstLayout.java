package com.example.lehuyduc.lab21;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Le Huy Duc on 21/11/2016.
 */

public class FirstLayout extends LinearLayout {

    @BindView(R.id.bt_remove)
    public Button btRemove;

    @BindView(R.id.bt_add)
    public Button btAdd;

    @BindView(R.id.tv_value)
    public TextView tvValue;

    @BindView(R.id.tv_label)
    public TextView tvLabel;



    public FirstLayout(Context context) {
        super(context);
        initFromContext(context,null);
    }

    public FirstLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context,attrs);
    }

    public FirstLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context,attrs);
    }

    void initFromContext(Context context, AttributeSet attrs) {

        View view = inflate(context, R.layout.first_layout, this);

        ButterKnife.bind(this,view);

        if (attrs!=null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ValueTextView);

            int value = typedArray.getInt(R.styleable.ValueTextView_value, -1);
            String label = typedArray.getString(R.styleable.ValueTextView_label);

            typedArray.recycle();

            if (value!=-1) tvValue.setText(String.valueOf(value));
            if (label!=null) tvLabel.setText(label);
        }

        addListeners();
    }


    void addListeners() {
        btRemove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = 0;
                try {
                    value = Integer.parseInt(tvValue.getText().toString());
                } catch (Exception e) {}

                if (value > 0) value--;
                tvValue.setText(String.valueOf(value));
            }
        });

        btAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = 0;
                try {
                    value = Integer.parseInt(tvValue.getText().toString());
                } catch (Exception e) {}

                value++;

                tvValue.setText(String.valueOf(value));
            }
        });
    }
}
