package ru.lashin.geometry;

import ru.lashin.methods.Lengthable;

import java.util.Objects;

/*
Создайте сущность Линия, расположенную на двумерной плоскости, которая описывается:
•	Координата начала: Точка
•	Координата конца: Точка
•	Может возвращать текстовое представление вида “Линия от {X1;Y1} до {X2;Y2}”
Для указания координат нужно использовать сущность Точка, разработанную в примере 1.1.1. Создайте линии со следующими характеристиками:
1.	Линия 1 с началом в т. {1;3} и концом в т.{23;8}.
2.	Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25.
3.	Линия 3, которая начинается всегда там же где начинается линия 1, и заканчивается всегда там же,
где заканчивается линия 2. Таким образом, если положение первой или второй линии меняется, то меняется и третья линия.
4.	После создания всех трех объектов измените координаты первой и второй линий, причем сделайте это таким образом,
чтобы положение третьей линии соответствовало требованиям пункта 3.
5.	Измените координаты первой линии так, чтобы при этом не изменились, координаты третьей линии.
 */
public class Line implements Lengthable {
    private Point startPoint;
    private Point endPoint;

    // 1.4.2 + 1.6.6 Две любые линии не могут ссылаться на один и тот же объект точки
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = new Point(startPoint); // Копирование объекта через копирующий конструктор
        this.endPoint = new Point(endPoint);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y2), new Point(x2, y2));
    }

    public Point getStartPoint() {
        return startPoint; // Возвращаем изменяемый объект специально, чтобы можно было изменять линию
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = new Point(startPoint);
    }

    public Point getEndPoint() {
        return endPoint; // Возвращаем изменяемый объект специально, чтобы можно было изменять линию
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = new Point(endPoint);
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
        Line line = (Line) o;
        return  (startPoint.equals(line.startPoint) && endPoint.equals(line.endPoint)
            || startPoint.equals(line.endPoint) && endPoint.equals(line.startPoint));
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }
}

