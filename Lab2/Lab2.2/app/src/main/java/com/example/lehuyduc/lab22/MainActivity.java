package com.example.lehuyduc.lab22;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lv_news_feed)
    ListView lvNewsFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupUI();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    private void setupUI() {
        ArrayAdapter itemAdapter = new NewsArrayAdapter(
                this,
                R.layout.list_item_news,
                Arrays.asList(NewsItem.ARRAY)
                );
        lvNewsFeed.setAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();
    }


}
