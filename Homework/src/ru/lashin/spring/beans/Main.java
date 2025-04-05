package ru.lashin.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(context.getBean("hello"));
        System.out.println("----");
        System.out.println(context.getBean("random"));
        System.out.println(context.getBean("random"));
        System.out.println("----");
        System.out.println(context.getBean("start"));
        System.out.println(context.getBean("start"));
        System.out.println("----");


    }
}
