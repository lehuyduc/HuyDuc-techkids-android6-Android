package com.example.lehuyduc.lab22;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Le Huy Duc on 21/11/2016.
 */

public class NewsArrayAdapter extends ArrayAdapter<NewsItem> {

    public NewsArrayAdapter(Context context, int resource, List objects) {
        super(context,resource,objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView==null)
            convertView = layoutInflater.inflate(R.layout.list_item_news, parent, false);

        NewsItem newsItem = getItem(position);

        new NewsItemHolder(convertView).setData(newsItem);

        return convertView;
    }
}
