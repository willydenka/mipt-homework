package ru.lashin.patterns.state;

public class ReadState implements State{
    private static ReadState instance;

    public static ReadState getInstance() {
        if (instance == null) instance = new ReadState();
        return instance;
    }
    private ReadState() {}

    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.setState(GreenState.getInstance());
    }

    @Override
    public void make() {
        System.out.println("Сейчас горит красный свет");
    }
}
