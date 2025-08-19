package com.backend.restro.model;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String name;
    private String email;
    private String password;
    private Long phoneNumber;
}
