package ru.lashin.spring.beans.beanPostProcessors;

import java.util.Random;

public class RandomIntFactory {
    Integer random() {
        Random random = new Random();
        return random.nextInt(100);
    }
}
