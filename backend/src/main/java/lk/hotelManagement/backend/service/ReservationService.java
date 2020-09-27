package lk.hotelManagement.backend.service;

import lk.hotelManagement.backend.model.Reservation;
import lk.hotelManagement.backend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> reservations() {
        return reservationRepository.reservations();
    }

}