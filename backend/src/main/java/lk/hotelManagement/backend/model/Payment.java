package lk.hotelManagement.backend.model;

import lombok.Data;

@Data
public class Payment {
    private String paymentId;
    private String payDate;
    private String customerId;
    private String customerName;
    private String amount;
    private String discount;
    private String paymentType;
    private String netPayment;
}
