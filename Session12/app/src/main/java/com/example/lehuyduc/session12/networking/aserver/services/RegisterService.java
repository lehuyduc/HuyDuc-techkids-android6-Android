package com.example.lehuyduc.session12.networking.aserver.services;

import com.example.lehuyduc.session12.networking.aserver.models.RegisterResponseBody;


import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Le Huy Duc on 06/12/2016.
 */

public interface RegisterService {
    @POST("register")
    Call<RegisterResponseBody> register(@Body RequestBody body);
}
