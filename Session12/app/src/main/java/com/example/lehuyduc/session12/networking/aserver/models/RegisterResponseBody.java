package com.example.lehuyduc.session12.networking.aserver.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 06/12/2016.
 */

public class RegisterResponseBody {
    @SerializedName("d")
    private User user;

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return user.toString();
    }
}
