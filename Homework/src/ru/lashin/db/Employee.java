package ru.lashin.db;

public class Employee {
    @Column(columnName = "ID")
    private int id;
    @Column(columnName = "NAME")
    private String name;
    @Column(columnName = "DEPARTMENTID")
    private int depId;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", depId=" + depId +
                '}';
    }
}
