package com.example.shipper.model.DTO;

import com.example.shipper.model.Product;
import com.example.shipper.model.eNum.StatusOrder;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    @NotNull
    private CustomerDTO customer;
    private float price;
    private StatusOrder status;
    @NotNull
    private String address;
    private Date time_order;
    private int estimate_time;
    private List<Product> products;
}
