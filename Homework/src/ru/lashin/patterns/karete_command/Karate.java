package ru.lashin.patterns.karete_command;

public class Karate {
    private final String name;

    public Karate(String name) {
        this.name = name;
    }

    public void kick() {
        System.out.println(name + " бац");
    }

    public void strike() {
        System.out.println(name + " кия");
    }

    public void jumpStrike() {
        System.out.println(name + " вжух");
    }
}
