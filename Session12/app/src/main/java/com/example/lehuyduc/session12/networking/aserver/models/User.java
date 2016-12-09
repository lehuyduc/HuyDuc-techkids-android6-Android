package com.example.lehuyduc.session12.networking.aserver.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 06/12/2016.
 */

public class User {
    @SerializedName("id")
    long id;

    @SerializedName("CustomerName")
    String customerName;

    @SerializedName("Email")
    String email;

    @SerializedName("AccessToken")
    String accessToken;

    @SerializedName("DayOfBirth")
    String dayOfBirth;

    @SerializedName("MonthOfBirth")
    String monthOfBirth;

    @SerializedName("YearOfBirth")
    String yearOfBirth;

    @SerializedName("Phone")
    String phone;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", monthOfBirth='" + monthOfBirth + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
