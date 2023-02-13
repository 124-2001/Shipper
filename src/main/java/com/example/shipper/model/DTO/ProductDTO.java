package com.example.shipper.model.DTO;

import com.example.shipper.model.eNum.Quantity;
import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private float weight;
    private Quantity quantity;
}
