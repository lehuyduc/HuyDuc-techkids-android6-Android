package com.example.lehuyduc.session12.networking.aserver.services;

import com.example.lehuyduc.session12.networking.aserver.models.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Le Huy Duc on 06/12/2016.
 */

public interface GithubService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String userName);


}
