package lk.hotelManagement.backend.repository.mappers;

import lk.hotelManagement.backend.model.Stock;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockRowMapper implements RowMapper<Stock> {

    @Override
    public Stock mapRow(ResultSet resultSet, int i) throws SQLException {
        Stock stock = new Stock();
        stock.setItemCode(resultSet.getString("item_id"));
        stock.setItemName(resultSet.getString("item_name"));
        stock.setPrice(resultSet.getString("price"));
        stock.setQuantity(resultSet.getString("quantity"));
        return stock;
    }
}
