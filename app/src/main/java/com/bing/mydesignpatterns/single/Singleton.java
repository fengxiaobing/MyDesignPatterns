package com.bing.mydesignpatterns.single;

/**
 * Created by Administrator on 2019/2/21.
 * 饿汉式
 */

public class Singleton {
    private static Singleton sInstance = new Singleton();
    private Singleton() {
    }

    public static Singleton getInstance(){
        return sInstance;
    }
    public void doSomething(){

    }
}
