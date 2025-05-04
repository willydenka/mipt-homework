package ru.lashin.spring.beans.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;

public class GreenState extends LightState {

    @Autowired
    public GreenState(String color, LightState nextState) {
        super(color, nextState);
    }

    @Override
    public void goToNextState(TrafficLight trafficLight) {
        trafficLight.setState(super.nextState);
    }

    @Override
    public void lightUp() {
        super.lightUp();
    }
}
