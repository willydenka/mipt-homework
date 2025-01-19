package hw.oop.points;

/*
Технически, цвет и размер задаются в любом случае. Если они null и 0, то просто не выводятся.
 Как сделать по-другому, придумать не могу.
 */
public class Point1d {
    private final int x;
    private final String color;
    private final int size;

    public Point1d(int x) {
        this(x, null);
    }

    public Point1d(int x, String color) {
        this(x, color, 0);
    }

    public Point1d(int x, String color, int size) {
        this.x = x;
        this.color = color;
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String res = "Точка " + this.x;
        if (color != null) res+= ", цвета " + this.color;
        if (size != 0) res+= ", размером " + size;
        return res;
    }

}
