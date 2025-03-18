package ru.lashin.patterns.state;

public class YellowState implements State{
    private static YellowState instance;

    public static YellowState getInstance() {
        if (instance == null) instance = new YellowState();
        return instance;
    }
    private YellowState() {}

    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.setState(ReadState.getInstance());
    }

    @Override
    public void make() {
        System.out.println("Сейчас горит желтый свет");
    }
}
