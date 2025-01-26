package ru.lashin.office;
import java.util.ArrayList;

public class Department {
    final String name;
    Employee boss;
    final ArrayList<Employee> employees = new ArrayList<>();


    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void addEmployee(Employee employee) {
        if (employee == null) return;
        employee.setDepartment(this);
    }

    public void setBoss(Employee boss) {
        if (boss == null) this.boss = null;
        if (boss == this.boss) return;
        boss.setDepartment(this);
        this.boss = boss;
    }


    public void removeEmployee(Employee employee) {
        if (employee == null) return;
        employees.remove(employee);
        employee.department = null;
        if (employee == boss) boss = null;
    }

    @Override
    public String toString() {
        String name = this.name;
        if (name == null || name.isBlank())
            name = "непонятно что";
        if (boss == null)
            return name + ", без начальника";

        String chiefName = this.boss.getName();
        if (chiefName == null || chiefName.isBlank())
            chiefName = "непонятно кто";
        return name + ", начальник которого " + chiefName;
    }
}