package ru.lashin.geometry;

import ru.lashin.methods.Lengthable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Polyline implements Lengthable {
    ArrayList<Point> points;

    public Polyline(Point... points) {
        this.points = new ArrayList<>();
        this.points.addAll(Arrays.asList(points));
    }

    public ArrayList<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public void addPoints(Point... points) {
        this.points.addAll(Arrays.asList(points));
    }

    @Override
    public double length() {
        double res = 0;
        for (int i = 0; i < points.size()-1; i++)
            res += points.get(i).distanceTo(points.get(i+1));
        return res;
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polyline polyline)) return false;

        ArrayList<Line<Point>> thisLines = pointsToLine(getPoints());
        ArrayList<Line<Point>> objectLines = pointsToLine(polyline.getPoints());
        if (thisLines.size() != objectLines.size()) return false;
        for (Line<Point> line : thisLines)
            if (!objectLines.contains(line)) return false;
        return true;
    }

    private ArrayList<Line<Point>> pointsToLine(ArrayList<Point> points) {
        ArrayList<Line<Point>> lines = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            Point startPoint = points.get(i);
            Point endPoint = points.get(i+1);
            Line<Point> lineToAdd = Line.of(startPoint, endPoint);
            if (startPoint.equals(endPoint) || lines.contains(lineToAdd)) continue;
            lines.add(lineToAdd);
        }
        return lines;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}