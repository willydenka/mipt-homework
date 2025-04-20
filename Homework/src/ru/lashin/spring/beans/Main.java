package ru.lashin.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lashin.basic.Student;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println(context.getBean("hello"));
        System.out.println("----");
        System.out.println(context.getBean("random"));
        System.out.println(context.getBean("random"));
        System.out.println(context.getBean("random"));
        System.out.println(context.getBean("random"));
        System.out.println("----");
        System.out.println(context.getBean("start"));
        System.out.println(context.getBean("start"));
        System.out.println("----");



        System.out.println("Лучшая оценка: " + context.getBean("bestFeedback"));
        System.out.println("----");
        System.out.println(context.getBean("student1"));
        Student stu = context.getBean("student2", Student.class);
        System.out.println(context.getBean("student2"));
        System.out.println("----");
        StudentBuilder studentBuilder = context.getBean("studentBuilder", StudentBuilder.class);
        System.out.println(studentBuilder.setMarks().build("Васька"));
        System.out.println(studentBuilder.setMarks(4,3).build("Колька"));

        Data data = context.getBean("date", Data.class);
        data.write();


    }
}
