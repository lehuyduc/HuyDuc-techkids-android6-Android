package com.example.lehuyduc.lab6.networking.services.register_service;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class RegisterResponseBody {
    @SerializedName("result") String result;

    @SerializedName("message") String message;

    public RegisterResponseBody(String result, String message) {
        this.result = result;
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
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
        return "RegisterResponseBody{" +
                "message='" + message + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
