package com.microsservicos.customerservice.controller;

import com.microsservicos.customerservice.dto.CustomerRequest;
import com.microsservicos.customerservice.dto.CustomerResponse;
import com.microsservicos.customerservice.entity.Customer;
import com.microsservicos.customerservice.service.interfaces.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponse create(@RequestBody @Valid CustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);

        Customer saved = customerService.save(customer);

        return new CustomerResponse(saved.getId(), saved.getName(), saved.getEmail());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(
                new CustomerResponse(customer.getId(), customer.getName(), customer.getEmail())
        );
    }
}

