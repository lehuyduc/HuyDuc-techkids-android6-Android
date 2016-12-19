package com.example.lehuyduc.lab6.networking.services.register_service;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class RegisterRequestBody {
    @SerializedName("username") String userName;

    @SerializedName("password") String password;

    public RegisterRequestBody(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
