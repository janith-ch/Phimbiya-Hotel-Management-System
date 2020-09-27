package lk.hotelManagement.backend.repository.mappers;

import lk.hotelManagement.backend.model.Payment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentRowMapper implements RowMapper<Payment> {

    @Override
    public Payment mapRow(ResultSet resultSet, int i) throws SQLException {
        Payment payment = new Payment();
        payment.setPaymentId(resultSet.getString("payment_id"));
        payment.setPayDate(resultSet.getString("pay_date"));
        payment.setCustomerId(resultSet.getString("customer_id"));
        payment.setCustomerName(resultSet.getString("customer_name"));
        payment.setAmount(resultSet.getString("amount"));
        payment.setDiscount(resultSet.getString("discount"));
        payment.setPaymentType(resultSet.getString("pay_type"));
        payment.setNetPayment(resultSet.getString("net_pay"));
        return payment;
    }
}

