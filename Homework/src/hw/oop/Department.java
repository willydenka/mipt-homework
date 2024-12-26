package hw.oop;

import java.util.Arrays;

public class Department {
    String name;
    Employee chief;
    Employee[] employees; // 1.3.4

    @Override
    public String toString() {

        return "Отдел " + name + ", список сотрудников: " + Arrays.toString(employees);
    }
}
