package five;

public class CylinderDemo {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(10,20);
        System.out.println("表面积为："+cylinder.getSurfaceArea());
        System.out.println("体积为:"+cylinder.getVolume());
    }
}
