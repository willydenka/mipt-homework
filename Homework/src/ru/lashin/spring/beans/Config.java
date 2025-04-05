package ru.lashin.spring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import java.util.Date;
import java.util.Random;
import java.util.function.Predicate;

@Configuration
public class Config {

    @Bean
    public String hello() {
        return "hello world";
    }

    @Bean
    @Scope("prototype")
    public int random() {
        Random random = new Random();
        return random.nextInt(100);
    }

    @Bean
    @Scope("singleton")
    public Date start() {
        return new Date();
    }

    @Bean
    public Predicate<Integer> range() {
        return x -> x >=2 && x <= 5;
    }

    @Bean
    public int min() {
        return 0;
    }

    @Bean int max() {
        return 1;
    }
}
