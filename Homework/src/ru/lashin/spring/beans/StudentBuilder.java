package ru.lashin.spring.beans;

import ru.lashin.basic.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentBuilder {
    private final ArrayList<Integer> marks = new ArrayList<>();
    private final Predicate<Integer> rule;

    public StudentBuilder(Predicate<Integer> rule) {
        this.rule = rule;
    }


    public StudentBuilder setMarks(int ... marks) {
        for (int mark : marks) this.marks.add(mark);
        return this;
    }

    public Student build(String name) {
        int [] vararg = new int[marks.size()];
        for (int i = 0; i < marks.size(); i++)
            vararg[i] = marks.get(i);
        return new Student(name, rule, vararg);
    }
}
