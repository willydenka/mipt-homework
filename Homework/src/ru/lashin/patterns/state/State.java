package ru.lashin.patterns.state;

interface State {
    void next(TrafficLight trafficLight);

    void make();

    default void on(TrafficLight trafficLight) {
        trafficLight.setState(GreenState.getInstance());
    };

   default void off(TrafficLight trafficLight) {
       trafficLight.setState(OffState.getInstance());
   };
}
