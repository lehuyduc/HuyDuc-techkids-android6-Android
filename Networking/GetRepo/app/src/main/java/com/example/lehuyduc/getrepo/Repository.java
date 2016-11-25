package com.example.lehuyduc.getrepo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 25/11/2016.
 */

public class Repository {
    private String name;
    private Owner owner;

    public Repository(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }
}
