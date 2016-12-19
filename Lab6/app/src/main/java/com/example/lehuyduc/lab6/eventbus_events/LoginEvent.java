package com.example.lehuyduc.lab6.eventbus_events;

import com.example.lehuyduc.lab6.models.User;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class LoginEvent {
    User user;
    String token;

    public LoginEvent(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
