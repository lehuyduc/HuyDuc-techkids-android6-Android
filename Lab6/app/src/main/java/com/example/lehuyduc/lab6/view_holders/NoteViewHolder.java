package com.example.lehuyduc.lab6.view_holders;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lehuyduc.lab6.R;
import com.example.lehuyduc.lab6.models.Note;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = NoteViewHolder.class.toString();
    Note data;

    @BindView(R.id.rv_item_layout)
    LinearLayout rvItemLayout;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_content)
    TextView tvContent;

    public NoteViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Note note) {
        data = note;
        tvTitle.setText(note.getTitle());
        tvContent.setText(note.getContent());
        Log.d(TAG, note.getColorInt() + "");
        rvItemLayout.setBackgroundColor(Color.parseColor(note.getColorHex()));
    }


}
