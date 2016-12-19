package com.example.lehuyduc.lab6.networking.services.get_data_service;

import com.example.lehuyduc.lab6.models.Note;
import com.example.lehuyduc.lab6.networking.services.register_service.RegisterResponseBody;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public interface GetDataService {

    @GET("todos")
    Call<ArrayList<Note>> getAllTodos(@Header("token") String token);

}
