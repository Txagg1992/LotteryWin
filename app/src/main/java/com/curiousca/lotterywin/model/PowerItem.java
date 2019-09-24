package com.curiousca.lotterywin.model;

public class PowerItem {

    private String pNumbers;
    private String pDrawDate;

    public PowerItem(String numbers, String drawDate) {
        this.pNumbers = numbers;
        this.pDrawDate = drawDate;
    }

    public String getpNumbers() {
        return pNumbers;
    }

    public String getpDrawDate() {
        return pDrawDate;
    }
}
