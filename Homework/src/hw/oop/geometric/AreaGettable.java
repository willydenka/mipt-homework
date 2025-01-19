package hw.oop.geometric;
// 2.3.3
public interface AreaGettable {
    static double getArea(Shape shape) {
        return shape.area();
    }
}
