package ru.lashin.spring.beans.beanPostProcessors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.lashin.basic.Student;

import java.util.Random;

@Configuration
public class ProcessorsConfig {

    @Bean
    public static ControlNameBeanPostProcessor controlNameBeanPostProcessor() {
        return new ControlNameBeanPostProcessor();
    }

    @Bean
    public Integer random() {
        Random random = new Random();
        return random.nextInt(10);
    }

    @Bean
    public static ToStringBeanPostProcessor toStringBeanPostProcessor() {
        return new ToStringBeanPostProcessor();
    }

    @Bean
    public static RandomBeanFactoryPostProcessor randomBeanFactoryPostProcessor() {
        return new RandomBeanFactoryPostProcessor();
    }

    @Bean
    public RandomIntFactory randomIntFactory() {
        return new RandomIntFactory();
    }
}
