package com.five;

public class TiXing extends XingZhuang{
    private double top,bottom,height;
    public TiXing(double top,double bottom,double height) {
        super("梯形");
        this.bottom=bottom;
        this.top=top;
        this.height = height;
    }
    @Override
    public double mianji() {
        return (top+bottom)*height/2;
    }
}
