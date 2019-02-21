package com.bing.mydesignpatterns.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/21.
 */

public class CloseUtils {
    private CloseUtils() {
    }
    public static void closeQuietly(Closeable closeable){
        if(closeable !=null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
