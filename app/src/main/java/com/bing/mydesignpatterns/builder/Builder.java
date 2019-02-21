package com.bing.mydesignpatterns.builder;

/**
 * Created by Administrator on 2019/2/21.
 */

public  class Builder{
    String mBoard = "默认mBoard";
    String mDisplay = "默认mDisplay";
    String mOS = "默认mOS";

    public Builder setmBoard(String mBoard) {
        this.mBoard = mBoard;
        return this;
    }

    public Builder setmDisplay(String mDisplay) {
        this.mDisplay = mDisplay;
        return this;
    }

    public Builder setmOS(String mOS) {
        this.mOS = mOS;
        return this;
    }


}
