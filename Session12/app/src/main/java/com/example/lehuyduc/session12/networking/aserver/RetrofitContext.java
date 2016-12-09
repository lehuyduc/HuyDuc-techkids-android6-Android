package com.example.lehuyduc.session12.networking.aserver;

import com.example.lehuyduc.session12.networking.aserver.services.GithubService;
import com.example.lehuyduc.session12.networking.aserver.models.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Le Huy Duc on 06/12/2016.
 */

public class RetrofitContext {
    private static final Retrofit GITHUB = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    public static Call<List<Repo>> getGithubRepos(String username) {
        return GITHUB.create(GithubService.class).listRepos(username);
    }
}
