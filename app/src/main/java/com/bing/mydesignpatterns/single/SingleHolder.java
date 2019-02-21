package com.bing.mydesignpatterns.single;

/**
 * Created by Administrator on 2019/2/21.
 * 静态内部类方式
 */

public class SingleHolder {
    private SingleHolder() {
    }
    private static class InstanceHolder{
        private static SingleHolder sInstance = new SingleHolder();
    }
    public static SingleHolder getInstance(){
        return InstanceHolder.sInstance;

    }
}
