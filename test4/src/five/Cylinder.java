package five;

//圆柱体类
public class Cylinder {
    double radius;
    double height;

    public Cylinder() {
    }

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //内部圆类
    public class Circle {
        //得到周长
        public double getPerimeter() {
            return 2*3.14*radius;
        }
        //返回面积
        public double getArea() {
            return 3.14*Math.pow(radius,2);
        }
    }

    public double getSurfaceArea() {
        Circle circle = new Circle();
        return circle.getPerimeter()*height;
    }

    public double getVolume() {
        Circle circle = new Circle();
        return height*circle.getArea();
    }

}
