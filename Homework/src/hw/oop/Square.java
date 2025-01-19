package hw.oop;
// 1.5.8
public class Square extends PolylineGet {
    Point upperLeftCorner;
    private int sideLength;

    public Square(Point upperLeftCorner, int sideLength) {
        if (sideLength <= 0)
            exception();
        this.upperLeftCorner = upperLeftCorner;
        this.sideLength = sideLength;
    }

    public Square(int x, int y, int sideLength) {
        this(new Point(x, y), sideLength);
    }

    public void setSideLength(int sideLength) {
        if (sideLength <= 0)
            exception();
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }


    public Polyline getPolyline() {
        Polyline polyline = new ClosedPolyline(upperLeftCorner);// 2.3.6
        polyline.addPoints(
                new Point(upperLeftCorner.x + sideLength, upperLeftCorner.y), // правый верхний угол
                new Point(upperLeftCorner.x + sideLength, upperLeftCorner.y - sideLength), // правый нижний угол
                new Point(upperLeftCorner.x, upperLeftCorner.y - sideLength)); // // левый нижний угол
        return polyline;
    }
    @Override
    public String toString() {
        return "Квадрат в точке " + upperLeftCorner + " со стороной " + sideLength;
    }

    private void exception() {
        throw new IllegalArgumentException("Сторона квадрата не может равняться нулю или отрицательному значению");
    }
}
