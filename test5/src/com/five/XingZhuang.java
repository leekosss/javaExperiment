package com.five;

public abstract class XingZhuang {
    private String name;
    public XingZhuang(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract double mianji();
}
