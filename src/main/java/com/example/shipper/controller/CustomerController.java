package com.example.shipper.controller;

import com.example.shipper.model.Order;
import com.example.shipper.model.Product;
import com.example.shipper.service.CustomerService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/customer/insert-order/{id}")
    public ResponseEntity<?> insertOrder(@PathVariable(name = "id") int idCustomer,
                                         @RequestBody List<Product> products){
        Order order = customerService.makeOrderWithNewProduct(idCustomer,products);
        return ResponseEntity.ok(order);
    }
    @PostMapping(value = "/customer/show-list-orders-complete/{id}")
    public ResponseEntity<?> showListOrdersComplete(@PathVariable(name = "id") int idCustomer){
        return ResponseEntity.ok(customerService.showListOrdersComplete(idCustomer));
    }
    @PostMapping(value = "/customer/vote-in-order/{id}")
    public ResponseEntity<?> voteOrderByCustomer(@PathVariable(name = "id") int idCustomer,
                                                 @RequestParam int vote){
        return ResponseEntity.ok("OK");
    }
}
