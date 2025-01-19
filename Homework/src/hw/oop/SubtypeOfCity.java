package hw.oop;

public class SubtypeOfCity extends City{

    public SubtypeOfCity(String name) {
        super(name);
    }

    public SubtypeOfCity(String name, Way... ways) {
        super(name, ways);
    }

    @Override
    public void addWay(Way... ways) {
        for (Way w : ways)
            setWaysFromArray(w); // // 1.6.9
    }
    @Override
    protected void setWaysFromArray(Way way) {
        for (Way w : super.ways) {
            if (w.getCity().equals(way.getCity())) {
                w.setPrice(way.getPrice());
                return;
            }
        }
        super.ways.add(way);
        way.getCity().addWay(new Way(new City(super.name), way.getPrice()));
    }
}