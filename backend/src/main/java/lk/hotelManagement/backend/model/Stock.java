package lk.hotelManagement.backend.model;

import lombok.Data;

@Data
public class Stock {
    private String itemCode;
    private String itemName;
    private String price;
    private String quantity;
}
