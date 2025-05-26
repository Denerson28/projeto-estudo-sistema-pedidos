package com.microsservicos.customerservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CustomerRequest {

    @NotBlank(message = "Name is required")
    public String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    public String email;
}
