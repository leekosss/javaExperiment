package com.five;

public class Rectangle implements IShape{
    private String type;
    private double height,width;
    public Rectangle(double height,double width) {
        type = "矩形";
        this.height = height;
        this.width = width;
    }
    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getArea() {
        return width*height;
    }
}
