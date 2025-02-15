package ru.lashin.geometry;

import java.util.Objects;

public sealed class Point implements Cloneable permits Point3d {
    public int x;
    public int y;

    public Point(Point point) {
        this(point.x, point.y);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point end) {
        return Math.sqrt(Math.pow(end.x - this.x, 2) + Math.pow(end.y - this.y, 2));
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
       return Objects.hash(x, y);
    }

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
