package com.five;

public class Recognize {
    public static String recognize(IShape iShape) {
        return "类型:"+iShape.getType()+"\t面积:"+iShape.getArea();
    }
}
