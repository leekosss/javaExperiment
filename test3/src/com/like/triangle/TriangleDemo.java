package com.like.triangle;

public class TriangleDemo {
    public static void main(String[] args) {
        Triangle t = new Triangle(2,3,4);
        t.dispBian();
        RtTriangle rtTriangle = new RtTriangle(10);
        rtTriangle.show();
    }
}

class Triangle {

    double a,b,c;


    public Triangle() {
    }
    public Triangle(double a,double b,double c) {
            this.a=a;
            this.b=b;
            this.c=c;
    }

    public Triangle(double yao,double di) {
            this.a = yao;
            this.b=yao;
            this.c = di;
    }

    public Triangle(double a) {
            this.a = a;
            this.b = a;
            this.c = a;
    }

    public double getPerimeter() {
        return a+b+c;
    }
    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    //修改三边的值
    public void setBian(double a,double b,double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    //显示三角形三条边
    public void dispBian() {
        System.out.println( "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}');
    }
}


class RtTriangle extends Triangle {
    public RtTriangle(double a,double b,double c) {
            super(a,b,c);
    }

    public RtTriangle(double zhi) {
            double xie = Math.sqrt(zhi*zhi + zhi*zhi);
            this.a = zhi;
            this.b = zhi;
            this.c = xie;

    }

    public void show() {
        System.out.println( "RtTriangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}');
    }
}



