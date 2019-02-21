package com.bing.mydesignpatterns.builder;

/**
 * Created by Administrator on 2019/2/21.
 *
 */

public class Computer {
    String mBoard = "默认mBoard";
    String mDisplay = "默认mDisplay";
    String mOS = "默认mOS";
    public Computer() {
    }
    public void setBuilder(Builder builder){
        mBoard = builder.mBoard;
        mDisplay = builder.mDisplay;
        mOS = builder.mOS;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOS='" + mOS + '\'' +
                '}';
    }
}
