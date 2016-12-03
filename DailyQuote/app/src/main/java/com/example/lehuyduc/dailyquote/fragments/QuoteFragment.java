package com.example.lehuyduc.dailyquote.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lehuyduc.dailyquote.MainActivity;
import com.example.lehuyduc.dailyquote.R;
import com.example.lehuyduc.dailyquote.constants.Constants;
import com.example.lehuyduc.dailyquote.managers.Preferences;
import com.example.lehuyduc.dailyquote.models.Quote;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private static final String TAG = QuoteFragment.class.toString();

    @BindView(R.id.imv_background)
    ImageView imvBackground;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_content) TextView tvContent;

    @BindView(R.id.tv_hello) TextView tvHello;

    Quote[] quotes;


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_quote, container, false);

        ButterKnife.bind(this, view);
        setupUI();

        return view;
    }

    private void updateUI() {
        Activity parent = getActivity();

        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvTitle.setText(Html.fromHtml(quotes[0].getTitle().replace("\n","")));
                tvContent.setText(Html.fromHtml(quotes[0].getContent().replace("\n","")));
            }
        });
    }


    private void setupUI() {
        ImageLoader.getInstance().displayImage(Constants.UNSPLASH_API, imvBackground);

        tvHello.setText(String.format("Hi, %s", Preferences.getInstance().getUserName()));

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(Constants.QUOTE_API).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, String.format("Response: %s", body));

                Gson gson = new Gson();
                quotes = gson.fromJson(body, Quote[].class);

                updateUI();
            }
        });
    }

}
