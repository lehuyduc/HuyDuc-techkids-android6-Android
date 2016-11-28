package com.example.lehuyduc.lab3;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Le Huy Duc on 27/11/2016.
 */

public class HairStyle {

    @SerializedName("Id") String id;

    @SerializedName("Title") String title;

    @SerializedName("Description") String description;

    @SerializedName("Images") Images[] images;


    public HairStyle(String description, String id, Images images, String title) {
        this.description = description;
        this.id = id;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        if (images[0]!=null) return images[0].getUrl();
        else return "";
    }

    @Override
    public String toString() {
        String res =  "HairStyle{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + "\n";

        for (Images image : images) res = res + image.toString() + "\n";

        return res;
    }
}
