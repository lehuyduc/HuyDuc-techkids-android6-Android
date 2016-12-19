package com.example.lehuyduc.lab6.networking;

import android.util.Log;

import com.example.lehuyduc.lab6.eventbus_events.LoginEvent;
import com.example.lehuyduc.lab6.eventbus_events.ToastEvent;
import com.example.lehuyduc.lab6.models.Note;
import com.example.lehuyduc.lab6.models.User;
import com.example.lehuyduc.lab6.networking.services.get_data_service.GetDataResponseBody;
import com.example.lehuyduc.lab6.networking.services.get_data_service.GetDataService;
import com.example.lehuyduc.lab6.networking.services.login_service.LoginRequestBody;
import com.example.lehuyduc.lab6.networking.services.login_service.LoginResponseBody;
import com.example.lehuyduc.lab6.networking.services.login_service.LoginService;
import com.example.lehuyduc.lab6.networking.services.register_service.RegisterRequestBody;
import com.example.lehuyduc.lab6.networking.services.register_service.RegisterResponseBody;
import com.example.lehuyduc.lab6.networking.services.register_service.RegisterService;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class RetrofitContext {
    private static final String TAG = RetrofitContext.class.toString();

    private static Retrofit retrofit;

    public static void init(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static void register(User user) {

        RegisterService registerService = retrofit.create(RegisterService.class);

        RegisterRequestBody registerRequestBody = new RegisterRequestBody(user.getUsername(), user.getPassword());
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                                                    new Gson().toJson(registerRequestBody));

        Call<RegisterResponseBody> call = registerService.register(requestBody);
        call.enqueue(new Callback<RegisterResponseBody>() {
            @Override
            public void onResponse(Call<RegisterResponseBody> call, Response<RegisterResponseBody> response) {
                RegisterResponseBody body = response.body();
                Log.d(TAG, "register onResponse");
                if (response.code()==400) {
                    Log.d(TAG, "Username used");
                    EventBus.getDefault().post(new ToastEvent("Username used"));
                    return;
                }

                Log.d(TAG, body.toString());
                EventBus.getDefault().post(new ToastEvent("Username created"));
            }

            @Override
            public void onFailure(Call<RegisterResponseBody> call, Throwable t) {
                Log.d(TAG, "register onFailure");
            }
        });
    }

    public static void login(final User user) {

        LoginService loginService = retrofit.create(LoginService.class);

        LoginRequestBody loginRequestBody = new LoginRequestBody(user.getUsername(), user.getPassword());
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                                                    new Gson().toJson(loginRequestBody));

        Call<LoginResponseBody> call = loginService.login(requestBody);
        call.enqueue(new Callback<LoginResponseBody>() {
            @Override
            public void onResponse(Call<LoginResponseBody> call, Response<LoginResponseBody> response) {
                Log.d(TAG, "login onResponse: " + response.code() + " " + response.message());
                LoginResponseBody body = response.body();
                Log.d(TAG, body.toString());
                EventBus.getDefault().post(new ToastEvent("Login successful"));
                EventBus.getDefault().post(new LoginEvent(user, body.getToken()));
            }

            @Override
            public void onFailure(Call<LoginResponseBody> call, Throwable t) {
                Log.d(TAG, "login onFailure");
            }
        });
    }

    public static void getData(String token) {
        GetDataService getDataService = retrofit.create(GetDataService.class);

        Call<ArrayList<Note>> call = getDataService.getAllTodos(token);
        call.enqueue(new Callback<ArrayList<Note>>() {
            @Override
            public void onResponse(Call<ArrayList<Note>> call, Response<ArrayList<Note>> response) {
                ArrayList<Note> notes = response.body();
                Note.notes = notes;
                Log.d(TAG,"getData onResponse" + notes.size());
                EventBus.getDefault().post(new LoginEvent(null,null));
                for (Note note : notes)
                    Log.d(TAG, note.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Note>> call, Throwable t) {
                Log.d(TAG, "getData onFailure: " + t.getMessage());
            }
        });
    }
}
