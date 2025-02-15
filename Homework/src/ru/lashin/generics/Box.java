package ru.lashin.generics;

public class Box<T> {
    T t;


    public T getValue() {
        T t2 = t;
        t = null;
        return t2;
    }

    public void setValue(T t) {
        if (this.t != null) throw new IllegalArgumentException("Коробка не пуста");
        this.t = t;
    }

    public boolean isEmpty() {
        return t == null;
    }
}