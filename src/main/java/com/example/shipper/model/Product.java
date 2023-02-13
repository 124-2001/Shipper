package com.example.shipper.model;

import com.example.shipper.model.eNum.Quantity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float weight;
    private Quantity quantity;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order order;
}
