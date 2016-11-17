package com.example.lehuyduc.dictionary.models;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le Huy Duc on 16/11/2016.
 */

public class Word implements Serializable {

    public static final String POSITION_KEY = "position";
    public static final String WORD_KEY = "word";

    private int id;
    private String originalWord, translatedWord, dateCreated;
    private int isFavorite;

    public Word(int id, String originalWord, String translatedWord, String dateCreated, int isFavorite) {
        this.id = id;
        this.originalWord = originalWord;
        this.translatedWord = translatedWord;
        this.dateCreated = dateCreated;
        this.isFavorite = isFavorite;
    }

    public static ArrayList<Word> list = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public void setOriginalWord(String originalWord) {
        this.originalWord = originalWord;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    public void setTranslatedWord(String translatedWord) {
        this.translatedWord = translatedWord;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(int isFavorite) {
        this.isFavorite = isFavorite;
    }

    @Override
    public String toString() {
        return originalWord;
    }

    public String getInfo() {
        return "Word{" +
                "id=" + id +
                ", originalWord='" + originalWord + '\'' +
                ", translatedWord='" + translatedWord + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", isFavorite=" + isFavorite +
                '}';
    }
}
