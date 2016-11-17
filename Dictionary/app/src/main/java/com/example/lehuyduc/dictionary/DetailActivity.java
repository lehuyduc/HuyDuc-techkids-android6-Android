package com.example.lehuyduc.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lehuyduc.dictionary.fragments.DetailFragment;
import com.example.lehuyduc.dictionary.models.Word;

public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra(Word.POSITION_KEY, -1);

        if (position!=-1) {
            Word word = Word.list.get(position);

            DetailFragment detailFragment = DetailFragment.create(word);

            changeFragment(R.id.fl_detail, detailFragment, false);
        }
    }


}
