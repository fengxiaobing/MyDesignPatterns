package com.bing.mydesignpatterns;

import android.graphics.Bitmap;

import com.bing.mydesignpatterns.inter.ImageCache;

/**
 * Created by Administrator on 2019/2/21.
 */

public class DoubleCache implements ImageCache{
    DiskCache mDiskCache = new DiskCache();
    MemoryCache mMermoryCache = new MemoryCache();



    /**
     * 如果缓存中没有图片  则从SD卡中获取
     * @param url
     * @return
     */
    public Bitmap get(String url){
        Bitmap bitmap = mMermoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    /**
     * 将图片缓存到缓存和SD卡中
     * @param url
     * @param bitmap
     */
    public void put(String url,Bitmap bitmap){
        mMermoryCache.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }
}
