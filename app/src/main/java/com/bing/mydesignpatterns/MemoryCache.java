package com.bing.mydesignpatterns;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.bing.mydesignpatterns.inter.ImageCache;

/**
 * Created by Administrator on 2019/2/20.
 * 内存中缓存
 */

public class MemoryCache implements ImageCache{
    //图片缓存
    LruCache<String,Bitmap> mImageCache;

    public MemoryCache() {
        initImageCache();

    }
    private void initImageCache() {
        //计算可使用的最大内存
        final int maxMermory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一的内存作为缓存
        final int cacheSize = maxMermory / 4;
        mImageCache = new LruCache<String ,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }


    public void put(String url,Bitmap bitmap){
        mImageCache.put(url, bitmap);
    }

    public Bitmap get(String url){
      return  mImageCache.get(url);
    }


}
