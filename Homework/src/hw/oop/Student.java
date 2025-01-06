package hw.oop;

import java.util.Arrays;

/*
Создайте сущность Студент, которая описывается:
•	Имя: строка
•	Оценки: массив целых чисел.
•	Может возвращать текстовое представление вида “Имя: [оценка1, оценка2,…,оценкаN]”
Необходимо выполнить следующие задачи:
1.	Создать студента Васю с оценками: 3,4,5.
2.	Создать студента Петю и скопировать оценки Васи, присвоив содержимое поля с оценками Васи полю с оценками Пети.
3.	Заменить первую оценку Пети на число 5. Вывести на экран строковое представление Васи и Пети. Объяснить результат
4.	Создать студента Андрея и скопировать ему оценки Васи так, чтобы изменение оценок Васи не влияло на Андрея.
 */
public class Student {
    String name;
    private final int[] marks;


    // 1.4.7
    public Student(String name, int... marks ) {
        for (int mark : marks) { // 1.6.8
            if (mark < 2 || mark > 5)
                throw new IllegalArgumentException("Это не оценка");
        }
        this.name = name;
        this.marks = marks;
    }

    // Безопасно, так как поле marks неизменяемое
    public int[] getMarks() {
        return marks;
    }

    // 1.5.6
    public double averageValue() {
        if (marks.length == 0)
            return 0;
        double res = 0;
        for (int mark : marks) {
            res = res + mark;
        }
        return res / marks.length;
    }

    // 1.5.6
    public boolean isExcellent() {
        if (marks.length > 0) {
            for (int mark : marks) {
                if (mark != 5)
                    return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (marks.length != 0)
            return name + ": " + Arrays.toString(marks);
        return name + " без оценок";
    }
}
