package ru.lashin.basic;

import java.util.Objects;

public class Way {
    private final City city;
    private int price;

    public Way(City city, int price) {
        this.city = city;
        this.price = price;
    }

    public City getCity() {
        return city;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Way way = (Way) o;
        return city.name.equals(way.city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(city);
    }
}
