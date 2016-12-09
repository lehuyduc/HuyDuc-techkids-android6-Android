package com.example.lehuyduc.session12.networking.aserver.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 06/12/2016.
 */

public class Repo {
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("owner")
    private RepoOwner repoOwner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RepoOwner getRepoOwner() {
        return repoOwner;
    }

    public void setRepoOwner(RepoOwner repoOwner) {
        this.repoOwner = repoOwner;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", repoOwner=" + "\n" + repoOwner.toString() +
                '}';
    }
}
