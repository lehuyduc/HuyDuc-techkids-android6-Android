package com.example.lehuyduc.lab22;

/**
 * Created by Le Huy Duc on 21/11/2016.
 */

public class NewsItem {
    private String content;
    private int imageResId;

    public NewsItem(String content, int imageResId) {
        this.content = content;
        this.imageResId = imageResId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public static final NewsItem[] ARRAY = new NewsItem[] {
            new NewsItem("He may act like he wants a secretary but most of the time they’re looking for…", R.drawable.item1),
            new NewsItem("Peggy, just think about it. Deeply. Then forget it. And an idea will jump up on your face", R.drawable.item2),
            new NewsItem("Go home, take a paper bag and cut some eyeholes out of it. Put it over your head", R.drawable.item3),
            new NewsItem("Get out of here and move forward. This never happened. It will shock you how much", R.drawable.item4),
            new NewsItem("That poor girl. She doesn’t know that loving you is the worst way to get you", R.drawable.item5)
    };

    @Override
    public String toString() {
        return content;
    }
}
