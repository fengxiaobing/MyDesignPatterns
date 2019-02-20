package com.bing.mydesignpatterns.inter;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2019/2/21.
 */

public interface ImageCache {
    void put(String url, Bitmap bitmap);
    Bitmap get(String url);
}
