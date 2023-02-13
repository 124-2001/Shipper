package com.example.shipper.controller;

import com.example.shipper.service.OrderService;
import com.example.shipper.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipperController {
    @Autowired
    ShipperService shipperService;
    @Autowired
    OrderService orderService;

    @PostMapping(value = "/shipper/show-new-list-order")
    public ResponseEntity<?> showListNewOrder(){
        return ResponseEntity.ok(shipperService.getListOrdersWaiting());
    }

    @PostMapping(value = "/shipper/get-new-order/{id}")
    public ResponseEntity<?> getNewOrder(@RequestParam int idOrder,@PathVariable(name = "id") int idShipper){
        return ResponseEntity.ok(shipperService.getNewOrderById(idOrder,idShipper));
    }

    @PostMapping(value = "shipper/update-successfully/{id}")
    public ResponseEntity<?> updateOrderByShipper(@PathVariable(name = "id") int idShipper,
                                                  @RequestParam int idOrder){
        return ResponseEntity.ok(shipperService.updateOrderAndSalary(idOrder,idShipper));
    }

}
