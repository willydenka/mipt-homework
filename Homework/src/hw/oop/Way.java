package hw.oop;

public class Way {
    private final City city;
    private int price;

    public Way(City city, int price) {
        this.city = city;
        this.price = price;
    }

    public String getCity() {
        return city.name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return city.name + ": " + "стоимость " + price;
    }
}
