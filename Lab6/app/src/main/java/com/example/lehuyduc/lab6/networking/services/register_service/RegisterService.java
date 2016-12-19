package com.example.lehuyduc.lab6.networking.services.register_service;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public interface RegisterService {
    @POST("register")
    Call<RegisterResponseBody> register(@Body RequestBody body);
}
