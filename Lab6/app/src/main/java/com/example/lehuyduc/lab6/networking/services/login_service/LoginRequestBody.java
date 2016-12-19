package com.example.lehuyduc.lab6.networking.services.login_service;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class LoginRequestBody {
    @SerializedName("username") String username;

    @SerializedName("password") String password;

    public LoginRequestBody(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
