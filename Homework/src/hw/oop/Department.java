package hw.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class Department {
    private final String name;
    private Employee chief;
    private final ArrayList<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            employee.setDepartment(this);
        }
    }

    public void setChief(Employee chief) {
        if (!employees.contains(chief))
            addEmployee(chief);
        this.chief = chief;
    }

    public String getName() {
        return name;
    }

    public Employee getChief() {
        return chief;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        String name = this.name;
        if (name == null || name.isBlank())
            name = "непонятно что";
        if (chief == null)
            return name + ", без начальника";

        String chiefName = this.chief.getName();
        if (chiefName == null || chiefName.isBlank())
            chiefName = "непонятно кто";
        return name + ", начальник которого " + chiefName;
    }
}
