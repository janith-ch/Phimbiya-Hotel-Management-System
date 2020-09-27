package lk.hotelManagement.backend.repository;

import lk.hotelManagement.backend.model.Reservation;
import lk.hotelManagement.backend.model.User;
import lk.hotelManagement.backend.repository.mappers.ReservationRowMapper;
import lk.hotelManagement.backend.repository.mappers.UserRowMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepository {

    @Autowired
    Logger logger;

    @Autowired
    @Qualifier("reservation-named-param-jdbc")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Reservation> reservations() {
        try {
            String query = "SELECT * FROM RESERVATIONS";
            try {
                return namedParameterJdbcTemplate.query(query, new ReservationRowMapper());
            } catch (Exception e) {
                logger.error("Error getting reservation : {}", e.toString());
                throw new RuntimeException("Error getting reservation : {}" + e.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting reservation : " + e.getMessage());
        }
    }
}
