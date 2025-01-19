package hw.oop.points;

public class Point3d extends Point2d {
    private final int z;

    public Point3d(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3d(int x, int y, int z, String color) {
        super(x, y, color);
        this.z = z;
    }

    public Point3d(int x, int y, int z, String color, int size) {
        super(x, y, color, size);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        String res = "Точка " + getX() + ";" + getY() + ";" + this.z;
        if (getColor() != null) res+= ", цвета " + getColor();
        if (getSize() != 0) res+= ", размером " + getSize();
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Point2d point2d = new Point2d(3,5, "синяя", 5);
        System.out.println(point2d);
    }
}
