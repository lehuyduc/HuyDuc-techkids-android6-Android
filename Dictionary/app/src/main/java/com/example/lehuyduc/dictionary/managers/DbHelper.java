package com.example.lehuyduc.dictionary.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;

import com.example.lehuyduc.dictionary.models.Word;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le Huy Duc on 16/11/2016.
 */

public class DbHelper extends SQLiteAssetHelper {

    private static final String DB_NAME = "dictionary.db";
    private static final int DB_VERSION = 1;
    private static final String WORD_TABLE_NAME = "tbl_word";

    /****************** NOTE CONSTANT **********************************/
    public static final String WORD_ID_COLUMN = "id";
    public static final String WORD_ORIGINAL_WORD_COLUMN = "original_word";
    public static final String WORD_TRANSLATED_WORD_COLUMN = "translated_word";
    public static final String WORD_DATE_CREATED_COLUMN = "date_created";
    public static final String WORD_IS_FAVORITE_COLUMN = "is_favorite";

    public static final String[] WORD_COLUMNS = new String[] {
            WORD_ID_COLUMN,
            WORD_ORIGINAL_WORD_COLUMN,
            WORD_TRANSLATED_WORD_COLUMN,
            WORD_DATE_CREATED_COLUMN,
            WORD_IS_FAVORITE_COLUMN
    };

    /********************** CONSTRUCTOR AND SINGLETON ******************/
    private DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static DbHelper instance;

    public static void init(Context context) {
        instance = new DbHelper(context);
    }

    public static DbHelper getInstance() {
        return instance;
    }


    /***************   WORD FUNCTON ************************/
    public ArrayList<Word> selectAllWords() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Word> wordList = new ArrayList<>();

        Cursor cursor = db.query(WORD_TABLE_NAME,WORD_COLUMNS,null,null,null,null,null);
        cursor = db.query(WORD_TABLE_NAME, WORD_COLUMNS,null,null,null,null, WORD_ORIGINAL_WORD_COLUMN + " ASC");

        while (cursor.moveToNext())
            wordList.add(getWord(cursor));

        db.close();
        return wordList;
    }

    public ArrayList<Word> selectWordsLike(String originalWord) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Word> wordList = new ArrayList<>();

        String[] args = new String[] {originalWord + "%"};

        //Cursor cursor = db.query(WORD_TABLE_NAME, WORD_COLUMNS, WORD_ORIGINAL_WORD_COLUMN + " LIKE ?", args,
          //      null,null,null,null);
        Cursor cursor = db.query(WORD_TABLE_NAME, WORD_COLUMNS, WORD_ORIGINAL_WORD_COLUMN + " LIKE ?", args,
                null,null,WORD_ORIGINAL_WORD_COLUMN + " ASC");

        while (cursor.moveToNext())
            wordList.add(getWord(cursor));

        db.close();
        return wordList;
    }

    public ArrayList<Word> selectWordsFavorite() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Word> wordList = new ArrayList<>();

        String[] args = new String[] {"1"};

        Cursor cursor = db.query(WORD_TABLE_NAME, WORD_COLUMNS, WORD_IS_FAVORITE_COLUMN + "=?", args,
                null,null,WORD_ORIGINAL_WORD_COLUMN + " ASC");

        while (cursor.moveToNext())
            wordList.add(getWord(cursor));

        return wordList;
    }

    public Word selectWord(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] args = new String[] {String.valueOf(id)};

        Cursor cursor = db.query(WORD_TABLE_NAME,WORD_COLUMNS, WORD_ID_COLUMN + "=?", args,
                null, null, WORD_ORIGINAL_WORD_COLUMN + " ASC");
        if (cursor!=null) cursor.moveToFirst();
        else return null;

        Word word = getWord(cursor);

        db.close();
        return word;
    }

    public Word selectWord(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] args = new String[] {name};

        Cursor cursor = db.query(WORD_TABLE_NAME, WORD_COLUMNS, WORD_ORIGINAL_WORD_COLUMN + "=?", args,
                null,null,WORD_ORIGINAL_WORD_COLUMN + " ASC");
        if (cursor!=null) cursor.moveToFirst();
        else return null;

        Word word = getWord(cursor);

        db.close();
        return word;
    }

    public void insert(Word word) {
        SQLiteDatabase db = this.getWritableDatabase();

        int id = (int) db.insert(WORD_TABLE_NAME, null, createContentValues(word));
        word.setId(id);

        db.close();
    }

    public void delete(Word word) {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] args = new String[] {word.getOriginalWord()};

        db.delete(WORD_TABLE_NAME,WORD_ORIGINAL_WORD_COLUMN + "=?",args);

        db.close();
    }

    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] args = new String[] {String.valueOf(id)};

        db.delete(WORD_TABLE_NAME,"id=?",args);

        db.close();
    }

    public void update(Word word) {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] args = new String[] {String.valueOf(word.getId())};

        db.update(WORD_TABLE_NAME, createContentValues(word), "id=?", args);

        db.close();
    }

    private ContentValues createContentValues(Word word) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(WORD_ORIGINAL_WORD_COLUMN, word.getOriginalWord());
        contentValues.put(WORD_TRANSLATED_WORD_COLUMN, word.getTranslatedWord());
        contentValues.put(WORD_DATE_CREATED_COLUMN, word.getDateCreated());
        contentValues.put(WORD_IS_FAVORITE_COLUMN, word.getIsFavorite());

        return contentValues;
    }


    private Word getWord(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(WORD_ID_COLUMN));
        String originalWord = cursor.getString(cursor.getColumnIndex(WORD_ORIGINAL_WORD_COLUMN));
        String translatedWord = cursor.getString(cursor.getColumnIndex(WORD_TRANSLATED_WORD_COLUMN));
        String dateCreated = cursor.getString(cursor.getColumnIndex(WORD_DATE_CREATED_COLUMN));
        int isFavorite = cursor.getInt(cursor.getColumnIndex(WORD_IS_FAVORITE_COLUMN));

        Word word = new Word(id,originalWord,translatedWord,dateCreated,isFavorite);
        return word;
    }
}
