package ru.lashin.spring.beans.observer;


public class Printer implements Subscriber {

    @Override
    public void subscribe(Stock stock) {
        stock.subscribe(this);
    }

    @Override
    public void update(String name, int price) {
        System.out.println("Акция " + name + " изменила стоимость на " + price);
    }
}
