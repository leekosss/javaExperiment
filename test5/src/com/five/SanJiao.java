package com.five;

public class SanJiao extends XingZhuang{
    private double height,bottom;
    public SanJiao(double height,double bottom) {
        super("三角形");
        this.height = height;
        this.bottom = bottom;
    }
    @Override
    public double mianji() {
        return (height*bottom)/2;
    }
}
