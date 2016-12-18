package com.example.lehuyduc.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.example.lehuyduc.recyclerview.adapters.NoteRecyclerViewAdapter;
import com.example.lehuyduc.recyclerview.models.Note;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    List<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        rvList.setHasFixedSize(true);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,1);
        rvList.setLayoutManager(staggeredGridLayoutManager);

        noteList = Note.notes;
        Log.d(TAG, noteList.size() + "");
        NoteRecyclerViewAdapter myAdapter = new NoteRecyclerViewAdapter();
        rvList.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

}
