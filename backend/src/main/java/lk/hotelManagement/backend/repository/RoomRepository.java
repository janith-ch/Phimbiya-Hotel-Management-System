package lk.hotelManagement.backend.repository;

import lk.hotelManagement.backend.model.Room;
import lk.hotelManagement.backend.model.User;
import lk.hotelManagement.backend.repository.mappers.RoomRowMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoomRepository {

    @Autowired
    Logger logger;

    @Autowired
    @Qualifier("reservation-named-param-jdbc")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Room> rooms() {
        try {
            String query = "SELECT * FROM ROOMS";
            try {
                return namedParameterJdbcTemplate.query(query, new RoomRowMapper());
            } catch (Exception e) {
                logger.error("Error getting rooms : {}", e.toString());
                throw new RuntimeException("Error getting rooms : {}" + e.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting rooms : " + e.getMessage());
        }
    }

    public boolean createRoom(Room room) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("roomName", room.getRoomName());
            params.put("roomType", room.getRoomType());
            params.put("roomDescription", room.getDescription());


            String query = "INSERT INTO `rooms` (`room_id`,`room_name`, `room_type`, `description`)" +
                    " VALUES (NULL,:roomName, :roomType,:roomDescription)";

            int i = namedParameterJdbcTemplate.update(query, params);
            if (i == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("Error getting rooms : {}", e.toString());
            throw new RuntimeException("Error getting rooms : " + e.getMessage());
        }
    }
}
