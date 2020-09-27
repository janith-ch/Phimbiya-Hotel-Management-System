package lk.hotelManagement.backend.service;
import lk.hotelManagement.backend.model.Salary;
import lk.hotelManagement.backend.model.User;
import lk.hotelManagement.backend.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    public List<Salary> salaries() {
        return salaryRepository.salaries();
    }
    public boolean createSalary(Salary salary) {
        return salaryRepository.createSalary(salary);
    }

}