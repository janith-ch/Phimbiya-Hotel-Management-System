package lk.hotelManagement.backend.repository.mappers;
import lk.hotelManagement.backend.model.Supplier;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierRowMapper implements RowMapper<Supplier> {

    @Override
    public Supplier mapRow(ResultSet resultSet, int i) throws SQLException {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(resultSet.getString("supplier_id"));
        supplier.setFirstName(resultSet.getString("first_name"));
        supplier.setLastName(resultSet.getString("last_name"));
        supplier.setEmail(resultSet.getString("email"));
        supplier.setCity(resultSet.getString("city"));
        supplier.setContact(resultSet.getString("contact"));
        return supplier;
    }
}