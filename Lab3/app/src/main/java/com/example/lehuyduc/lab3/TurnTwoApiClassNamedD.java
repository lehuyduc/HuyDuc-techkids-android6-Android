package com.example.lehuyduc.lab3;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Le Huy Duc on 27/11/2016.
 */

public class TurnTwoApiClassNamedD {

    @SerializedName("d") Salon[] salons;

    @Override
    public String toString() {
        String res = "";
        for (Salon salon : salons) res = res + salon.toString() + "\n";
        return res;
    }
}
