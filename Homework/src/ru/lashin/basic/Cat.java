package ru.lashin.basic;

import ru.lashin.methods.Meowble;

// 1.5.2
public class Cat implements Meowble {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void meow() {
        System.out.println(this.name + ": мяу!");
    }

    public void meow(int n) {
        String res = "мяу";
        if (n >= 1) {
            for (int i = 0; i < n-1; i++) {
                res += "-мяу";
            }
            System.out.println(this.name + ": " + res);
        }
        else throw new IllegalArgumentException("Кот не может мяукать меньше одного раза");
    }

    @Override
    public String toString() {
        return "Кот: " + this.name;
    }
}

