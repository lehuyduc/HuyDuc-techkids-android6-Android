package com.example.lehuyduc.recyclerview.view_holders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lehuyduc.recyclerview.R;
import com.example.lehuyduc.recyclerview.models.Note;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private static final String TAG = NoteViewHolder.class.toString();
    Note data;

    @BindView(R.id.note_item)
    LinearLayout llNoteItem;

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
        llNoteItem.setBackgroundResource(note.getColor());
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG,data.getTitle());
    }
}
