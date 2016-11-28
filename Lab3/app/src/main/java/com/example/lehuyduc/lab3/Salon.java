package com.example.lehuyduc.lab3;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Le Huy Duc on 27/11/2016.
 */

public class Salon {

    @SerializedName("Name") String name;

    @SerializedName("Fanpage") String fanpage;

    @SerializedName("FanPageId") String fanPageId;

    @SerializedName("ManagerName") String managerName;

    @SerializedName("Phone") String phone;

    @SerializedName("Images")
    Images[] images;

    @SerializedName("Id") String id;

    public Salon(String name, String fanpage, String fanPageId, String managerName, String phone, ArrayList<Images> images, String id) {
        this.name = name;
        this.fanpage = fanpage;
        this.fanPageId = fanPageId;
        this.managerName = managerName;
        this.phone = phone;
        this.id = id;
    }

    @Override
    public String toString() {
        String res = "Salon{" +
                "name='" + name + '\'' +
                ", fanpage='" + fanpage + '\'' +
                ", fanPageId='" + fanPageId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", phone='" + phone + '\''
                ;

        for (Images images : this.images) res = res + images.toString() + "\n";

        return res;
    }
}
