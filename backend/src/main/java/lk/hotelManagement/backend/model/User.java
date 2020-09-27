package lk.hotelManagement.backend.model;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address1;
    private String address2;
    private String city;
    private String contact;

}
