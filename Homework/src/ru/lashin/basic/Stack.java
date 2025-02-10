package ru.lashin.basic;

import java.util.ArrayList;

public class Stack<T> {
    private final ArrayList<T> list = new ArrayList<>();

    public void push(T t) {
        list.add(t);
    }

    public T pop() {
        if (list.isEmpty()) emptyStack();
        return list.removeLast();
    }

    public T peek() {
        if (list.isEmpty()) emptyStack();
        return list.getLast();
    }

    private void emptyStack() {
        throw new IllegalArgumentException("Стек пуст");
    }
}
