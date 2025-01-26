package ru.lashin.geometry;

public class Rectangle extends Shape {
    private final double sideX;
    private final double sideY;
    private final boolean isSquare;

    public Rectangle(double side) {
        this.sideX = side;
        this.sideY = side;
        isSquare = true;
    }
    public Rectangle(double sideX, double sideY) {
        this.sideX = sideX;
        this.sideY = sideY;
        isSquare = sideX == sideY;
    }

    @Override
    public double area() {
        return sideX * sideY;
    }

    public boolean isSquare() {
        return isSquare;
    }
}
