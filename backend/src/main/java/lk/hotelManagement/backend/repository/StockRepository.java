package lk.hotelManagement.backend.repository;

import lk.hotelManagement.backend.model.Stock;
import lk.hotelManagement.backend.model.User;
import lk.hotelManagement.backend.repository.mappers.StockRowMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StockRepository {

    @Autowired
    Logger logger;

    @Autowired
    @Qualifier("reservation-named-param-jdbc")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Stock> stocks() {
        try {
            String query = "SELECT * FROM STOCK";
            try {
                return namedParameterJdbcTemplate.query(query, new StockRowMapper());
            } catch (Exception e) {
                logger.error("Error getting stock : {}", e.toString());
                throw new RuntimeException("Error getting stock : {}" + e.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting stock : " + e.getMessage());
        }
    }

    public boolean createStock(Stock stock) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("ItemCode", stock.getItemCode());
            params.put("ItemName", stock.getItemName());
            params.put("Price", stock.getPrice());
            params.put("Quantity", stock.getQuantity());

            String query = "INSERT INTO `stock` (`item_id`,`item_name`, `price`, `quantity`)" +
                    " VALUES (NULL,:ItemName, :Price,:Quantity)";

            int i = namedParameterJdbcTemplate.update(query, params);
            if (i == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("Error getting stocks : {}", e.toString());
            throw new RuntimeException("Error getting stocks : " + e.getMessage());
        }
    }
}
