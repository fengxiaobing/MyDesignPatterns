package com.bing.mydesignpatterns;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.bing.mydesignpatterns.inter.ImageCache;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2019/2/20.
 */

public class ImageLoader {
    //内存缓存
    private ImageCache mImageCache = new MemoryCache();

    //线程池，线程池数量为CPU数量
   private ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    //UI Handler
  private   Handler mHandler = new Handler(Looper.getMainLooper());



    public ImageLoader() {
    }

    public void setImageCache(ImageCache imageCache){
        this.mImageCache = imageCache;
    }

    public void displayImage(final String url, final ImageView imageView){

        Bitmap bitmap  = mImageCache.get(url);

        if(bitmap != null){
            imageView.setImageBitmap(bitmap);
            return;
        }

     submitLoadRequest(url,imageView);
    }

    private void submitLoadRequest(final String url, final ImageView imageView) {
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) {
                    return;
                }
                if(imageView.getTag().equals(url)){
                    updateImageView(imageView,bitmap);
                }
                mImageCache.put(url,bitmap);
            }
        });
    }

    private void updateImageView(final ImageView imageView, final Bitmap bitmap) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
           imageView.setImageBitmap(bitmap);
            }
        });
    }

    private Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }


}
