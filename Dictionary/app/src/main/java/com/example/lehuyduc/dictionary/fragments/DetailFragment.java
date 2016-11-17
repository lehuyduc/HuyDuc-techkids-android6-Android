package com.example.lehuyduc.dictionary.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lehuyduc.dictionary.managers.DbHelper;
import com.example.lehuyduc.dictionary.R;
import com.example.lehuyduc.dictionary.models.Word;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    Word word;
    TextView tvOriginalWord, tvTranslatedWord;
    CheckBox cbIsFavorite;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment create(Word word) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setWord(word);
        return detailFragment;
    }

    public void setWord(Word word) {
        this.word = word;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        getReferences(view);
        setupUI();
        addListener();

        // Inflate the layout for this fragment
        return view ;
    }

    void getReferences(View view) {
        tvOriginalWord = (TextView) view.findViewById(R.id.tv_original_word);
        cbIsFavorite = (CheckBox) view.findViewById(R.id.cb_is_favorite);
        tvTranslatedWord = (TextView) view.findViewById(R.id.tv_translated_word);
    }

    void setupUI() {
        tvOriginalWord.setText(word.getOriginalWord());

        if (word.getIsFavorite()==0) cbIsFavorite.setChecked(false);
        else cbIsFavorite.setChecked(true);

        tvTranslatedWord.setText(word.getTranslatedWord());
    }

    private void addListener() {
        cbIsFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox checkBox = (CheckBox) view;
                if (!checkBox.isChecked()) {
                    word.setIsFavorite(0);
                    checkBox.setChecked(false);
                    DbHelper.getInstance().update(word);
                }
                else {
                    word.setIsFavorite(1);
                    checkBox.setChecked(true);
                    DbHelper.getInstance().update(word);
                }
            }
        });

    }
}
