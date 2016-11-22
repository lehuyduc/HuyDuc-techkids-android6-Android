package com.example.lehuyduc.lab22;

import android.support.v4.media.MediaMetadataCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Le Huy Duc on 21/11/2016.
 */

public class NewsItemHolder {

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.iv_image)
    ImageView ivImage;

    public NewsItemHolder(View view) {
        ButterKnife.bind(this, view);
    }

    public void setData(NewsItem newsItem) {
        tvContent.setText(newsItem.getContent());
        ivImage.setImageResource(newsItem.getImageResId());
    }
}
