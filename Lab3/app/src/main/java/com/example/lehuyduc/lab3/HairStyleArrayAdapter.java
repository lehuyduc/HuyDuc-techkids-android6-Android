package com.example.lehuyduc.lab3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Le Huy Duc on 27/11/2016.
 */

public class HairStyleArrayAdapter extends ArrayAdapter<HairStyle> {

    public HairStyleArrayAdapter(Context context, int resource, List<HairStyle> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView==null)
            convertView = layoutInflater.inflate(R.layout.list_item_hair, parent, false);

        HairStyle hairStyle = getItem(position);

        HairStyleHolder hairStyleHolder = new HairStyleHolder(convertView);
        hairStyleHolder.setData(hairStyle);

        return convertView;
    }
}
