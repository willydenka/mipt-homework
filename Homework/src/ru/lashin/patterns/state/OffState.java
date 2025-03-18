package ru.lashin.patterns.state;

public class OffState implements State {
    private static OffState instance;

    public static OffState getInstance() {
        if (instance == null) instance = new OffState();
        return instance;
    }
    private OffState() {}

    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.setState(GreenState.getInstance());
    }

    @Override
    public void make() {
        System.out.println("Светофор не работает");
    }
}
