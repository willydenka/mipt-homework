package ru.lashin.mvc.HelloController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.lashin.db.Employee;
import ru.lashin.mvc.Repository.OfficeRepository;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private final OfficeRepository officeRepository;

    @Autowired
    public Controller(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @GetMapping("/")
    public String pageHello(Model model) {
        List<Employee> employees = officeRepository.allEmployees();
        model.addAttribute("employees", employees);
        return "helloPage.html";
    }
}
