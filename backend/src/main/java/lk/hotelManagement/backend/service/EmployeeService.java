package lk.hotelManagement.backend.service;
import lk.hotelManagement.backend.model.Employee;
import lk.hotelManagement.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> employees() {
        return employeeRepository.employees();
    }

}

