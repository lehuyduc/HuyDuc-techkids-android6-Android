package com.example.lehuyduc.networking.jsonmodels;

/**
 * Created by Le Huy Duc on 24/11/2016.
 */

public class Post {
    private String title;
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
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

    @Override
    public String toString() {
        return this.title;
    }
}
