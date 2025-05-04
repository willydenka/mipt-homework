package ru.lashin.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import ru.lashin.basic.Student;
import ru.lashin.spring.beans.observer.Bot;
import ru.lashin.spring.beans.observer.Printer;
import ru.lashin.spring.beans.observer.Subscriber;
import ru.lashin.spring.beans.observer.Tsla;
import ru.lashin.spring.beans.streamPlatform.Data;
import ru.lashin.spring.beans.trafficLight.*;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Configuration
public class MainConfig {
    Set<Integer> cacheRandom; // Кэш для рандомных чисел


    @Bean
    public String hello() {
        return "hello world";
    }

    @Bean
    @Scope("prototype")
    public int random(@Qualifier(value = "max") int max, @Qualifier(value = "min") int min) {
        if (cacheRandom == null) cacheRandom = new HashSet<>(); // Создаем кэш, если не было
        Random random = new Random();
        if (cacheRandom.size() == max-min+1) cacheRandom.clear(); // Если кэш заполнился, чистим
        int res = random.nextInt(max-min+1) + min;
        if (cacheRandom.contains(res)) { // Если уже есть значение, то надо взять другое
            res = random(max, min);
        }
        cacheRandom.add(res);
        return res;
    }

    @Bean
    public Date start() {
        return new Date();
    }

    @Bean
    public Predicate<Integer> range() {
        return x -> x >=2 && x <= 5;
    }

    @Bean
    @Qualifier(value = "min")
    public int min() {
        return 2;
    }

    @Bean
    @Qualifier(value = "max")
    public int max() {
        return 5;
    }

    @Bean
    public Feedback feedbackGood() {
        return new Feedback(4, "Очень хорошо");
    }


    @Bean
    public Feedback feedbackOk() {
        return new Feedback(3, "Сойдет");
    }

    @Bean
    public Feedback feedbackQuestion(@Autowired @Qualifier("random") int random) {
        return new Feedback(random, "Сложно сказать");
    }

    @Bean
    public Feedback bestFeedback(@Autowired Feedback... feedbacks) {
        Feedback max = feedbacks[0];
        for (int i = 1; i < feedbacks.length; i++)
            if (feedbacks[i].mark > max.mark) max = feedbacks[i];
        return max;
    }

    @Bean
    public Student student1(@Qualifier("range") Predicate<Integer> range) {
        return new Student("Петя", range, 4,3,2);
    }

    @Bean
    public Student student2(@Qualifier("range") Predicate<Integer> range) {
        return new Student("Вася", range, 5,4,2);
    }

    @Bean
    public StudentBuilder studentBuilder(@Qualifier("range") Predicate<Integer> range) {
        return new StudentBuilder(range);
    }

    @Bean
    public Data starter(@Autowired List<Consumer<List<String>>> actions) {
        return new Data(actions);
    }

    @Bean
    @Order(1)
    public Consumer<List<String>> toUpperCase() {
        return list -> list.replaceAll(String::toUpperCase);
    }

    @Bean
    @Order(2)
    public Consumer<List<String>> removeA() {
        return list -> list.replaceAll(line -> line.replaceAll("[AА]", ""));
    }

    @Bean
    @Order(3)
    public Consumer<List<String>> strLessFour() {
        return list -> list.replaceAll(line -> Arrays.stream(line.split("\\s+"))
                .filter(w -> w.length() > 4).collect(Collectors.joining(" ")));
    }

    @Bean
    public TrafficLight trafficLight(@Autowired @Qualifier("green") LightState startState) {
        return new TrafficLightImpl(startState);
    }

    @Bean
    public LightState green(@Lazy @Autowired @Qualifier("preYellow") LightState lightState) {
        return new GreenState("Зеленый", lightState);
    }

    @Bean
    public LightState preYellow(@Autowired @Qualifier("red") LightState lightState) {
        return new PreYellowState("Желтый", lightState);
    }

    @Bean
    public LightState postYellow(@Autowired @Qualifier("green") LightState lightState) {
        return new PostYellow("Желтый", lightState);
    }

    @Bean
    public LightState red(@Autowired @Qualifier("postYellow") LightState lightState) {
        return new RedState("Красный", lightState);
    }

    @Bean
    public Subscriber printer() {
        Subscriber printer = new Printer();
        printer.subscribe(new Tsla("TSLA", 50));
        return printer;
    }

    @Bean
    public Subscriber bot() {
        Subscriber bot = new Bot();
        bot.subscribe(new Tsla("TSLA", 103));
        return bot;
    }

}
