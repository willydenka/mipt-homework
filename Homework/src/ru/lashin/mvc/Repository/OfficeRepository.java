package ru.lashin.mvc.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.lashin.db.Employee;
import ru.lashin.mvc.DAO.DAO;

import java.util.List;

@Repository
public class OfficeRepository {
    private final DAO dao;

    @Autowired
    public OfficeRepository(DAO dao) {
        this.dao = dao;
    }

    public List<Employee> allEmployees() {
         return dao.findAll(Employee.class);
    }
}
