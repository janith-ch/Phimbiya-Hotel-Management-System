package lk.hotelManagement.backend.model;

import lombok.Data;

@Data
public class Utility {

    private String utilityId;
    private String month;
    private String electricityBill;
    private String waterBill;
    private String others;
    private String total;

}
