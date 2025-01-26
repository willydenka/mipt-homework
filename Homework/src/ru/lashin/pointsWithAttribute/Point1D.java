package ru.lashin.pointsWithAttribute;

public class Point1D extends UniversalPoint {
    private final int x;

    public Point1D(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Point1D{" +
                "x=" + x +
                '}';
    }
}