package ru.lashin.spring.beans.trafficLight;

public abstract class LightState {

//    GREEN("Зелёный") {
//        @Override
//        public void goToNextState(TrafficLight trafficLight) {
//            trafficLight.setState(PRE_YELLOW);
//        }
//    },
//    PRE_YELLOW("Жёлтый") {
//        @Override
//        public void goToNextState(TrafficLight trafficLight) {
//            trafficLight.setState(RED);;
//        }
//    },
//    RED("Красный") {
//        @Override
//        public void goToNextState(TrafficLight trafficLight) {
//            trafficLight.setState(POST_YELLOW);;
//        }
//    },
//    POST_YELLOW("Жёлтый") {
//        @Override
//        public void goToNextState(TrafficLight trafficLight) {
//            trafficLight.setState(GREEN);;
//        }
//    };


    protected final String color;
    protected final LightState nextState;

    public LightState(String color, LightState nextState) {
        this.color = color;
        this.nextState = nextState;
    }

    public abstract void goToNextState(TrafficLight trafficLight);

    public void lightUp() {
        System.out.println(color);
    }
}
