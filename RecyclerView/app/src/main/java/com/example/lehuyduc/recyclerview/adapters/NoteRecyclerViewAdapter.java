package com.example.lehuyduc.recyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.lehuyduc.recyclerview.R;
import com.example.lehuyduc.recyclerview.models.Note;
import com.example.lehuyduc.recyclerview.view_holders.NoteViewHolder;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class NoteRecyclerViewAdapter extends RecyclerView.Adapter<NoteViewHolder> {


    private static final String TAG = NoteRecyclerViewAdapter.class.toString();

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        Log.d(TAG, "aaa");
        View view;
        if (viewType!=2) view = inflater.inflate(R.layout.recycler_view_note_item, parent, false);
        else view = inflater.inflate(R.layout.recycler_view_long_note_item, parent, false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(view);

        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note note = Note.notes.get(position);
        holder.bind(note);
        if (position%3==2) {
            StaggeredGridLayoutManager.LayoutParams layoutParams =
                    (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
            layoutParams.setFullSpan(true);
        }
    }

    @Override
    public int getItemCount() {
        return Note.notes.size();
    }
}
