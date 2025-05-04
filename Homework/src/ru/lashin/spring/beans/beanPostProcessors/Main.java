package ru.lashin.spring.beans.beanPostProcessors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lashin.basic.Student;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProcessorsConfig.class);

        System.out.println(context.getBean("random"));
    }
}
