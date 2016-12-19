package com.example.lehuyduc.lab6.eventbus_events;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class ToastEvent {
    String content;

    public ToastEvent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
