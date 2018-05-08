package com.htc.coastline.entity;

public class BinValue {
    private int bin;
    private int value;

    public BinValue(int bin, int value) {
        this.bin = bin;
        this.value = value;
    }

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) {
        this.bin = bin;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
