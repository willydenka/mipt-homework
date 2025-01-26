package ru.lashin.geometry;

public class ClosedPolyline extends Polyline {

    public ClosedPolyline(Point... points) {
        super(points);
    }

    @Override
    public double length() {
        Point startPoint = points.getLast();
        Point endPoint = points.getFirst();
           double res = Math.sqrt(Math.pow(endPoint.x - startPoint.x, 2) + Math.pow(endPoint.y - startPoint.y, 2));
        return super.length() + res;
    }
}

