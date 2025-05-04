package ru.lashin.spring.beans.trafficLight;

public class PreYellowState extends LightState {

    public PreYellowState(String color, LightState nextState) {
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
