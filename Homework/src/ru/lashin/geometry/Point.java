package ru.lashin.geometry;

import java.util.Objects;

/*
Создайте сущность Точка, расположенную на двумерной плоскости, которая описывается:
•	Координата Х: целое число
•	Координата Y: целое число
•	Может возвращать текстовое представление вида “{X;Y}”
Необходимо создать три точки с разными координатами и вывести на экран их текстовое представление.
 */
public sealed class Point permits Point3d {
    int x;
    int y;

    public Point(Point point) {
        this(point.x, point.y);
    }

    // 1.4.1
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
}
