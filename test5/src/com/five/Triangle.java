package com.five;

public class Triangle extends SanJiao implements IShape{

    public Triangle(double height,double bottom) {
        super(height, bottom);
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
