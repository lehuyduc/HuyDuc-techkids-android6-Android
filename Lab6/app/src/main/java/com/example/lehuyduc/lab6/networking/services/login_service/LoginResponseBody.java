package com.example.lehuyduc.lab6.networking.services.login_service;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class LoginResponseBody {
    @SerializedName("token") String token;

    @SerializedName("result") int result;

    @SerializedName("message") String message;

    public LoginResponseBody(String token, int result, String message) {
        this.token = token;
        this.result = result;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginResponseBody{" +
                "message='" + message + '\'' +
                ", result=" + result +
                ", token='" + token + '\'' +
                '}';
    }
}
