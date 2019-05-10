package com.tsz.cust.controller;

import com.tsz.cust.exception.ResourceNotFoundException;
import com.tsz.cust.model.Customer;
import com.tsz.cust.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public Page<Customer> getCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
    }
    

    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId,
                                   @Valid @RequestBody Customer customerRequest) {
        return customerRepository.findById(customerId)
                .map(customer -> {
                	customer.setFirstName(customerRequest.getFirstName());
                    customer.setLastName(customerRequest.getLastName());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
    }


    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        return customerRepository.findById(customerId)
                .map(question -> {
                	customerRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
    }
}