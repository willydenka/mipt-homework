package ru.lashin.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.lashin.basic.Student;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
    @Scope("singleton")
    public Date start() {
        return new Date();
    }

    @Bean
    @Scope(scopeName = "singleton")
    public Predicate<Integer> range() {
        return x -> x >=2 && x <= 5;
    }

    @Bean
    @Qualifier(value = "min")
    public int min() {
        return 0;
    }

    @Bean
    @Qualifier(value = "max")
    public int max() {
        return 2;
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
    public Feedback feedbackQuestion() {
        return new Feedback(random(5,1), "Сложно сказать");
    }

    @Bean
    public Feedback bestFeedback() {
        Feedback feedbackQuestion = feedbackQuestion();
        if (feedbackQuestion.mark > feedbackGood().mark) return feedbackQuestion;
        return feedbackGood();
    }

    @Bean
    public Student student1() {
        return new Student("Петя", range(), 4,3,2);
    }

    @Bean
    public Student student2() {
        return new Student("Вася", range(), 5,4,2);
    }

    @Bean
    public StudentBuilder studentBuilder() {
        return new StudentBuilder(range());
    }

    @Bean
    @Qualifier(value = "date")
    public Data date() {
        return new Data("path", "path");
    }

    @Bean
    @Qualifier(value = "toUpperCase")
    public Consumer<Data> toUpperCase(@Autowired @Qualifier(value = "date") Data d) {
         Consumer<Data> c = data ->
            data.setData(data.getData().stream().map(String::toUpperCase).toList());
        d.addAction(c);
        return c;
    }

//    @Bean
//    @Qualifier(value = "removeA")
//    public Data removeA(@Autowired @Qualifier(value = "toUpperCase") Data data) {
//        data.setData(data.getData().stream()
//                .map(s->s.replace("A","")).toList());
//        return data;
//    }
//
//    public Data write(@Autowired @Qualifier(value = "removeA") Data data) {
//        data.write();
//        return data;
//    }

}
