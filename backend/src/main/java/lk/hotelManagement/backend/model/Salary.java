package lk.hotelManagement.backend.model;

import lombok.Data;

@Data
public class Salary {

    private String salaryId;
    private String payDate;
    private String employeeId;
    private String basicSalary;
    private String salaryAdvance;
    private String paymentType;
    private String netPayment;

}
