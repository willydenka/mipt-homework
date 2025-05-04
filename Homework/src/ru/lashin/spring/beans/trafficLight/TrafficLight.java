package ru.lashin.spring.beans.trafficLight;

public interface TrafficLight {
    void setState(LightState lightState);
    void next();
}
