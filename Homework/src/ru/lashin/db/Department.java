package ru.lashin.db;

public class Department {
    @Column(columnName = "ID")
    private int id;
    @Column(columnName = "NAME")
    private String name;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
