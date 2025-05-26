package com.microsservicos.customerservice.service.interfaces;

import com.microsservicos.customerservice.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(Long id);
    List<Customer> findAll();
    Customer save(Customer customer);
    void delete(Long id);
}