package com.example.lehuyduc.session12.networking.aserver.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 06/12/2016.
 */

public class RegisterRequestBody {
    @SerializedName("id")
    long id;

    @SerializedName("CustomerName")
    String customerName;

    @SerializedName("Email")
    String email;

    @SerializedName("Password")
    String password;

    @SerializedName("DayOfBirth")
    String dayOfBirth;

    @SerializedName("MonthOfBirth")
    String monthOfBirth;

    @SerializedName("YearOfBirth")
    String yearOfBirth;

    @SerializedName("Phone")
    String phone;

    public RegisterRequestBody(long id, String customerName, String email, String password, String dayOfBirth, String monthOfBirth, String yearOfBirth, String phone) {
        this.id = id;
        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "RegisterRequestBody{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", monthOfBirth='" + monthOfBirth + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
