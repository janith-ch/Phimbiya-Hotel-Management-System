package lk.hotelManagement.backend.controller;
import lk.hotelManagement.backend.model.Salary;
import lk.hotelManagement.backend.model.User;
import lk.hotelManagement.backend.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> salaries() {
        return salaryService.salaries();
    }

    @PostMapping("/")
    public boolean createSalary(@RequestBody Salary salary) {
        return salaryService.createSalary(salary);
    }
}
