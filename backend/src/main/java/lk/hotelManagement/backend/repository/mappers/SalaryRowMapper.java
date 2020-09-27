package lk.hotelManagement.backend.repository.mappers;

import lk.hotelManagement.backend.model.Payment;
import lk.hotelManagement.backend.model.Salary;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryRowMapper implements RowMapper<Salary> {

    @Override
    public Salary mapRow(ResultSet resultSet, int i) throws SQLException {
        Salary salary = new Salary();
        salary.setSalaryId(resultSet.getString("salary_id"));
        salary.setPayDate(resultSet.getString("pay_date"));
        salary.setEmployeeId(resultSet.getString("employee_id"));
        salary.setBasicSalary(resultSet.getString("basic_salary"));
        salary.setSalaryAdvance(resultSet.getString("salary_advance"));
        salary.setPaymentType(resultSet.getString("payment_type"));
        salary.setNetPayment(resultSet.getString("net_payment"));

        return salary;
    }
}

