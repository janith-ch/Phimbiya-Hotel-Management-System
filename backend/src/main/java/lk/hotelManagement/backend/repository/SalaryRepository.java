package lk.hotelManagement.backend.repository;
import lk.hotelManagement.backend.model.Salary;
import lk.hotelManagement.backend.repository.mappers.SalaryRowMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SalaryRepository {

    @Autowired
    Logger logger;

    @Autowired
    @Qualifier("reservation-named-param-jdbc")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Salary> salaries() {
        try {
            String query = "SELECT * FROM SALARIES";
            try {
                return namedParameterJdbcTemplate.query(query, new SalaryRowMapper());
            } catch (Exception e) {
                logger.error("Error getting salaries : {}", e.toString());
                throw new RuntimeException("Error getting salaries : {}" + e.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting salaries : " + e.getMessage());
        }
    }
    public boolean createSalary(Salary salary) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("SalaryId", salary.getSalaryId());
            params.put("PayDate", salary.getPayDate());
            params.put("EmployeeId", salary.getEmployeeId());
            params.put("BasicSalary", salary.getBasicSalary());
            params.put("SalaryAdvance", salary.getSalaryAdvance());
            params.put("PaymentType", salary.getPaymentType());
            params.put("NetPayment", salary.getNetPayment());

            String query = "INSERT INTO `salaries` (`salary_id`,`pay_date`, `employee_id`, `basic_salary`,`salary_advance`,`payment_type`,`net_payment`)" +
                    " VALUES (NULL,:PayDate, :EmployeeId,:BasicSalary,:SalaryAdvance,:PaymentType,:NetPayment, )";

            int i = namedParameterJdbcTemplate.update(query, params);
            if (i == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("Error getting salaries : {}", e.toString());
            throw new RuntimeException("Error getting salaries : " + e.getMessage());
        }
    }
}