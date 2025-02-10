package ru.lashin.basic;
import ru.lashin.myExceptions.MarkException;

import java.util.ArrayList;
import java.util.Objects;

public class Student implements Comparable<Student> {
     private final String name;
     private final ArrayList<Integer> marks = new ArrayList<>();
     private final Rule rule;


    public Student(String name, Rule rule, int... marks) {
        for (int mark : marks) {
            if (rule != null && !rule.check(mark)) exception();
            this.marks.add(mark);
        }
        this.name = name;
        this.rule = rule;
    }

    public Student(String name, int... marks) {
        this(name, null, marks);
    }

    public void addMark(int mark) {
        if (rule != null && !rule.check(mark)) exception();
        marks.add(mark);
    }

    public void deleteLastMark() {
        marks.removeLast();
    }

    public ArrayList<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    public String getName() {
        return name;
    }

    // 1.5.6
    public double averageValue() {
        if (marks.isEmpty())
            return 0;
        double res = 0;
        for (int mark : marks) {
            res = res + mark;
        }
        return res / marks.size();
    }

    // 1.5.6
    public boolean isExcellent() {
        if (!marks.isEmpty()) {
            for (int mark : marks) {
                if (mark != 5)
                    return false;
            }
            return true;
        }
        return false;
    }

    private void exception() {
        throw new MarkException(name);
    }

    @Override
    public String toString() {
        if (!marks.isEmpty())
            return name + ": " + marks;
        return name + " без оценок";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return this.averageMark() == student.averageMark() && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, marks, rule);
    }

    private double averageMark() {
        int sum = 0;
        for (int mark : marks)
            sum+=mark;
        return (double) sum/marks.size();
    }

    @Override
    public int compare(Student other) {
        if (averageMark() > other.averageMark()) return 1;
        if (averageMark() < other.averageMark()) return -1;
        return 0;
    }
}


