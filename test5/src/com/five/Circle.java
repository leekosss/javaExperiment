package com.five;

public class Circle implements IShape{
    private String type;
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
        type = "圆形";
    }
    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getArea() {
        return 3.14*radius*radius;
    }
}
