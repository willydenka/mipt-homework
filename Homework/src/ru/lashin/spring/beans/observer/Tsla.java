package ru.lashin.spring.beans.observer;

import java.util.ArrayList;
import java.util.List;

public class Tsla implements Stock {
    private final String name;
    private int price;
    private final List<Subscriber> subscribers = new ArrayList<>();

    public Tsla(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(int price) {
        if (this.price == price) return;
        this.price = price;
        notifySubscribers();
    }

    @Override

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        subscribers.forEach(subscriber -> subscriber.update(name, price));
    }
}
