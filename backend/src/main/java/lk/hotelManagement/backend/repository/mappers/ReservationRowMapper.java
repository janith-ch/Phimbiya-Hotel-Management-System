package lk.hotelManagement.backend.repository.mappers;

import lk.hotelManagement.backend.model.Reservation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationRowMapper implements RowMapper<Reservation> {

    @Override
    public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setReservationId(resultSet.getString("reservation_id"));
        reservation.setCheckIN(resultSet.getString("check_in"));
        reservation.setCheckOut(resultSet.getString("check_out"));
        reservation.setChildren(resultSet.getString("children"));
        reservation.setAdults(resultSet.getString("adults"));
        reservation.setRooms(resultSet.getString("rooms"));
        return reservation;
    }
}
