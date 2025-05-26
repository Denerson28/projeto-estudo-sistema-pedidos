package com.microsservicos.customerservice.dto;

public class CustomerResponse {
    public Long id;
    public String name;
    public String email;

    public CustomerResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
