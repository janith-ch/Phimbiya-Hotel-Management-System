package lk.hotelManagement.backend.model;

import lombok.Data;

@Data
public class Supplier {
    private String supplierId;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String contact;
}
