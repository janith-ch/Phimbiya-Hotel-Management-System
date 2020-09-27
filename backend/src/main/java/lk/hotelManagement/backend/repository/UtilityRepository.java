package lk.hotelManagement.backend.repository;

import lk.hotelManagement.backend.model.Supplier;
import lk.hotelManagement.backend.model.Utility;
import lk.hotelManagement.backend.repository.mappers.SupplierRowMapper;
import lk.hotelManagement.backend.repository.mappers.UtilityRowMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilityRepository {

    @Autowired
    Logger logger;

    @Autowired
    @Qualifier("reservation-named-param-jdbc")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Utility> utilities() {
        try {
            String query = "SELECT * FROM UTILITIES";
            try {
                return namedParameterJdbcTemplate.query(query, new UtilityRowMapper());
            } catch (Exception e) {
                logger.error("Error getting utilities : {}", e.toString());
                throw new RuntimeException("Error getting utilities : {}" + e.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting utilities : " + e.getMessage());
        }
    }
}

