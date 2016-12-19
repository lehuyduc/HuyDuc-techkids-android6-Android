package com.example.lehuyduc.lab6.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class Note {
    @SerializedName("title") String title;

    @SerializedName("content") String content;

    @SerializedName("color") String colorHex;

    int colorInt;

    public Note(String title, String content, String colorHex) {
        this.title = title;
        this.content = content;
        this.colorHex = colorHex;
        colorInt = Integer.parseInt(colorHex, 16);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public int getColorInt() {
        colorInt = Integer.parseInt(colorHex.substring(1,7), 16);
        return colorInt;
    }

    public void setColorInt(int colorInt) {
        this.colorInt = colorInt;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", colorHex='" + colorHex + '\'' +
                '}';
    }

    public static ArrayList<Note> notes = new ArrayList<>();
}
