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

    public void setmNumbers(String mNumbers) {
        this.mNumbers = mNumbers;
    }

    public String getmMega() {
        return mMega;
    }

    public void setmMega(String mMega) {
        this.mMega = mMega;
    }

    public String getmDrawDate() {
        return mDrawDate;
    }

    public void setmDrawDate(String mDrawDate) {
        this.mMega = mDrawDate;
    }
}
