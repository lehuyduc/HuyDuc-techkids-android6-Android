package com.example.lehuyduc.lab3;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 28/11/2016.
 */

public class Customer {
    @SerializedName("Phone") String phone;

    @SerializedName("CustomerName") String customerName;

    @SerializedName("Email") String email;

    @SerializedName("Password") String password;

    @SerializedName("DayOfBirth") String dayOfBirth;

    @SerializedName("MonthOfBirth") String monthOfBirth;

    @SerializedName("YearOfBirth") String yearOfBirth;

    public Customer() {
        phone = "0918296356";
        customerName = "Le Huy Duc";
        email = "lehuyduc3@gmail.com";
        password = "123aosdjo2";
        dayOfBirth = "10";
        monthOfBirth = "8";
        yearOfBirth = "1998";
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
