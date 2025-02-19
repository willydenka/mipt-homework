package ru.lashin.generics;

import java.util.function.Supplier;

public class LazyStorage<T> {
    private static final LazyStorage empty = new LazyStorage(null);
    private Supplier<LazyStorage<T>> obj;
    private  T t;

    private LazyStorage(Supplier<LazyStorage<T>> obj){
        this.obj = obj;
    }

    private LazyStorage(T t){
        this.t = t;
    }

    public static <T> LazyStorage<T> of(Supplier<LazyStorage<T>> obj) {
        return new LazyStorage<>(obj);
    }


    public static <T> LazyStorage<T> empty() {
        return empty;
    }

    public static <T> LazyStorage<T> of(T t) {
         return new LazyStorage<>(t);
    }

    public T getValue(T defaultValue) {
        if (obj == null) return defaultValue;
        T t = obj.get().t;
        return t == null ? defaultValue : t;
    }
}

