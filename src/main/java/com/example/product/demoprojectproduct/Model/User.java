package com.example.product.demoprojectproduct.Model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection="user")
public class User {

    @Id
    private String userId;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String emailId;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password should be strong")
    private String pwd;
    @NotEmpty(message = "contact details are mandatory")
    private List<Contact> contact;
    @NotBlank(message = "Sex is mandatory")
    private String sex;
    @Min(value = 0, message = "Age should be positive")
    private int age;
    @NotNull(message = "Date of Birth is Mandatory")
    private String dob;
    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,15}$", message = "Username should be alphanumeric and can contain underscores and hyphens")
    private String userName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "First Name should not contain special characters")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name should not contain special characters")
    private String lastName;

    private LocalDateTime createdTime;
    private LocalDateTime lastLogin;

    @NotEmpty(message = "Address details are mandatory")
    private List<Address> address;


    private class Contact {
        @Pattern(regexp = "^(mobile|home|work)$", message = "Contact type should be 'mobile', 'home', or 'work'")
        private String type;
        @Pattern(regexp = "^[0-9]{10}$", message = "Contact number should be 10 digits")
        @NotBlank(message = "Contact number is mandatory")
        private String number;

    }

    private class Address {
        @NotBlank(message = "Address1 is mandatory")
        private String address1;

        private String address2;

        @NotBlank(message = "State is mandatory")
        private String state;

        @NotBlank(message = "City is mandatory")
        private String city;

        @Pattern(regexp = "^[0-9]{5,6}$", message = "Pin should be a 5 or 6 digit number")
        private String pin;

        @Pattern(regexp = "^[0-9]{10}$", message = "Contact number should be 10 digits")
        @NotBlank(message = "Contact number is mandatory")
        private String contactNo;

        @Pattern(regexp = "^[0-9]{10}$", message = "Alternate number should be 10 digits")
        private String alternateNo;
    }
}
