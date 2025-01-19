package hw.oop;

public abstract class PolylineGet {
    abstract Polyline getPolyline();
}

interface MultiPolylineGettable {
    static Polyline getMultiPolyline(PolylineGet... polylineGet) {
        Polyline polylineRes = new Polyline();
        for (PolylineGet polyline : polylineGet) {
            int quantityOfPoints = polyline.getPolyline().points.size();
            for (int i = 0; i < quantityOfPoints; i++) {
                polylineRes.points.add(polyline.getPolyline().points.get(i));
            }
        }
        return polylineRes;
    }
}