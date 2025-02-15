package ru.lashin.geometry;

import ru.lashin.methods.Lengthable;


public class Line<T extends Point> implements Lengthable {
    private Point startPoint;
    private Point endPoint;


    private Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint.clone();
        this.endPoint = endPoint.clone();
    }

    public static<T extends Point> Line<T> of(T startPoint, T endPoint) { // статическая фабрика
        return new Line<>(startPoint, endPoint);
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(T startPoint) {
        this.startPoint = startPoint.clone();
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(T endPoint) {
        this.endPoint = endPoint.clone();
    }

    @Override
    public double length() {
        return startPoint.distanceTo(endPoint);
    }

    @Override
    public String toString() {
        return "Линия от " + startPoint + " до " + endPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line<?> line = (Line<?>) o;
        return  (startPoint.equals(line.startPoint) && endPoint.equals(line.endPoint)
            || startPoint.equals(line.endPoint) && endPoint.equals(line.startPoint));
    }

    @Override
    public int hashCode() {
        return startPoint.hashCode() + endPoint.hashCode();
    }

    public Line<T> clone() {
        try {
            Line<T> line = (Line<T>) super.clone();
            line.startPoint = (T) this.startPoint.clone();
            line.endPoint = (T) this.endPoint.clone();
            return line;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
