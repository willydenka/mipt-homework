package hw.until24thDecember;
/*
Создайте сущность Дом, которая описывается одним параметром:
•	Количество этажей: целое число
 У Дома можно запросить текстовую форму, которое имеет представление
 вида “дом с N этажами”, где N это число. Гарантировать правильное
 окончание фразы, в зависимости от количества этажей.
 Создать и вывести на экран дома с 1, 5, 23 этажами.
 */
public class House {
    int numberOfFloors; // final для невозможности изменять поле после инициализации
    // Не пишу, так как вылетят ошибки из мейна за прошлые задачи с этим объектом

    public House() {}

    // 1.4.4 Убирать пустой конструктор не буду, вылетят ошибки в мейне. Представим, что его нет. Тогда создать
    // объект можно будет только через караметризированный конструктор
    public House(int numberOfFloors) {
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
