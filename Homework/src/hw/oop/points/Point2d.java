package hw.oop.points;

public class Point2d extends Point1d {
    private final int y;

    public Point2d(int x, int y) {
        super(x);
        this.y = y;
    }

    public Point2d(int x, int y, String color) {
        super(x, color);
        this.y = y;
    }

    public Point2d(int x, int y, String color, int size) {
        super(x, color, size);
        this.y = y;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        String res = "Точка " + getX() + ";" + this.y;
        if (getColor() != null) res+= ", цвета " + getColor();
        if (getSize() != 0) res+= ", размером " + getSize();
        return res;
    }
}
