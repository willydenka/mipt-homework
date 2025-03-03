package ru.lashin.patterns;

import java.util.*;

interface State {
    void next(TrafficLight trafficLight);
    void make();
    void on(TrafficLight trafficLight);
    void off(TrafficLight trafficLight);
}

public class TrafficLight {
    State state;

    public void make() {
        state.make();
    }
    public void next() {
        state.next(this);
    }

    public void off() {
        state.off(this);
    }

    public void on() {
        state.on(this);
    }
}
