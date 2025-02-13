package ru.lashin.geometry;

import ru.lashin.methods.Lengthable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/*
Создайте сущность Ломаная, которая будет представлять собой ломаную линию.
Ломаная линия представляет собой набор следующих характеристик:
•	Имеет массив Точек (из задачи 1.1.1), через которые линия проходит.
•	Может быть приведена к строковой форме вида “Линия [Т1,T2,…,TN]”,
где TN – это результат приведения к строке Точки с номером N
Необходимо выполнить следующие задачи:
1.	Создать первую Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}
2.	Создайте вторую Ломаную, чья первая и последняя Точка совпадает с таковыми у первой Ломаной,
но в качестве середины имеет точки: {2,-5}, {4,-8}
3.	Сдвиньте начало первой Ломаной таким образом, чтобы одновременно сдвинулось начало второй Ломаной.
 */
public class Polyline implements Lengthable {
    ArrayList<Point> points;

    // 1.4.3
    public Polyline(Point... points) {
        this.points = new ArrayList<>();
        this.points.addAll(Arrays.asList(points));
    }

    public ArrayList<Point> getPoints() {
        return new ArrayList<>(points);
    }

    // 1.5.7
    public void addPoints(Point... points) {
        this.points.addAll(Arrays.asList(points));
    }

    @Override
    public double length() {
        double res = 0;
        for (int i = 0; i < points.size()-1; i++) {
            Point startPoint = points.get(i); // Берем первую точку
            Point endPoint = points.get(i+1); // Берем вторую точку
            res = res + Math.sqrt(Math.pow(endPoint.x - startPoint.x, 2) + Math.pow(endPoint.y - startPoint.y, 2)); // Считаем длину линии
        } // И фиксируем длину первой линии, так делаем с каждой линией и суммируем их
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
        ArrayList<Point> thisPoints = this.getPoints();
        ArrayList<Point> objectPoints = polyline.getPoints();
        if (getClass() == ClosedPolyline.class) thisPoints.add(thisPoints.getFirst());
        if (polyline.getClass() == ClosedPolyline.class) objectPoints.add(objectPoints.getFirst());
        ArrayList<Line> thisLines = pointsToLine(thisPoints);
        ArrayList<Line> objectLines = pointsToLine(objectPoints);
        if (thisLines.size() != objectLines.size()) return false;
        for (Line line : thisLines)
            if (!objectLines.contains(line)) return false;
        return true;
    }

    private ArrayList<Line> pointsToLine(ArrayList<Point> points) {
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            lines.add(new Line(points.get(i), points.get(i+1)));
        }
        return lines;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}