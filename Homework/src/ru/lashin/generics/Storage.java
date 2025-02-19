package ru.lashin.generics;

public class Storage<T> {
    private static Storage empty = new Storage<>(null);
    private final T t;


    private Storage(T t) {
        this.t = t;
    }

    public static <T> Storage<T> empty() {
        return empty;
    }

    public static <T> Storage<T> of(T val) {
         return new Storage<>(val);
    }

    public T getValue(T defaultValue) {
        return t == null ? defaultValue : t;
    }
}
