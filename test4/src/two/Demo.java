package two;

public class Demo {
    public static void main(String[] args) {
        ShapeRecIn[] shapeRecIns = {new Circle(),new Triangle()};
        for(ShapeRecIn s : shapeRecIns) {
            s.getType();
        }
        ShapeRecAb shapeRecAb = new Ti();
        shapeRecAb.getType();
    }
}
