package ru.lashin.spring.beans.observer;


public class Bot implements Subscriber {

    @Override
    public void subscribe(Stock stock) {
        stock.subscribe(this);
    }

    @Override
    public void update(String name, int price) {
        if (name.equals("ORCL") && price < 70) System.out.println("Надо покупать акции");
    }
}
