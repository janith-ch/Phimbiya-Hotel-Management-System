package lk.hotelManagement.backend.repository;

import lk.hotelManagement.backend.model.Payment;
import lk.hotelManagement.backend.model.User;
import lk.hotelManagement.backend.repository.mappers.PaymentRowMapper;
import lk.hotelManagement.backend.repository.mappers.UserRowMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepository {

    @Autowired
    Logger logger;

    @Autowired
    @Qualifier("reservation-named-param-jdbc")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Payment> payments() {
        try {
            String query = "SELECT * FROM PAYMENTS";
            try {
                return namedParameterJdbcTemplate.query(query, new PaymentRowMapper());
            } catch (Exception e) {
                logger.error("Error getting payments : {}", e.toString());
                throw new RuntimeException("Error getting payments : {}" + e.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting payments : " + e.getMessage());
        }
    }
}