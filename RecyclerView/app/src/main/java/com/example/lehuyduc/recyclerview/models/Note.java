package com.example.lehuyduc.recyclerview.models;

import android.util.Log;

import com.example.lehuyduc.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le Huy Duc on 17/12/2016.
 */

public class Note {
    private static final String TAG = Note.class.toString();
    String title;
    String content;
    int color;

    public Note(String title, String content, int color) {
        this.content = content;
        this.title = title;
        this.color = color;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public static final ArrayList<Note> notes = new ArrayList<>();

    public static void init() {
        for (int i=1;i<=6;i++)
            notes.add(new Note("Title " + i, "Content " + i, 0));
        notes.get(0).setContent("A note is a note but it is it can't come from a note because it becomes a different note. So a note must exist both inside a form as a note and outside as a form not a note. So a note can not exist");
        notes.get(0).setColor(R.color.colorOrange);
        notes.get(1).setColor(R.color.colorYellow);
        notes.get(2).setColor(R.color.colorBlue);
        notes.get(3).setColor(R.color.colorAccent);
        notes.get(4).setColor(R.color.colorGreen);
        notes.get(5).setColor(R.color.colorLightBlue);
        Log.d(TAG, "initing");
    }

}
