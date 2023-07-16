package com.five;

/**
 * 梯形
 */
public class Trapezia extends TiXing  implements IShape  {

    public Trapezia(double top, double bottom, double height) {
        super(top, bottom, height);
    }

    @Override
    public String getType() {
        return getName();
    }

    @Override
    public double getArea() {
        return mianji();
    }
}
