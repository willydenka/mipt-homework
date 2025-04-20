package ru.lashin.db;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DAO dao = new DAO();
        List<Employee> employees = dao.findAll(Employee.class);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
