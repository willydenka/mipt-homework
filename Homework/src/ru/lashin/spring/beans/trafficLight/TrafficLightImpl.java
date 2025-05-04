package ru.lashin.spring.beans.trafficLight;

public class TrafficLightImpl implements TrafficLight {
    private LightState currentState;

    public TrafficLightImpl(LightState currentState) {
        this.currentState = currentState;
    }

    @Override
    public void setState(LightState lightState) {
        currentState = lightState;
    }

    @Override
    public void next() {
        currentState.lightUp();
        currentState.goToNextState(this);
    }
}
