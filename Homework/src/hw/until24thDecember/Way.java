package hw.until24thDecember;

public class Way {
    City city;
    int price;

    public Way() {}

    @Override
    public String toString() {
        return city.name + ": " + "стоимость " + price;
    }
}
