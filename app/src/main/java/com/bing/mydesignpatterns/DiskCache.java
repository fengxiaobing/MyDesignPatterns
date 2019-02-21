package com.bing.mydesignpatterns;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.bing.mydesignpatterns.inter.ImageCache;
import com.bing.mydesignpatterns.utils.CloseUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/20.
 * SD卡缓存
 */

public class DiskCache implements ImageCache{
    static String cacheDir = "sdcard/cache1/";

    public DiskCache() {
        File file = new File(cacheDir);
        if(!file.exists()){
            file.mkdirs();
        }
    }
    /**
     * 从SD卡中获取图片
     * @param url
     * @return
     */
    @Override
    public Bitmap get(String url){
        url = conversion(url);

        return BitmapFactory.decodeFile(cacheDir+url);
    }

    /**
     * 地址转化 https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=65183942,997310997&fm=26&gp=0.jpg转为
     *              u=65183942,997310997&fm=26&gp=0.jpg
     * @param url
     * @return
     */
    private String conversion(String url) {

        String[] strings = url.split("/");
        return url = strings[strings.length-1];
    }

    @Override
    public void put(String url,Bitmap bmp){
          url = conversion(url);

        FileOutputStream fileOutputStream = null;

        try {
            /*
            File  filePic = new File(url);
            if (!filePic.exists()) {
                filePic.getParentFile().mkdirs();
                filePic.createNewFile();
            }

            fileOutputStream = new FileOutputStream(filePic);*/


        //这里直接传name的时候就可以自动把
            fileOutputStream = new FileOutputStream(cacheDir+url);
            bmp.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            CloseUtils.closeQuietly(fileOutputStream);
        }
    }



}
