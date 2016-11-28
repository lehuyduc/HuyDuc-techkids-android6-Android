package com.example.lehuyduc.lab3;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Le Huy Duc on 27/11/2016.
 */

public class TurnThreeApiClassNamedD {
    @SerializedName("d") public static HairStyle[] hairStyles;

    public ArrayList<HairStyle> getHairStyles() {
        ArrayList<HairStyle> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(hairStyles));
        return arrayList;
    }

//    @Override
//    public String toString() {
//        String res = "";
//        for (HairStyle hairStyle : hairStyles) {
//            res = res + hairStyle.toString() + "\n";
//            Log.d("Three", hairStyle.getId());
//        }
//
//        return res;
//    }


    @Override
    public String toString() {
        return super.toString();
    }
}
