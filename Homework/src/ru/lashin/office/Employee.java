package ru.lashin.office;

public class Employee {
    final String name;
    Department department;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if (department == this.department) return;
        if (this.department != null)
            this.department.removeEmployee(this);
        department.employees.add(this);
        this.department = department;
    }

    @Override
    public String toString() {
        if (department == null)
            return name + " не работает";
        if (this == department.getBoss())
            return name + ", начальник отдела " + department.getName();
        return name + ", " + department;
    }
}

