package hw.oop;
// 1.5.8
public class Square {
    Point upperLeftCorner;
    private int sideLength;

    public Square(Point upperLeftCorner, int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("Сторона квадрата не может равняться нулю или отрицательному значению");
        this.upperLeftCorner = upperLeftCorner;
        this.sideLength = sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("Сторона квадрата не может равняться нулю или отрицательному значению");
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public Square(int x, int y, int sideLength) {
        this(new Point(x, y), sideLength);
    }

    public Polyline getPolyline() {
        Polyline polyline = new Polyline(upperLeftCorner);
        polyline.addPoints(
                new Point(upperLeftCorner.x + sideLength, upperLeftCorner.y), // правый верхний угол
                new Point(upperLeftCorner.x + sideLength, upperLeftCorner.y - sideLength), // правый нижний угол
                new Point(upperLeftCorner.x, upperLeftCorner.y - sideLength)); // левый нижний угол
        return polyline;
    }
    @Override
    public String toString() {
        return "Квадрат в точке " + upperLeftCorner + " со стороной " + sideLength;
    }
}
