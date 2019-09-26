package com.curiousca.lotterywin.model;

public class MegaItem {

    private String mNumbers;
    private String mMega;
    private String mDrawDate;

    public MegaItem(String numbers, String mega, String drawDate) {
        this.mNumbers = numbers;
        this.mMega = mega;
        this.mDrawDate = drawDate;
    }

    public String getmNumbers() {
        return mNumbers;
    }

    public String getmMega() {
        return mMega;
    }

    public String getmDrawDate() {
        return mDrawDate;
    }

}
