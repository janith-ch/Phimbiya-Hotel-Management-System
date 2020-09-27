package lk.hotelManagement.backend.repository.mappers;
import lk.hotelManagement.backend.model.Utility;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityRowMapper implements RowMapper<Utility> {

    @Override
    public Utility mapRow(ResultSet resultSet, int i) throws SQLException {
        Utility utility = new Utility();
        utility.setUtilityId(resultSet.getString("utility_id"));
        utility.setMonth(resultSet.getString("month"));
        utility.setElectricityBill(resultSet.getString("electricity_bill"));
        utility.setWaterBill(resultSet.getString("water_bill"));
        utility.setOthers(resultSet.getString("others"));
        utility.setTotal(resultSet.getString("total"));
        return utility;
    }
}
