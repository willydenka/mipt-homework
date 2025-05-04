package ru.lashin.spring.beans.observer;

public interface Subscriber {
    void subscribe(Stock stock);
    void update(String name, int price);
}
