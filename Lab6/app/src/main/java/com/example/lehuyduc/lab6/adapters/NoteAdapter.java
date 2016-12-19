package com.example.lehuyduc.lab6.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lehuyduc.lab6.R;
import com.example.lehuyduc.lab6.models.Note;
import com.example.lehuyduc.lab6.view_holders.NoteViewHolder;

import java.util.List;


/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private static final String TAG = NoteAdapter.class.toString();

    List<Note> noteList;
    Context context;

    public NoteAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public void addNote(Note note) {
        noteList.add(note);
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.recycler_view_item, parent, false);

        NoteViewHolder noteViewHolder = new NoteViewHolder(view);

        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.bind(noteList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, noteList.size() + "");
        return noteList.size();
    }
}
