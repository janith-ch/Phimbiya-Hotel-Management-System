package lk.hotelManagement.backend.service;
import lk.hotelManagement.backend.model.Payment;
import lk.hotelManagement.backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> payments() {
        return paymentRepository.payments();
    }

}