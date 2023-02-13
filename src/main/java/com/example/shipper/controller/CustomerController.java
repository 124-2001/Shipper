package com.example.shipper.controller;

import com.example.shipper.model.Product;
import com.example.shipper.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/customer/insert-order/{id}")
    public ResponseEntity<?> insertOrder(@PathVariable(name = "id") int idCustomer,
                                         @RequestBody Product product){
        return ResponseEntity.ok("OK");
    }
}
