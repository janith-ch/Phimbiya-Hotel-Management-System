package lk.hotelManagement.backend.controller;

import lk.hotelManagement.backend.model.Reservation;
import lk.hotelManagement.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/")
    public List<Reservation> reservations() {
        return reservationService.reservations();
    }
}
