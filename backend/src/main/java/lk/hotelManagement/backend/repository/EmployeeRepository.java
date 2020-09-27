package lk.hotelManagement.backend.repository;
import lk.hotelManagement.backend.model.Employee;
import lk.hotelManagement.backend.repository.mappers.EmployeeRowMapper;
import lk.hotelManagement.backend.repository.mappers.SupplierRowMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    Logger logger;

    @Autowired
    @Qualifier("reservation-named-param-jdbc")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Employee> employees() {
        try {
            String query = "SELECT * FROM EMPLOYEES";
            try {
                return namedParameterJdbcTemplate.query(query, new EmployeeRowMapper());
            } catch (Exception e) {
                logger.error("Error getting employees : {}", e.toString());
                throw new RuntimeException("Error getting employees : {}" + e.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting employees : " + e.getMessage());
        }
    }
}