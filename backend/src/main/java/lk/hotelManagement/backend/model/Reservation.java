package lk.hotelManagement.backend.model;
import lombok.Data;

@Data

public class Reservation {
    private String reservationId;
    private String checkIN;
    private String checkOut;
    private String children;
    private String adults;
    private String rooms;
}
