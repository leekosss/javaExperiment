package com.like.triangle_5;

public class TriangleDemo {
    public static void main(String[] args) {
        Triangle t1 = Triangle.getTriangle(2,3);
        t1.show2();
        Triangle t2 = Triangle.getTriangle(7,3,3);
//        t2.show();
        Triangle t3 = Triangle.getTriangle(2,3,3);
        t3.show();
        Triangle t4 = Triangle.getTriangle(2,3,3);
        t4.show();
        Triangle t5 = Triangle.getTriangle(2,3,3);

    }
}

class Triangle {
    double a,b,c,aHeight,bHeight,cHeight;

    private static int num;

    public static Triangle getTriangle() {
        if (num<3) {
            num++;
            return new Triangle();
        }else {
            System.out.println("最多只能创建三个三角形！");
        }
        return null;
    }

    public static Triangle getTriangle(double a,double b,double c) {
        if (num<3) {
            if(isTriangle(a,b,c)) {
                num++;
                return new Triangle(a,b,c);
            }
            System.out.println("三角形不符合规范");
        }else {
            System.out.println("最多只能创建三个三角形！");
        }
        return null;
    }

    public static Triangle getTriangle(double di,double diHeight) {
        if (num<3) {
            num++;
            return new Triangle(di,diHeight);
        }else {
            System.out.println("最多只能创建三个三角形！");
        }
        return null;
    }

    private static boolean isTriangle(double a,double b,double c) {
        if(a+b>c && b+c>a && a+c>b && a>0 && b>0 && c>0) {
            return true;
        }
        return false;
    }

    private Triangle () {
        a=0;
        b=0;
        c=0;
        aHeight=0;
        bHeight=0;
        cHeight=0;
    }
    private Triangle(double a,double b,double c) {
            this.a=a;
            this.b=b;
            this.c=c;
    }
    private Triangle(double di,double diHeight) {
        this.a=di;
        this.aHeight=diHeight;
    }


    //修改三边的值
    public void setBian(double a,double b,double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //修改三边上的高的值
    public void setHeight(double aHeight,double bHeight,double cHeight) {
        this.aHeight = aHeight;
        this.bHeight = bHeight;
        this.cHeight = cHeight;
    }

    public double getArea() {
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public double getArea2() {
        return a*aHeight/2;
    }

    public void show() {
        System.out.println("该三角形长为："+a+" 宽为："+b+" 高为："+c+" 面积为："+getArea());
    }
    public void show2() {
        System.out.println("该三角形一边为："+a+" 该边上的高为：" + aHeight +" 面积为:"+getArea2());
    }

}
