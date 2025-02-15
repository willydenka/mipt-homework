package ru.lashin.generics;

public class Storage<T> {
    private final T t;


    public Storage(T t) {
        this.t = t;
    }

    public T getValue(T defaultValue) {
        return t == null ? defaultValue : t;
    }
}
