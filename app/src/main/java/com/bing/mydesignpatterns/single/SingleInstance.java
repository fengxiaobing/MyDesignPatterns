package com.bing.mydesignpatterns.single;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/2/21.
 * 双重检查
 * 缺点：第一次加载反应偏慢
 * 优点：资源利用率高
 */

public class SingleInstance implements Serializable{
    private static final long serialVersionUID = 0l;

    private static SingleInstance instance = null;

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }


}
