package com.example.shipper.model.DTO;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CustomerDTO {
    private String name;
    @NotNull
    private String phone;

}
