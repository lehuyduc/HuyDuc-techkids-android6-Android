package com.example.lehuyduc.dailyquote.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 02/12/2016.
 */

public class Quote {
    @SerializedName("ID") int id;

    private String title, content, link;

    public Quote(int id, String title, String content, String link) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
