package com.example.lehuyduc.lab6.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lehuyduc.lab6.R;
import com.example.lehuyduc.lab6.adapters.NoteAdapter;
import com.example.lehuyduc.lab6.database.Preferences;
import com.example.lehuyduc.lab6.eventbus_events.LoginEvent;
import com.example.lehuyduc.lab6.models.Note;
import com.example.lehuyduc.lab6.networking.RetrofitContext;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {

    private static final String TAG = NoteListFragment.class.toString();
    @BindView(R.id.rv_note_list)
    RecyclerView rvNoteList;

    NoteAdapter noteAdapter;
    StaggeredGridLayoutManager staggeredGridLayoutManager;

    public NoteListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);

        ButterKnife.bind(this, view);

        String token = Preferences.getInstance().getToken();
        RetrofitContext.getData(token);

        rvNoteList.setHasFixedSize(true);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,1);
        rvNoteList.setLayoutManager(staggeredGridLayoutManager);

        noteAdapter = new NoteAdapter(Note.notes);
        rvNoteList.setAdapter(noteAdapter);
        noteAdapter.notifyDataSetChanged();

        return view;
    }

    @Subscribe
    public void onEvent(LoginEvent event) {
        noteAdapter.setNoteList(Note.notes);
        noteAdapter.notifyDataSetChanged();
        Log.d(TAG, "data received: size =  " + noteAdapter.getNoteList().size());
    }
}
