package com.five;

public class Demo {
    public static void main(String[] args) {
        IShape[] iShapes = new IShape[]{new Rectangle(10,20),new Circle(5),new Triangle(10,8),new Trapezia(10,20,8)};
        for(IShape i : iShapes) {
            System.out.println(Recognize.recognize(i));
        }
    }
}
