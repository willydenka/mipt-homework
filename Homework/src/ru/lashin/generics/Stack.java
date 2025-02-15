package ru.lashin.generics;

import java.util.ArrayList;

public class Stack<T> {
    private final ArrayList<T> list = new ArrayList<>();

    public void push(T t) {
        list.add(t);
    }

    public T pop() {
        T t = peek();
        return list.removeLast();
    }

    public T peek() {
        if (list.isEmpty()) throw new IllegalArgumentException("Стек пуст");
        return list.getLast();
    }
}
