package com.example.lehuyduc.getrepo;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Le Huy Duc on 25/11/2016.
 */

public class Owner {

    @SerializedName("login") String login;

    @SerializedName("avatar_url") String avatarUrl;

    public Owner(String login, String avatarUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
