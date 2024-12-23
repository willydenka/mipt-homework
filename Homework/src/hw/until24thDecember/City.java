package hw.until24thDecember;

import java.util.Arrays;

/*
Создайте сущность Город, которая будет представлять собой точку на карте со следующими характеристиками:
•	Название города
•	Набор путей к следующим городам, где путь представляет собой сочетание Города и стоимости поездки в него.
Кроме того, Город может возвращать текстовое представление, в виде названия города и списка связанных с ним городов
(в виде пары: “название: стоимость”).
Используя разработанную сущность реализуйте схему, представленную на рисунке
 */
public class City {
    String name;
    Way[] ways;


    public City() {}

    // 1.4.8
    public City(String name, Way[] ways) {
        this(name);
        this.ways = ways;
    }

    public City(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (ways == null) return name;
        return "Город " + name + ", связанные города: " + Arrays.toString(ways);
    }
}
