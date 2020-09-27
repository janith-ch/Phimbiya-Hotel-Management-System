package lk.hotelManagement.backend.repository.mappers;

import lk.hotelManagement.backend.model.Room;
import lk.hotelManagement.backend.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomRowMapper implements RowMapper<Room> {

    @Override
    public Room mapRow(ResultSet resultSet, int i) throws SQLException {
        Room room = new Room();
        room.setRoomId(resultSet.getString("room_id"));
        room.setRoomName(resultSet.getString("room_name"));
        room.setRoomType(resultSet.getString("room_type"));
        room.setDescription(resultSet.getString("description"));
        return room;
    }
}