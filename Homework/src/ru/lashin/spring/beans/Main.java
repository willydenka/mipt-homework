package ru.lashin.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//        Data data = context.getBean(Data.class);
//        data.setPathFrom("src/ru/lashin/spring/beans/streamPlatform/FileTest.txt");
//        data.setPathTo("src/ru/lashin/spring/beans/streamPlatform/FileTestResult.txt");
//        data.executeActions();
//
//        TrafficLight trafficLight = context.getBean(TrafficLight.class);
//        for (int i = 0; i < 20; i++) {
//            trafficLight.next();
//        }

    }
}
