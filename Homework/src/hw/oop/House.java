package hw.oop;
/*
Создайте сущность Дом, которая описывается одним параметром:
•	Количество этажей: целое число
 У Дома можно запросить текстовую форму, которое имеет представление
 вида “дом с N этажами”, где N это число. Гарантировать правильное
 окончание фразы, в зависимости от количества этажей.
 Создать и вывести на экран дома с 1, 5, 23 этажами.
 */
public class House {
   private final int numberOfFloors;

    // 1.4.4 + 1.6.1
    public House(int numberOfFloors) {
        if (numberOfFloors <= 0)
            throw new IllegalArgumentException("Количество этажей должно быть больше нуля");
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        String text;
        if (numberOfFloors%10 == 1 && numberOfFloors%100 != 11)
            text = "Дом с " + numberOfFloors + " этажом";
        else {
            text = "Дом с " + numberOfFloors + " этажами";
        }
        return text;
    }
}
