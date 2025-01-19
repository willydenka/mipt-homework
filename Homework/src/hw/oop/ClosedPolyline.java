package hw.oop;

public class ClosedPolyline extends Polyline {

    public ClosedPolyline(Point... points) {
        super(points);
    }

    @Override
    public double getLen() {
        double res = 0;
        for (int i = 0; i < points.size()-1; i++) {
            Point startPoint = points.get(i);
            Point endPoint = points.get(i+1);
            if (i == points.size()-2) { // Когда дошли до конца, цепляем к последней точке первую и считаем расстояние
                startPoint = points.get(i+1);
                endPoint = points.getFirst();
            }
            res = res + Math.sqrt(Math.pow(endPoint.x - startPoint.x, 2) + Math.pow(endPoint.y - startPoint.y, 2));
        }
        return res;
    }
}