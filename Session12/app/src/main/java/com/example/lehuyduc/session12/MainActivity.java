package com.example.lehuyduc.session12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lehuyduc.session12.networking.aserver.RetrofitContext;
import com.example.lehuyduc.session12.networking.aserver.models.RegisterRequestBody;
import com.example.lehuyduc.session12.networking.aserver.models.RegisterResponseBody;
import com.example.lehuyduc.session12.networking.aserver.models.Repo;
import com.example.lehuyduc.session12.networking.aserver.services.GithubService;
import com.example.lehuyduc.session12.networking.aserver.services.RegisterService;
import com.example.lehuyduc.session12.networking.databases.RealmContext;
import com.example.lehuyduc.session12.networking.databases.models.Person;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private Realm realm;

    @BindView(R.id.tv_hello)
    TextView tvHello;

    @BindView(R.id.et_name)
    EditText etName;

    @BindView(R.id.bt_add)
    Button btAdd;

    @BindView(R.id.tv_list) TextView tvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

//        RetrofitContext.getGithubRepos("phuongbk90").enqueue(new Callback<List<Repo>>() {
//            @Override
//            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
//                Log.d(TAG, "onResponse");
//                List<Repo> repoList = response.body();
//                for (Repo repo : repoList) tvHello.setText(repo.toString());
//            }
//
//            @Override
//            public void onFailure(Call<List<Repo>> call, Throwable t) {
//                Log.d(TAG, "onFailure");
//            }
//        });
//
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        // 2. Create service
//        GithubService githubService = retrofit.create(GithubService.class);
//
//        // 3. Create call
//        Call<List<Repo>> call = githubService.listRepos("phuongbk90");
//
//        // 4. Request api:
//        call.enqueue(new Callback<List<Repo>>() {
//            @Override
//            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
//                Log.d(TAG, "onResponse");
//                List<Repo> repoList = response.body();
//                for (Repo repo : repoList)
//                    Log.d(TAG, repo.toString());
//            }
//
//            @Override
//            public void onFailure(Call<List<Repo>> call, Throwable t) {
//                Log.d(TAG, "onFailure");
//            }
//        });


        //****************************************************************************************//

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://a-server.herokuapp.com/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RegisterService registerService = retrofit.create(RegisterService.class);
//
//        RegisterRequestBody registerRequestBody = new RegisterRequestBody(
//                123123,
//                "lehuyduc",
//                "myEmail",
//                "123asdoia",
//                "10",
//                "8",
//                "1998",
//                "0123456789");
//
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
//                (new Gson().toJson(registerRequestBody)));
//
//        Call<RegisterResponseBody> register =
//                registerService.register(requestBody);
//
//        register.enqueue(new Callback<RegisterResponseBody>() {
//            @Override
//            public void onResponse(Call<RegisterResponseBody> call, Response<RegisterResponseBody> response) {
//                Log.d(TAG, "onResponse");
//                RegisterResponseBody body = response.body();
//                tvHello.setText(body.toString());
//                Log.d(TAG, body.toString());
//
//            }
//
//            @Override
//            public void onFailure(Call<RegisterResponseBody> call, Throwable t) {
//                Log.d(TAG, "onFailure");
//            }
//        });

        //****************************************************************************************//
//        // 1. Init realm
//        //Realm.init(this);
        realm = Realm.getDefaultInstance();
        updateUI();

//        // 2. Create unmanaged object
//        //   Person person = Person.create("HD");
//
//        // 3. Add to realm
//        Person p = Person.create("MyHD");
//        RealmContext.getInstance().insertToRealm(p);
//        // p.deleteFromRealm();
//
//        //*** Read
//        List<Person> personList = realm.where(Person.class).findAll();
//
//        for (Person person : personList)
//            Log.d(TAG, person.getName());
    }

    void updateUI() {
        List<Person> personList = RealmContext.getInstance().getAllPerson();
        String res = "";
        for (Person person : personList)
            res = res + person.toString() + "\n";
        tvList.setText(res);
    }


    @OnClick(R.id.bt_add)
    public void onAddClick(View view) {
        String name = etName.getText().toString();
        if (!name.equals("")) {
            RealmContext.getInstance().insertToRealm(Person.create(name));
            updateUI();
        }
    }
}
