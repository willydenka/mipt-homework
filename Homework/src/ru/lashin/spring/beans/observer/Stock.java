package ru.lashin.spring.beans.observer;

public interface Stock {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers();
}
