package hw.until24thDecember;
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
public class Line {
    Point startPoint;
    Point endPoint;

    public Line() {}

    // 1.4.2
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Line(int x1, int y1, int x2, int y2) {
        startPoint = new Point(x1, y1);
        endPoint = new Point(x2, y2);
    }

    @Override
    public String toString() {
        return "Линия от " + startPoint + " до " + endPoint;
    }
}
