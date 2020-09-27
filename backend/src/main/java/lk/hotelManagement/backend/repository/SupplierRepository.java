package lk.hotelManagement.backend.repository;
import lk.hotelManagement.backend.model.Supplier;
import lk.hotelManagement.backend.model.User;
import lk.hotelManagement.backend.repository.mappers.SupplierRowMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SupplierRepository {

    @Autowired
    Logger logger;

    @Autowired
    @Qualifier("reservation-named-param-jdbc")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Supplier> suppliers() {
        try {
            String query = "SELECT * FROM SUPPLIERS";
            try {
                return namedParameterJdbcTemplate.query(query, new SupplierRowMapper());
            } catch (Exception e) {
                logger.error("Error getting suppliers : {}", e.toString());
                throw new RuntimeException("Error getting suppliers : {}" + e.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting suppliers : " + e.getMessage());
        }
    }


    public boolean createSupplier(Supplier supplier) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("supplierId", supplier.getSupplierId());
            params.put("firstName", supplier.getFirstName());
            params.put("lastName", supplier.getLastName());
            params.put("email", supplier.getEmail());
            params.put("city", supplier.getCity());
            params.put("contact", supplier.getContact());

            String query = "INSERT INTO `suppliers` (`supplier_id`,`first_name`, `last_name`, `email`,`city`,`contact`)" +
                    " VALUES (NULL,:firstName, :lastName,:email,:city,:contact )";

            int i = namedParameterJdbcTemplate.update(query, params);
            if (i == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("Error getting supplier: {}", e.toString());
            throw new RuntimeException("Error getting supplier : " + e.getMessage());
        }
    }
}
