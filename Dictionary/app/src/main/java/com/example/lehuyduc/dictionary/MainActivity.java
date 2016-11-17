package com.example.lehuyduc.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lehuyduc.dictionary.managers.DbHelper;
import com.example.lehuyduc.dictionary.models.Word;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.toString();

    private ArrayList<Word> words;
    private ArrayAdapter<Word> wordArrayAdapter;

    EditText etSearch;
    ListView lvWords;
    Button btFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();
        setupUI();
        addListener();
    }

    private void testAdder() {
       // Word word = new Word(-1,"hellow","elo hell","",0);
       // DbHelper.getInstance().insert(word);
    }

    private void testSelectLike(String oriWord) {
        ArrayList<Word> wordList = new ArrayList<>();
        wordList = DbHelper.getInstance().selectWordsLike(oriWord);

        for (Word word : wordList)
            Log.d(TAG,word.toString());

    }

    private void testSelectAll() {
        ArrayList<Word> wordList = new ArrayList<>();
        wordList = DbHelper.getInstance().selectAllWords();

        for (Word word : wordList)
            Log.d(TAG,word.getInfo());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    void getReferences() {
        etSearch = (EditText) findViewById(R.id.et_search);
        lvWords = (ListView) findViewById(R.id.lv_words);
        btFind = (Button) findViewById(R.id.bt_find);
        words = Word.list;
    }



    void setupUI() {
        updateListView();
    }

    void addListener() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG,"changing");
                String originalWord = charSequence.toString();
                Word.list = DbHelper.getInstance().selectWordsLike(originalWord);
                updateListView();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        lvWords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(Word.POSITION_KEY,i);
                startActivity(intent);
            }
        });

        btFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word.list = DbHelper.getInstance().selectWordsFavorite();
                updateListView();
            }
        });
    }

    void updateListView() {
        words = Word.list;
        wordArrayAdapter = new ArrayAdapter<Word>(
                MainActivity.this, android.R.layout.simple_list_item_1, words);
        lvWords.setAdapter(wordArrayAdapter);
    }
}
