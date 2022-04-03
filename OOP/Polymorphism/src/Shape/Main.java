package Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(3.0);
        Shape rectangle = new Rectangle(2.0, 4.0);

        List<Shape> list = new ArrayList<Shape>();
        list.add(circle);
        list.add(rectangle);

        for(Shape shape: list){
            System.out.println(shape.getPerimeter());
            System.out.println(shape.getArea());
        }
    }
}
