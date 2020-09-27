package lk.hotelManagement.backend.repository;

import lk.hotelManagement.backend.model.User;
import lk.hotelManagement.backend.repository.mappers.UserRowMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    @Autowired
    Logger logger;

    @Autowired
    @Qualifier("reservation-named-param-jdbc")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> users() {
        try {
            String query = "SELECT * FROM USERS";
            try {
                return namedParameterJdbcTemplate.query(query, new UserRowMapper());
            } catch (Exception e) {
                logger.error("Error getting users : {}", e.toString());
                throw new RuntimeException("Error getting users : {}" + e.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting users : " + e.getMessage());
        }
    }

    public boolean createUser(User user) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("firstName", user.getFirstName());
            params.put("lastName", user.getLastName());
            params.put("email", user.getEmail());
            params.put("password", user.getPassword());
            params.put("address1", user.getAddress1());
            params.put("address2", user.getAddress2());
            params.put("city", user.getCity());
            params.put("contact", user.getContact());

        String query = "INSERT INTO `users` (`user_id`,`first_name`, `last_name`, `email`,`password`,`address_1`,`address_2`,`city`,`contact`)" +
                " VALUES (NULL,:firstName, :lastName,:email,:password,:address1,:address2,:city,:contact )";

            int i = namedParameterJdbcTemplate.update(query, params);
            if (i == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("Error getting users : {}", e.toString());
            throw new RuntimeException("Error getting users : " + e.getMessage());
        }
    }
}
