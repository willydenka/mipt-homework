package hw.oop;

import java.util.ArrayList;


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
    protected final ArrayList<Way> ways = new ArrayList<>();;


    public City(String name) {
        this.name = name;
    }

    // 1.4.8 + 1.6.9
    public City(String name, Way... ways) { //
        this(name);
        for (Way w : ways)
            setWaysFromArray(w); // 1.6.9
    }

    public void addWay(Way... ways) {
        for (Way w : ways)
            setWaysFromArray(w); // // 1.6.9
    }

    // 1.6.9
    protected void setWaysFromArray(Way way) {
        for (Way w : this.ways) { // Проверяем, не ведет ли переданный путь к городу, к которому у нас уже есть путь
            if (w.getCity().equals(way.getCity())) { // Если ведет, то
                w.setPrice(way.getPrice()); // Обновляем стоимость
                return; // Выходим из метода
            }
        }
        this.ways.add(way); // Если пути в такой город нет, то просто добавляем его
    }

    public void deleteWay(Way way) {
        if (!this.ways.contains(way))
            return;
        this.ways.remove(way);
    }

    public ArrayList<Way> getWays() {
        return new ArrayList<>(ways);
    }

    @Override
    public String toString() {
        if (ways.isEmpty()) return name;
        return "Город " + name + ", связанные города: " + ways;
    }
}



