package com.like.circle;

public class CircleDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        circle.disp();
        Cylinder c = new Cylinder(10,20);
        c.disp();
        c.dispVol();
    }
}

//圆类
class Circle {
    private double radius;

    public Circle() {
        this(0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    //获得圆的半径
    public double getRadius() {
        return radius;
    }

    //获得圆的周长
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    //获得圆的面积
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void disp() {
        System.out.println("圆的属性:");
        System.out.printf("半径：%.2f 周长:%.2f 面积：%.2f\n", getRadius(), getPerimeter(), getArea());
    }
}

//圆柱体类
class Cylinder extends Circle {
    double height;

    public Cylinder(double r, double h) {
        super(r);
        height = h;
    }

    public double getHeight() {
        return height;
    }

    public double getVol() {
        double area_circle = super.getArea();
        return area_circle * height;
    }
    public void disp() {
        System.out.println("圆柱的属性:");
        System.out.printf("半径：%.2f 周长:%.2f 面积：%.2f\n", getRadius(), getPerimeter(), getArea());
    }
    public void dispVol() {
        System.out.println("圆柱体的面积为：" + this.getVol());
    }
}
