package ru.lashin.patterns.state;

public class TrafficLight {
    State state;
    public TrafficLight(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

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
