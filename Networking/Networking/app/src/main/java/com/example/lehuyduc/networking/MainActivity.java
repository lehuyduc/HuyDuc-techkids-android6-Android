package com.example.lehuyduc.networking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lehuyduc.networking.jsonmodels.Post;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private ListView lvPost;
    private ArrayAdapter<Post> postArrayAdapter;
    private ArrayList<Post> postArrayList;
    String url = "https://a5-tumblelog.herokuapp.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        getReferences();
        configUI();


    }

    void sendGET() {
        // Create a client
        OkHttpClient client = new OkHttpClient();

        // Create a request
        Request request = new Request.Builder()
                .url(url)
                .build();

        // 3 Send request
        // Sync vs Async (2:)
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG,"Internet fail: %s", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string(); // only once
                Log.d(TAG, String.format("Response: %s", body));

                Gson gson = new Gson();
                Post[] posts = gson.fromJson(body, Post[].class);
                postArrayList.clear();
                postArrayList.addAll(Arrays.asList(posts));

                // Come back to main thread and update UI
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        postArrayAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    void sendPOST() {
        // Create client
        OkHttpClient client = new OkHttpClient();

        // 2. Create body
        // 2.1 Media type
        // 2.2 Data

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        Post post = new Post("FROM HDD","Cat is meow");
        Gson gson = new Gson();
        String data = gson.toJson(post);
        RequestBody requestBody = RequestBody.create(JSON, data);

        //3. Create request
        Request request = new Request.Builder().url(url).post(requestBody).build();

        // 4. Send request
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, String.format("Post onFailure %s", e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, String.format("Post onResponse: %s ",body));
            }
        });
    }

    void getReferences() {
        lvPost = (ListView) findViewById(R.id.lv_post);
    }

    private void initData() {
        postArrayList = new ArrayList<>();
    }

    void configUI() {
        postArrayAdapter = new ArrayAdapter<Post>(this, android.R.layout.simple_list_item_1, postArrayList);
        lvPost.setAdapter(postArrayAdapter);
    }
}
