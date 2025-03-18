package ru.lashin.patterns.state;

public class GreenState implements State{
    private static GreenState instance;

    public static GreenState getInstance() {
        if (instance == null) instance = new GreenState();
        return instance;
    }
    private GreenState() {}

    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.setState(YellowState.getInstance());
    }

    @Override
    public void make() {
        System.out.println("Сейчас горит зеленый свет");
    }
}
