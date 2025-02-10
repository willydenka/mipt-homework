package ru.lashin.geometry;

import ru.lashin.methods.Lengthable;


public class Line<T extends Point> implements Lengthable {
    private T startPoint;
    private T endPoint;


    public Line(T startPoint, T endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

//    public Line(int x1, int y1, int x2, int y2) {
//        this(new Point(x1, y2), new Point(x2, y2));
//    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(T startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(T endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public double length() {
        double res;
        res = Math.sqrt(Math.pow(endPoint.x - startPoint.x, 2) + Math.pow(endPoint.y - startPoint.y, 2));
        return res;
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
